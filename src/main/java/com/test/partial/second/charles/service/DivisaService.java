package com.test.partial.second.charles.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.test.partial.second.charles.dto.CotizacionResponse;

@Service
public class DivisaService {

    private final RestTemplate restTemplate;

    public DivisaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CotizacionResponse obtenerCotizacion(String monedaOrigen, String monedaDestino, BigDecimal montoCompra) {
        String url = "http://fake-service/cotizacion?monedaOrigen=" + monedaOrigen + "&monedaDestino=" + monedaDestino
                + "&montoCompra=" + montoCompra;

        // Simulación de la llamada al servicio externo
        return restTemplate.getForObject(url, CotizacionResponse.class);
    }
}
