package ru.magenta.distancecalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.magenta.distancecalculator.service.impl.FileServiceImpl;

import java.util.Optional;

@RestController
@RequestMapping("/fileServer")
public class FileUploadController {

    private final FileServiceImpl fileService;

    @Autowired
    public FileUploadController(FileServiceImpl fileService) {
        this.fileService = fileService;
    }

    @PostMapping(value = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE})
    public String uploadFile(@Validated @RequestParam("file") MultipartFile multipartFile) {
        fileService.saveRequestToDB(multipartFile);
        return "200";
    }
}
