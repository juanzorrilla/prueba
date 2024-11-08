package com.example.prueba.utils;

public class ApiException{
    private String mensaje;

    public ApiException(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "ApiException{" +
                "mensaje='" + mensaje + '\'' +
                '}';
    }
}
