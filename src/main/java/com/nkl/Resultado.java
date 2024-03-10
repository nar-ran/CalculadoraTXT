package com.nkl;

import java.util.ArrayList;

public class Resultado {
    private String textoTxt;
    private double resultado;

    LecturaTxt leerArchivo = new LecturaTxt();
    Validacion validarTxt = new Validacion();

    public void mostrarResultado(String url){
        ArrayList<Character> ops = new ArrayList<>();
        ArrayList<Double> nums = new ArrayList<>();

        switch (validarTxt.validarOrigenArchivo(url)){
            case 1 -> textoTxt = leerArchivo.leerTxtOnline(url);
            case 2 -> textoTxt = leerArchivo.leerTxt(url);
            default -> textoTxt = "invalid";
        }

        if (!textoTxt.equals("invalid") && validarTxt.validarTexto(textoTxt) == 0){
            String[] subs = textoTxt.split("\\|");
            try{
                for (String sub: subs){
                    if(sub.matches("[+-]?[0-9]*\\.?[0-9].*")){
                        double num = Double.parseDouble(sub);
                        nums.add(num);
                    } else if (sub.matches("[-+*/]")) {
                        ops.add(sub.charAt(0));
                    }else{
                        System.err.println("Es invalido el archivo. Revise la operación.");
                        System.exit(0);
                    }
                }
            }catch (NumberFormatException ignored){
                System.out.println("-----------------------------------");
                System.out.println("La estructura del archivo no es adecuada.");
                return;
            }

            resultado = nums.get(0);
            for(int i = 0; i < nums.size() - 1; i++){
                try{
                    switch (ops.get(i)){
                        case '+' ->  resultado = resultado + nums.get(i+1);
                        case '-' ->  resultado = resultado - nums.get(i+1);
                        case '*' ->  resultado = resultado * nums.get(i+1);
                        case '/' ->  resultado = resultado / nums.get(i+1);
                    }
                }catch (IndexOutOfBoundsException e){
                    System.err.println("La operación del archivo es invalida.");
                    break;
                }
            }

            System.out.println("-----------------------------------");
            System.out.println("Operación: "+ textoTxt.replace("|", ""));
            System.out.println("-----------------------------------");

            System.out.println("El resultado de la operación es: "+resultado);
        }
    }
}
