package com.nkl;

public class Resultado {
    private String textoTxt;
    private double resultado;

    LecturaTxt leerArchivo = new LecturaTxt();
    Validacion validarTxt = new Validacion();

    public void mostrar(){
        textoTxt = leerArchivo.leerTxt();
        int validacion = validarTxt.txtValido(textoTxt);

        System.out.println("txt = " + textoTxt);

        if(validacion==0){
            System.out.println("Archivo valido");
        }else{
//            System.err.println("Error al hacer la operación.");
            System.err.println("Es invalido el txt");
        };


    }
}
