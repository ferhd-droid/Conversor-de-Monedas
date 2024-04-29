package com.aluracursos.conversorDeMonedas.Principal;

import java.util.HashMap;
import java.util.Scanner;

import com.aluracursos.conversorDeMonedas.API.ExchangeRateAPI;
import com.aluracursos.conversorDeMonedas.EntradaSalida.Menu;
import com.aluracursos.conversorDeMonedas.EntradaSalida.Moneda;
import com.aluracursos.conversorDeMonedas.EntradaSalida.MonedaExchangeRateAPI;

public class Principal {
  public static void main(String[] args) throws Exception {
    Scanner userInput = new Scanner(System.in);
    ExchangeRateAPI monedaAPI = new ExchangeRateAPI();
    HashMap<String, Double> conversion_rates = new HashMap<>();
    MonedaExchangeRateAPI monedaExRateAPI = monedaAPI.getMoneda("USD");
    Moneda monedaUSA = new Moneda(monedaExRateAPI);
    Moneda moneda = monedaUSA;
    double valorFinal = 0;
    String key1 = "USD";
    String key2 = "USD";

    try {
      while (true) {
        System.out.println(Menu.stars);
        System.out.println(Menu.legend + "\n");
        System.out.println(Menu.menu);
        System.out.println(Menu.stars);
        var opcion = userInput.nextInt();
        
        if (opcion == 9) {
          userInput.close();
          break;
        }
        if (opcion == 1 || opcion == 3 || opcion == 5) {
          moneda = monedaUSA;
        } else if (opcion == 2) {
          monedaExRateAPI = monedaAPI.getMoneda("ARS");
          Moneda monedaARS = new Moneda(monedaExRateAPI);
          moneda = monedaARS;
        } else if (opcion == 4) {
          monedaExRateAPI = monedaAPI.getMoneda("BRL");
          Moneda monedaBRL = new Moneda(monedaExRateAPI);
          moneda = monedaBRL;
        } else if (opcion == 6) {
          monedaExRateAPI = monedaAPI.getMoneda("COP");
          Moneda monedaCOP = new Moneda(monedaExRateAPI);
          moneda = monedaCOP;
        } else {
          continue; // Volvemos a presentar el menú
        }
        conversion_rates = moneda.getConversion_rates();
        System.out.println("Ingrese el valor que desea convertir:");
        var valor = userInput.nextDouble();

        switch (opcion) {
          case 1:
            key1 = "USD";
            key2 = "ARS";
            break;
          case 2:
            key1 = "ARS";
            key2 = "USD";
            break;
          case 3:
            key1 = "USD";
            key2 = "BRL";
            break;
          case 4:
            key1 = "BRL";
            key2 = "USD";
            break;
          case 5:
            key1 = "USD";
            key2 = "COP";
            break;
          case 6:
            key1 = "COP";
            key2 = "USD";
            break;
          default:
            key1 = "USD";
            key2 = "USD";
            break;
        }
        valorFinal = valor * conversion_rates.get(key2);
        System.out.println(String.format("El valor %.2f [%s] corresponde"
                          + " al valor final de =>> %.2f [%s]\n", 
                          valor, key1,valorFinal, key2));
      }
    } catch (Exception e) {
      System.out.println("Opción no válida, solo números por favor");
    }
    System.out.println("Finalizó la ejecución del programa!");        
  }
}
