package com.aluracursos.conversorDeMonedas.API;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.aluracursos.conversorDeMonedas.EntradaSalida.MonedaExchangeRateAPI;
import com.google.gson.Gson;

public class ExchangeRateAPI {

  public MonedaExchangeRateAPI getMoneda(String moneda) {
    URI direccion = URI.create("https://v6.exchangerate-api.com/v6/7039dafc98508b11dbd30e20/latest/" + moneda);

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(direccion)
            .build();

    try {
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        // System.out.println(response.body());
        return new Gson().fromJson(response.body(), MonedaExchangeRateAPI.class);
    } catch (Exception e) {
        System.out.println(e.getMessage());
        throw new RuntimeException("No encontré esa moneda.");
    }
  }

}
