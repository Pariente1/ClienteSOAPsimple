package org.example;

import com.dataaccess.webservicesserver.NumberConversionSoapType;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.math.BigInteger;
import java.net.URL;

public class Main {
    public static void main(String[] args) {

        interactWithApi();
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

            String response = port.numberToWords(BigInteger.valueOf(666)); // Llama al método con la solicitud
            System.out.println("Resultado: " + response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
