package com.nkl;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacion {
    private int validacion = 0;

    public int validarTexto(String text) {
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(text);

        if (text.isEmpty()){
            validacion = 1;
            System.err.println("El archivo esta vacio.");
        }else if(!text.matches("[+-]?[0-9]*\\.?[0-9].*")){
            validacion = 1;
            System.err.println("El archivo no puede iniciar con: "+text.charAt(0));
        }

        /*else if (text.contains()) {
            // Validación para cuando solo tenga un numero.
            System.err.println("Operación no valida");
        }*/ else if(matcher.find()){
            validacion = 1;
            System.err.println("El archivo txt contiene letras.");
        }else if(!Pattern.compile("[-+*/]").matcher(text).find()){ // Validacion de signos de operación
            validacion = 2;
            System.err.println("La operación no es valida para calcular.");
        }else if(!Pattern.compile("[+-]?[0-9]*\\.?[0-9]").matcher(text).find()){
            validacion = 3;
            System.out.println("No contiene numeros el programa. ");
        }else if(text.contains("/|0|")){
            validacion = 4;
            System.err.println("No se puede dividir entre cero.");
        }

        return validacion;
    }
}
