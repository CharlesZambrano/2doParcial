package com.test.partial.second.charles.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.test.partial.second.charles.dto.CotizacionRequestDTO;
import com.test.partial.second.charles.dto.CotizacionResponseDTO;

@Service
public class DivisaService {

    private final RestTemplate restTemplate;

    public DivisaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CotizacionResponseDTO obtenerCotizacion(String monedaOrigen, String monedaDestino, BigDecimal montoCompra) {
        String url = "http://fake-service/cotizacion";

        CotizacionRequestDTO request = CotizacionRequestDTO.builder()
                .monedaOrigen(monedaOrigen)
                .monedaDestino(monedaDestino)
                .montoCompra(montoCompra)
                .build();

        return restTemplate.postForObject(url, request, CotizacionResponseDTO.class);
    }
}
