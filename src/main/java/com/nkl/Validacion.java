package com.nkl;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacion {
    private int validacion = 0;
    private double operacion;

    public int txtValido(String text) {
        String operadores[] = {"(",")","-","+","*","/"};
        Le

        if(text.contains("+")){
            System.out.println("suma");
        }

        if (text.contains("-")) {
            System.out.println("resta");
        }

        if (text.contains("*")) {
            System.out.println("Multiplicación");
        }

        if (text.contains("/")) {
            System.out.println("Division");
        }else{
            System.err.println("El archivo no es valido.");
        }

//        // Primera validación para saber si tiene signos de operación.
//        if (Arrays.asList(operadores).contains(text)) {
//            System.out.println("Contiene caracteres ");
//        }else{
//            validacion = 1;
//            System.err.println("Contiene operadores NO validos.");
//        }


        return validacion;
    }
}
