package com.nkl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacion {
    private int validacion = 0;

    public int txtValido(String text) {

        /*
        * Primero debo validar los tipos de datos, que no sean caracteres como lo es una letra
        * Segundo, validar que el orden de los signos sea correcto.
        * Tercero, validar que solo contenga los signos de operaciones basicas.
        * Cuarto, validar que no tetnga operadores diferentes a los especificados.
        *
        * */

        Pattern pattern = Pattern.compile("[a-zA-Z]");
        // Para realizar operaciones de coincidencia con un patron
        Matcher matcher = pattern.matcher(text);

        // Validación de tipo de caracteres del txt
        if(matcher.find()){
            validacion = 1;
            System.err.println("El archivo txt contiene letras.");
        }

        // Validacion de signos de operación
        if(!Pattern.compile("[-+*/]").matcher(text).find()){
            validacion = 2;
            System.err.println("El archivo no contiene ninguna de las operaciones basicas");
        }


        return validacion;
    }
}
