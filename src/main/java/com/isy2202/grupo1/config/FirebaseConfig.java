package com.isy2202.grupo1.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {

    @Bean
    public Firestore initialize() throws IOException {
        if (FirebaseApp.getApps().isEmpty()) {  // Verificar si FirebaseApp ya está inicializado
            FileInputStream serviceAccount =
                new FileInputStream("src/main/resources/isy2202.json"); // Ruta a tu archivo JSON

            FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

            FirebaseApp.initializeApp(options);
        }

        return FirestoreClient.getFirestore();
    }
}