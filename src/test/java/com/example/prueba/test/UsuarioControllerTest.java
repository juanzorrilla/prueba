package com.example.prueba.test;

import com.example.prueba.controller.UsuarioController;
import com.example.prueba.jpa.Usuario;
import com.example.prueba.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class UsuarioControllerTest {
    private MockMvc mockMvc;

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void registrarUsuario_Exitoso() throws Exception {
        Usuario usuario = new Usuario("Juan Rodríguez", "juan@rodriguez.org", "hunter2", true);

        when(usuarioService.guardarUsuario(any(Usuario.class))).thenReturn(usuario);

        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.created").value(usuario.getCreated()))
                .andExpect(jsonPath("$.active").value(usuario.isActive()));

        verify(usuarioService, times(1)).guardarUsuario(any(Usuario.class));
    }

    @Test
    void registrarUsuario_FalloPorEmailDuplicado() throws Exception {
        Usuario usuario = new Usuario("Juan Rodríguez", "juan@rodriguez.org", "hunter2", true);

        when(usuarioService.guardarUsuario(any(Usuario.class))).thenThrow(new RuntimeException("El correo ya está registrado"));

        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.mensaje").value("El correo ya está registrado"));
    }
}
