package org.ifnmg.printplus.api.controller;

import org.ifnmg.printplus.api.entity.Session;
import org.ifnmg.printplus.api.model.Response;
import org.ifnmg.printplus.api.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/session")
public class SessionController {
    
    @Autowired
    private SessionService sessionService;

    @GetMapping("/{session_id}")
    public ResponseEntity<Response> show(@PathVariable("session_id") String sessionId) {
        try {
            Session session = sessionService.isValidSessionId(sessionId);
            return ResponseEntity
                .status(HttpStatus.OK)
                .body(new Response<>("Sucesso ao retornar sessão", HttpStatus.OK.value(), session));
        } catch (Exception e) {
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Response<>("Erro interno ao buscar sessão", HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }
}
