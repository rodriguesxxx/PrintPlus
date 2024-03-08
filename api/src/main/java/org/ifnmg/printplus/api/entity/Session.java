package org.ifnmg.printplus.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "sessions")
public class Session {
    
    @Id
    @Column(name = "session_id", length = 4)
    private String sessionId;

    @OneToMany
    @JoinColumn(name = "session_id")
    public List<FileEntity> files;

    public Session() {}

    public Session(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
