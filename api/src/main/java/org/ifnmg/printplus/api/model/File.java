package org.ifnmg.printplus.api.model;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public class File {
    
    private MultipartFile file;
    
    public File() {}

    public File(MultipartFile file) {
        setFile(file);
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public InputStream getInputStream() throws IOException{
        return file.getInputStream();
    }
    
    public String getFilename() {
        return file.getOriginalFilename();
    }

    public String getFileExtension() {
        int index = getFilename().lastIndexOf(".");
        String extension = getFilename().substring(index+1);
        return extension;
    }
}
