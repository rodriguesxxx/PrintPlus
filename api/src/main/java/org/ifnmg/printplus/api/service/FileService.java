package org.ifnmg.printplus.api.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.ifnmg.printplus.api.model.File;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FileService {
    
    private File file;

    @Value("${storage.path}")
    private String path;

    public FileService() {}

    public FileService(File file) {
        this.file = file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void save(String sessionId) throws IOException {

        java.io.File newPath = new java.io.File(path + sessionId);
        if(!newPath.exists()) {
            newPath.mkdirs();
        }

        String finalPath = newPath.getAbsolutePath() + "/" + file.getFilename();
        Files.copy(file.getInputStream(), Path.of(finalPath), StandardCopyOption.REPLACE_EXISTING);

    }
}
