package com.test.partial.second.charles.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CotizacionResponse {
    private String monedaDestino;
    private BigDecimal totalMonedaOrigen;
    private BigDecimal totalMonedaDestino;
}
