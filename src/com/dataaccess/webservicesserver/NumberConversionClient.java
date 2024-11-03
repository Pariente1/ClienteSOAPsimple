package com.dataaccess.webservicesserver;

public class NumberConversionClient {

    public static void main(String[] args) {
        try {
            // Instanciar el servicio
            NumberConversion service = new NumberConversion();
            NumberConversionSoapType soap = service.getNumberConversionSoap();

            // Llamar a la operación para convertir un número
            String numberToWords = soap.numberToWords(123);
            System.out.println("Número a palabras (123): " + numberToWords);

            // Llamar a la operación para convertir el número a dólar
            String numberToDollars = soap.numberToDollars(123);
            System.out.println("Número a dólares (123): " + numberToDollars);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
