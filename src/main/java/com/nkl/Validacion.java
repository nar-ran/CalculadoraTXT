package com.nkl;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacion {
    private int validacion = 0;

    public int validarTexto(String text) {
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        for(int i = 0; i <= text.length() - 1; i++){
            if(text.charAt(i) == '|'){
                count++;
            }
        }
        if (text.isEmpty()){
            validacion = 1;
            System.err.println("El archivo esta vacio.");
        }else if(count < 3){
            validacion = 1;
            System.out.println(count);
            System.err.println("El archivo no tiene una estructura adecuada.");
        }else if(!text.matches("[+-]?[0-9]*\\.?[0-9].*")){
            validacion = 1;
            System.err.println("El archivo no puede iniciar con: "+text.charAt(0));
        }else if(matcher.find()){
            validacion = 1;
            System.err.println("El archivo txt contiene letras.");
        }/*else if(!Pattern.compile("[-+/*]").matcher(text).find()){ // Validacion de signos de operación
            validacion = 2;
            System.err.println("El tipo de operación no es valida para calcular.");
        }*/else if(text.contains("/|0|")){
            validacion = 4;
            System.err.println("No se puede dividir entre cero.");
        }

        return validacion;
    }
}
