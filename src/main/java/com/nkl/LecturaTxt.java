package com.nkl;

import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class LecturaTxt {
    public String leerTxt(){
        StringBuilder texto = new StringBuilder();

        try(Stream<String> stream = Files.lines(Paths.get("ficheros/Calculadora.txt"))){
            stream.forEach(line -> {
                if(line.contains("|")){
                    System.err.println("No es un archivo valido.");
                }else {
                    texto.append(line).append("|");
                }
            });
        }catch (IOException e){
            System.err.println("Error al intentar leer el archivo: "+ e);
        };

        return texto.toString();
    }
}