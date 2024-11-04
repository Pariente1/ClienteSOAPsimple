package org.example;

import com.dataaccess.webservicesserver.NumberConversionSoapType;
import com.dataaccess.webservicesserver.NumberToWords;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;

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
                interactWithApi();
            } else {
                System.err.println("Error al ejecutar wsimport. Código de salida: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static void interactWithApi() {
        try {
            // Carga el WSDL desde la URL
            URL url = new URL("https://www.dataaccess.com/webservicesserver/NumberConversion.wso?WSDL");
            QName qname = new QName("http://www.dataaccess.com/webservicesserver/", "NumberConversion");

            // Crea el servicio
            Service service = Service.create(url, qname);

            // Obtiene el puerto para interactuar con el servicio
            NumberConversionSoapType port = service.getPort(NumberConversionSoapType.class);

            String response = port.numberToWords(BigInteger.valueOf(1111111)); // Llama al método con la solicitud
            System.out.println("Resultado: " + response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
