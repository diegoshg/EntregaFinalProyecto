/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *Esta clase sirve para validar el email que introducimos al crear cuenta.
 * @author Diego Sanchez Gandara
 */
public class ValidadorEmail {
    private static final String PATRON_EMAIL =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    private final Pattern pattern;

    public ValidadorEmail() {
        pattern = Pattern.compile(PATRON_EMAIL);
    }

    public boolean validarEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
