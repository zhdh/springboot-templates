package com.example.springbootupload.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalConfig {

    public static String fileUploadPath;

    @Value("${file.upload.path}")
    public void setPath(String fileUploadPath){
        GlobalConfig.fileUploadPath = fileUploadPath;
    }

}
