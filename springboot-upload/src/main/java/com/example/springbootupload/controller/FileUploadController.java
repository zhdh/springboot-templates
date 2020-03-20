package com.example.springbootupload.controller;

import com.example.springbootupload.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Autowired
    FileService fileService;

    @PostMapping(value = "/upload",consumes = "multipart/form-data")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        fileService.uploadFile(file.getOriginalFilename(),file);
        return "success";
    }

}
