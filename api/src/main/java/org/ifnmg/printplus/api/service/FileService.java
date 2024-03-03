package org.ifnmg.printplus.api.service;

import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
    
    private MultipartFile file;

    @Value("${storage.path}")
    private String path;

    public FileService() {}

    public FileService(MultipartFile file) {
        this.file = file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public void save(String sessionId) throws IOException {

        File newPath = new File(path + sessionId);
        if(!newPath.exists()) {
            newPath.mkdirs();
        }

        String finalPath = newPath.getAbsolutePath() + "/" + file.getOriginalFilename();
        Files.copy(file.getInputStream(), Path.of(finalPath), StandardCopyOption.REPLACE_EXISTING);
    }
}
