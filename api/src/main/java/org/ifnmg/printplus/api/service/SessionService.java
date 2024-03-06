package org.ifnmg.printplus.api.service;

import java.util.Optional;
import org.ifnmg.printplus.api.entity.Session;
import org.ifnmg.printplus.api.exceptions.InvalidSessionException;
import org.ifnmg.printplus.api.repository.ISessionRepository;
import org.ifnmg.printplus.api.util.WordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    
    @Autowired
    private ISessionRepository sessionRepository;

    @Autowired
    private WordGenerator wGenerator;

    public Session createSession() {
        String sessionId = wGenerator.generate(4);
        if(sessionRepository.existsById(sessionId)) {
            createSession();
        }
        return sessionRepository.save(new Session(sessionId));
    }

    public Session isValidSessionId(String sessionId) throws InvalidSessionException {
        Optional<Session> session = sessionRepository.findById(sessionId);
        if(session.isEmpty()) {
            throw new InvalidSessionException();
        }
        return session.get();
    }


}
