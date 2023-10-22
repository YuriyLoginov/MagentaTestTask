package ru.magenta.distancecalculator.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/fileServer")
public class FileUploadController {

    // upload city
    // upload distance
    // upload all

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam MultipartFile multipartFile) {

        return null;
    }
}
