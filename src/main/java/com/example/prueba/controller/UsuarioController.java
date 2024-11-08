package com.example.prueba.controller;

import com.example.prueba.jpa.Usuario;
import com.example.prueba.response.RegistroUsuarioResponse;
import com.example.prueba.service.UsuarioService;
import com.example.prueba.utils.ApiException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioService.obtenerTodos();
    }

    @PostMapping
    public ResponseEntity<?> agregarUsuario(@Valid @RequestBody Usuario usuario) {
        try {
            Usuario nuevoUsuario = usuarioService.guardarUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(new RegistroUsuarioResponse(nuevoUsuario));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiException(ex.getMessage()));
        }
    }
}
