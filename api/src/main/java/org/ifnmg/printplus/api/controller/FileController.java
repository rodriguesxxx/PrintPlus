package org.ifnmg.printplus.api.controller;

import org.ifnmg.printplus.api.model.Response;
import org.ifnmg.printplus.api.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<Response> upload(@RequestParam("file") MultipartFile file, @RequestParam("session_id") String sessionId) {

        fileService.setFile(file);

        try {
            fileService.save(sessionId);
            return ResponseEntity
                .status(HttpStatus.OK)
                .body(new Response<>("Arquivo salvo com sucesso!!!", HttpStatus.OK.value()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Response<>("Erro inesperado ao salvar arquivo!", HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }
}