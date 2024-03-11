package com.nkl;

import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private String url;
    Validacion validacion = new Validacion();
    Resultado rs = new Resultado();

    public void menu(){
        do {
            System.out.println("---- Calculadora .txt ----");
            System.out.println("- Ingrese la URL del archivo .txt para calcular.");
            System.out.println("- El archivo puede ser local del dispositivo o puede estar en un repo de github.");
            System.out.println("- Escriba 0 para salir del programa.");
            System.out.print("URL: ");
            url = sc.nextLine();

            if(!url.trim().equals("0")){
                if (validacion.validarOrigenArchivo(url.toLowerCase()) == 0){
                    System.out.println("La URL del archivo no es valida.");
                }else if (!validacion.validarTipoArchivo(url.toLowerCase())){
                    System.out.println("El tipo de archivo no es de extensión .txt");
                }else if(validacion.validarEstructuraTexto(url) != 0){
                    rs.mostrarResultado(url);
                }
            }

            System.out.println("----------------------------------- \n");
        }while(!url.equals("0"));
        System.out.println("Ha salido del programa.");
    }
}
