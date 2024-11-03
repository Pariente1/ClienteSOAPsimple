package org.example;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Define la ruta del WSDL y la ruta donde se generarán las clases
        String wsdlUrl = "https://www.dataaccess.com/webservicesserver/NumberConversion.wso?WSDL";
        String outputDir = "src/main/java/";

        // Configura el comando para wsimport
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("wsimport", "-s", outputDir, wsdlUrl);

        // Establece el directorio de trabajo donde se ejecutará el comando
        processBuilder.directory(new File("E:\\Java8intentoBorrar")); // Cambia a tu directorio base si es necesario

        try {
            Process process = processBuilder.start();
            int exitCode = process.waitFor(); // Espera a que el proceso termine

            if (exitCode == 0) {
                System.out.println("Clases generadas con éxito.");
            } else {
                System.err.println("Error al ejecutar wsimport. Código de salida: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
