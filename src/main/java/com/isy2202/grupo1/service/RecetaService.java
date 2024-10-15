package com.isy2202.grupo1.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.Firestore;
import com.isy2202.grupo1.model.Receta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class RecetaService {

    @Autowired
    private Firestore firestore;

    public List<Receta> obtenerRecetas() throws ExecutionException, InterruptedException {
        List<Receta> recetas = new ArrayList<>();
        CollectionReference recetasRef = firestore.collection("recetas");
        ApiFuture<QuerySnapshot> future = recetasRef.get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        for (QueryDocumentSnapshot document : documents) {
            Receta receta = document.toObject(Receta.class);
            receta.setId(document.getId());
            recetas.add(receta);
        }
        return recetas;
    }

    public Receta getRecetaById(String id) throws ExecutionException, InterruptedException {
        return firestore.collection("recetas").document(id).get().get().toObject(Receta.class);
    }
}