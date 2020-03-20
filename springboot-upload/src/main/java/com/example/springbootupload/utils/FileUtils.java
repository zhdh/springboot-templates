package com.example.springbootupload.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Objects;

public class FileUtils {

    /**
     * 写文件
     */
    public static void write(String target, InputStream src) throws IOException{
        OutputStream os = new FileOutputStream(target);
        byte[] buf = new byte[1024];
        int length;
        while(-1!=(length = src.read(buf))){
            os.write(buf,0,length);
        }
        src.close();
        os.close();
    }

    /**
     * 分块写入文件
     */
    public static void writeWithBlock(String target, Long targetSize, InputStream src, Long srcSize, Integer chunks, Integer chunk) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(target,"rw");
        randomAccessFile.setLength(targetSize);
        if (chunk == chunks - 1 && chunk != 0) {
            randomAccessFile.seek(chunk * (targetSize - srcSize) / chunk);
        } else {
            randomAccessFile.seek(chunk * srcSize);
        }
        byte[] buf = new byte[1024];
        int len;
        while (-1 != (len = src.read(buf))) {
            randomAccessFile.write(buf,0,len);
        }
        randomAccessFile.close();
    }

    /**
     * 获取文件扩展名
     */
    public static String getExt(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        return Objects.requireNonNull(fileName).substring(fileName.lastIndexOf(".") + 1);
    }

}
