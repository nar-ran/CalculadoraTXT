package com.nkl;

import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class LecturaTxt {
    public String leerTxt(String url){
        StringBuilder texto = new StringBuilder();

        try(Stream<String> stream = Files.lines(Paths.get(url))){
            stream.forEach(line -> {
                if (line.trim().isEmpty()){
                    return;
                }else if(line.contains("|")){
                    System.err.println("No es un archivo valido.");
                }else {
                    texto.append(line.trim()).append("|");
                }
            });

            return texto.toString();
        }catch (IOException | InvalidPathException e){
            System.err.println("La ruta del archivo no es valida, el archivo no existe o no es accesible.");
        };

        return "invalid";
    }
}