package com.example.springbootupload.service.impl;

import com.example.springbootupload.config.GlobalConfig;
import com.example.springbootupload.service.FileService;
import com.example.springbootupload.utils.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public void uploadFile(String name, MultipartFile multipartFile) throws IOException {
        String path = GlobalConfig.fileUploadPath + System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
        FileUtils.write(path,multipartFile.getInputStream());
    }
}
