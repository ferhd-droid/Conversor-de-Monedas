package com.aluracursos.conversorDeMonedas.EntradaSalida;

import java.util.HashMap;

public record MonedaExchangeRateAPI(String result, String base_code,
                                    HashMap<String, Double> conversion_rates) {

}
