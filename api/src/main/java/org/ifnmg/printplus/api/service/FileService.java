package org.ifnmg.printplus.api.service;

import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.ifnmg.printplus.api.entity.FileEntity;
import org.ifnmg.printplus.api.entity.Session;
import org.ifnmg.printplus.api.exceptions.InvalidSessionException;
import org.ifnmg.printplus.api.repository.IFileRepository;
import org.ifnmg.printplus.api.repository.ISessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private IFileRepository fileRepository;

    @Autowired
    private ISessionRepository sessionRepository;

    @Value("${storage.path}")
    private String path;

    public FileService() {}


    public void save(MultipartFile file, String sessionId) throws IOException, InvalidSessionException {
        Session session = sessionService.isValidSessionId(sessionId);
        File newPath = new File(path + session.getSessionId());

        if(!newPath.exists()) {
            newPath.mkdirs();
        }

        String finalPath = newPath.getAbsolutePath() + "/" + file.getOriginalFilename();
        Files.copy(file.getInputStream(), Path.of(finalPath), StandardCopyOption.REPLACE_EXISTING);
        FileEntity fileEntity = new FileEntity(file.getOriginalFilename());
        session.files.add(fileEntity);
        fileRepository.save(fileEntity);
        sessionRepository.save(session);
    }

    public Resource getFileResource(String sessionId, String fileId) throws Exception {
        FileEntity file = fileRepository.findById(fileId).get();
        Path filePath = Paths.get(path+sessionId).resolve(file.getFilename()).normalize();
        Resource resource = new UrlResource(filePath.toUri());
        if(!resource.exists()) {
            throw new Exception("Arquivo inexistente");
        }
        return resource;
    }
}
