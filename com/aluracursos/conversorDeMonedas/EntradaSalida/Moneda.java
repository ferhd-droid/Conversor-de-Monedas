package com.aluracursos.conversorDeMonedas.EntradaSalida;

import java.util.HashMap;

public class Moneda {
  private String respuesta;
  private String base_code;
  private HashMap<String, Double> conversion_rates;

  public Moneda(MonedaExchangeRateAPI monedaExRateAPI) {
    this.respuesta = monedaExRateAPI.result();
    this.base_code = monedaExRateAPI.base_code();
    this.conversion_rates = monedaExRateAPI.conversion_rates();
  }

  public String getRespuesta() {
    return respuesta;
  }

  public String getBase_code() {
    return base_code;
  }

  public HashMap<String, Double> getConversion_rates() {
    return conversion_rates;
  }

}
