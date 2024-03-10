package com.nkl;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
        } catch (MalformedURLException e) {
            System.err.println("La URL del archivo no es válida.");
        }catch (IOException | InvalidPathException e){
            System.err.println("La ruta del archivo no es valida, el archivo no existe o no es accesible.");
        };

        return "invalid";
    }

    public String leerTxtOnline(String url){
        StringBuilder content = new StringBuilder();

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK){
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line.trim()).append("|");
                }
                reader.close();
                return content.toString();
            }else {
                System.out.println("\"Error al obtener el archivo. Código de respuesta: \" + responseCode");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return content.toString();
    }
}