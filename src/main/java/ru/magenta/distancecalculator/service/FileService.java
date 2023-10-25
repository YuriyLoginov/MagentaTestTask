package ru.magenta.distancecalculator.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    ResponseEntity<?> saveRequestToDB(MultipartFile multipartFile);
}
