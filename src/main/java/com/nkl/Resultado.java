package com.nkl;

public class Resultado {
    private String txt;
    private double rs;

    LecturaTxt lct = new LecturaTxt();
    Validacion v = new Validacion();

    public void mostrar(){
        txt = lct.lectura();

        v.txtValido(txt);


    }
}
