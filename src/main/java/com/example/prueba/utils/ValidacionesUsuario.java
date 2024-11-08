package com.example.prueba.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Component
public class ValidacionesUsuario {

    @Value("${password.regex}")
    private String passwordRegex;

    @Value("${password.format.message}")
    private String passwordValMsj;

    public static final String EMAIL_PATTERN = "^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$";

    public void validarFormatoCorreo(String correo){
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(correo);
        if(!matcher.matches()){
            throw new RuntimeException("Formato de correo invalido");
        }
    }

    public void validarPassword(String password){
        if (!password.matches(passwordRegex)){
            throw new RuntimeException("La contraseña no cumple con los requisitos requeridos. "+passwordValMsj);
        }
    }
}
