package com.practica01.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    final String BucketName = "practica01-270f8.appspot.com";

    final String rutaSuperiorStorage = "practica01";

    final String rutaJsonFile = "firebase";
    
    final String archivoJsonFile = "practica01-270f8-firebase-adminsdk-m55im-53026b947b.json";
}