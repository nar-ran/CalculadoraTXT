package com.nkl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacion {
    private int val = 0;

    public boolean txtValido(String text) {
        Pattern operadores = Pattern.compile("[()-+*/\\-0-9]+");
        Matcher match = operadores.matcher(text);

        // Primera validación para saber si tiene signos de operación.
        if (match.matches()) {
            val = 1;
            System.err.println("Contiene operadores NO validos.");
        }else{
            System.out.println("Operación valida");
        }/*else{
            if (){

            }
        }*/



        return false;
    }
}
