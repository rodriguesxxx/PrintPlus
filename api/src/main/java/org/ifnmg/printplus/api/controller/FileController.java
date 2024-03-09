package org.ifnmg.printplus.api.controller;

import java.util.List;

import org.ifnmg.printplus.api.entity.FileEntity;
import org.ifnmg.printplus.api.model.Response;
import org.ifnmg.printplus.api.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("${base.endpoint}"+"/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping("/{session_id}/download/{file}")
    public ResponseEntity<?> download(@PathVariable("session_id") String sessionId, @PathVariable("file") String fileId) {
        
        try {
            Resource resource = fileService.getFileResource(sessionId, fileId);
            HttpHeaders headers = new HttpHeaders();

            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", resource.getFilename());
            
            return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
        } catch(Exception e) {
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Response<>("Erro inesperado ao baixar arquivo!", HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<Response> upload(@RequestParam("file") MultipartFile file, @RequestParam("session_id") String sessionId) {

        try {
            fileService.save(file, sessionId);
            return ResponseEntity
                .status(HttpStatus.OK)
                .body(new Response<>("Arquivo salvo com sucesso!!!", HttpStatus.OK.value()));
        } catch (Exception e) {
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Response<>("Erro inesperado ao salvar arquivo!", HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }
}