package ru.magenta.distancecalculator.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface FileService {
    ResponseEntity<?> saveRequestToDB(MultipartFile multipartFile);
}
