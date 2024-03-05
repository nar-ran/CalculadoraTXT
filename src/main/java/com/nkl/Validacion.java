package com.nkl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacion {
    private int validacion = 0;

    public int validarTexto(String text) {
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(text);

        /*
        * Tercero, validar que no tenga operadores diferentes a los especificados.
        * Cuarto, validar que el orden de los signos sea correcto.
        */

        Matcher mp = Pattern.compile("[\\d*-/+]").matcher(text);
        if (!mp.find()){
            System.err.println("El txt no tiene una estructura valida");
        }


        if(matcher.find()){
            validacion = 1;
            System.err.println("El archivo txt contiene letras.");
        }
//        else if(!Pattern.compile("[-+*/]").matcher(text).find()){ // Validacion de signos de operación
//            validacion = 2;
//            System.err.println("La operación no es valida para calcular.");
//        }else if(!Pattern.compile("\\d").matcher(text).find()){
//            validacion = 3;
//            System.out.println("No contiene numeros el programa. ");
////            System.err.println("EL archivo contiene caracteres invalidos");
//        }

        return validacion;
    }
}
