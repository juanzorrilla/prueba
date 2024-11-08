package com.example.prueba.service;

import com.example.prueba.dao.UsuarioRepository;
import com.example.prueba.jpa.Usuario;
import com.example.prueba.utils.ValidacionesUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ValidacionesUsuario validacionesUsuario;

    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario guardarUsuario(Usuario usuario) {
        if(correoRegistrado(usuario.getEmail())){
            throw new RuntimeException("El correo ya está registrado");
        }
        validacionesUsuario.validarFormatoCorreo(usuario.getEmail());
        validacionesUsuario.validarPassword(usuario.getPassword());
        return usuarioRepository.save(usuario);
    }

    private boolean correoRegistrado(String email) {
        return usuarioRepository.findByEmail(email).isPresent();
    }
}
