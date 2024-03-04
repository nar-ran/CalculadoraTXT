package com.nkl;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LecturaTxt {
    public String leerTxt(){
        StringBuilder texto = new StringBuilder();
        List<String> resultS = new ArrayList<>();

        try(Stream<String> stream = Files.lines(Paths.get("ficheros/Calculadora.txt"))){
            stream.forEach(line -> {
                texto.append(line);
                resultS.add(line);
            });

            System.out.println(resultS);
        }catch (IOException e){
            System.err.println("Error al intentar leer el archivo: "+ e);
        };

        return texto.toString();
    }
}