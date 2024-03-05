package com.nkl;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

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

            ScriptEngineManager m = new ScriptEngineManager();
            ScriptEngine engine = m.getEngineByName("JavaScript");

            try {
                Object r = engine.eval(textoTxt);
                System.out.println("El resultado de la operación "+textoTxt+" es: "+resultado);
            } catch (Exception e) {
                System.err.println("Ha ocurrido un error."+ e);
            }
        }
//            System.err.println("Error al hacer la operación.");
    }
}
