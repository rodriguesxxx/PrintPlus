package org.ifnmg.printplus.api.service;

import java.util.Optional;
import org.ifnmg.printplus.api.entity.Session;
import org.ifnmg.printplus.api.repository.ISessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    
    @Autowired
    private ISessionRepository sessionRepository;

    public Session isValidSessionId(String sessionId) throws Exception {
        Optional<Session> session = sessionRepository.findById(sessionId);
        if(session.isEmpty()) {
            throw new Exception("Sessão inexistente!");
        }
        return session.get();
    }
}
