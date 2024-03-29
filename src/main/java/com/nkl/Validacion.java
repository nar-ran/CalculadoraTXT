package com.nkl;

public class Validacion {
    private int validacion = 1;

    public int validarEstructuraTexto(String text) {
        int count = 0;
        for(int i = 0; i <= text.length() - 1; i++){
            if(text.charAt(i) == '|'){
                count++;
            }
        }

        if (text.isEmpty()){
            System.err.println("El archivo esta vacio.");
        }else
            if(count < 3){
                System.err.println("El archivo no tiene una estructura adecuada.");
        }else
            if(!text.matches("[+-]?[0-9]*\\.?[0-9].*")){
                System.err.println("El contenido del archivo es incorrecto.");
        }else
            if(text.matches("[a-zA-Z]")){
                System.err.println("El archivo txt contiene letras.");
        }else
            if(text.contains("/|0|") || text.contains("/|0.0|")){
                System.err.println("No se puede dividir por cero.");
        }else
            if (text.contains(",")){
                System.err.println("No se permiten las comas, los decimales van con punto.");
        }else
            if (text.replace("|", "").matches(".*[+\\*/]{2,}.*")) {
                System.err.println("La operación no puede tener varios signos seguidos.");
        } else{
            validacion = 0;
        }

        return validacion;
    }

    public boolean validarTipoArchivo(String url) {
        if (url.endsWith(".txt")){
            return true;
        }
        return false;
    }

    public int validarOrigenArchivo(String url){
        if (url.startsWith("https://") || url.startsWith("http://")){
            return 1;
        } else if (url.startsWith("c:\\") || url.startsWith("d:\\")) {
            return 2;
        }else {
            return 0;
        }
    }
}
