package com.example.prueba.response;

import com.example.prueba.jpa.Usuario;

import java.time.LocalDateTime;
import java.util.UUID;

public class RegistroUsuarioResponse {
    private UUID id;

    private LocalDateTime created;
    private LocalDateTime modified;
    private LocalDateTime lastLogin;
    private String token;
    private boolean isActive;

    public RegistroUsuarioResponse(Usuario usuario) {
        this.id = usuario.getId();
        this.created = usuario.getCreated();
        this.modified = usuario.getModified();
        this.lastLogin = usuario.getLastLogin();
        this.token = usuario.getToken();
        this.isActive = usuario.isActive();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
