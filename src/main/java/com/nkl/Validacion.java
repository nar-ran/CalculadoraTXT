package com.nkl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacion {
    private int validacion = 0;

    public int validarTexto(String text) {
        /*
        * Primero debo validar los tipos de datos, que no sean caracteres como lo es una letra
        * Segundo, validar que solo contenga los signos de operaciones básicas.
        * Tercero, validar que no tenga operadores diferentes a los especificados.
        * Cuarto, validar que el orden de los signos sea correcto.
        */

        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(text);

        if(matcher.find()){ // Validación de tipo de caracteres del txt
            validacion = 1;
            System.err.println("El archivo txt contiene letras.");
        }else if(!Pattern.compile("[-+*/]").matcher(text).find()){ // Validacion de signos de operación
            validacion = 2;
            System.err.println("La operación no es valida para calcular.");
        }else if(Pattern.compile("").matcher(text).find()){
            validacion = 3;
            System.err.println("EL archivo contiene caracteres invalidos");
        }

        return validacion;
    }
}
