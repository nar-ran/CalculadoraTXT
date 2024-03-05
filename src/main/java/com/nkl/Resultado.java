package com.nkl;

public class Resultado {
    private String textoTxt;
    private double resultado;

    LecturaTxt leerArchivo = new LecturaTxt();
    Validacion validarTxt = new Validacion();

    public void mostrarResultado(){
        textoTxt = leerArchivo.leerTxt();
        int validacion = validarTxt.validarTexto(textoTxt);

        if(validacion==0){
            System.out.println("txt = " + textoTxt);
            System.out.println("El resultado de la operación es: "+resultado);
        }
//            System.err.println("Error al hacer la operación.");
    }
}
