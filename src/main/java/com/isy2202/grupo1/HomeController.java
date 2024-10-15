package com.isy2202.grupo1;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.isy2202.grupo1.model.Receta;
import com.isy2202.grupo1.service.RecetaService;

@Controller
public class HomeController {
    
    @Autowired
    private RecetaService recetaService;

    @GetMapping("/home")
    public String home(Model model) throws ExecutionException, InterruptedException {
        List<Receta> recetas = recetaService.obtenerRecetas();
        model.addAttribute("recetas", recetas); 
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/recetas/{id}")
    public String detalleReceta(@PathVariable("id") String id, Model model) {
        try {
            Receta receta = recetaService.getRecetaById(id);
            model.addAttribute("receta", receta);
            return "detalle-receta";
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return "error";
        }
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }
}
