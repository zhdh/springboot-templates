package com.example.springbootupload.service;


import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    public void uploadFile(String name, MultipartFile multipartFile) throws IOException;

}
