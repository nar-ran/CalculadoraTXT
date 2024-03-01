package com.nkl;

import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class LecturaTxt {
    Validacion v = new Validacion();
    public void lectura(){
        try(Stream<String> stream = Files.lines(Paths.get("ficheros/Calculadora.txt"))){
            stream.forEach(System.out::println);
        }catch (IOException e){
            System.err.println(e);
        };
    }
}