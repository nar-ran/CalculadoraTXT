package com.nkl;

import java.util.ArrayList;

public class Resultado {
    private String textoTxt;
    private double resultado;

    LecturaTxt leerArchivo = new LecturaTxt();
    Validacion validarTxt = new Validacion();

    public void mostrarResultado(){
        ArrayList<Character> ops = new ArrayList<>();
        ArrayList<Double> nums = new ArrayList<>();

        textoTxt = leerArchivo.leerTxt();
        int validacion = validarTxt.validarTexto(textoTxt);

        System.out.println(textoTxt);

        if(validacion==0){
            System.out.println("-----------------------------------");
            String[] subs = textoTxt.split("\\|");

            for (String sub: subs){
                if (!sub.isEmpty()){
                    if(sub.matches("[+-]?[0-9]*\\.?[0-9]")){
                        double num = Double.parseDouble(sub);
                        nums.add(num);
                        System.out.println(nums);
                    } else if (sub.matches("[-+*/]")) {
                        ops.add(sub.charAt(0));
                    }else{
                        System.err.println("Es invalido el archivo.");
                        System.exit(0);
                    }
                }else{
                    System.err.println("El archivo esta vacio.");
                }
            }


            System.out.println("-----------------------------------");
            System.out.println("Se realiza la operación");
            resultado = nums.get(0);
            for(int i = 0; i <= nums.size() - 1; i++){
                try{
                    System.out.println(nums.get(i)+" "+ops.get(i));
                    switch (ops.get(i)){
                        case '+' ->  resultado = resultado + nums.get(i + 1);
                        case '-' ->  resultado = resultado - nums.get(i + 1);
                        case '*' ->  resultado = resultado * nums.get(i + 1);
                        case '/' ->  resultado = resultado / nums.get(i + 1);
                    }
                    System.out.println("resultado = " + resultado);
                }catch (IndexOutOfBoundsException e){
                    System.err.println("Ha excedido el limite.");
                }
            }
        }
    }
}
