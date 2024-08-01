package com.test.partial.second.charles.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MovimientoDTO {
    private String id;
    private String code;
    private Date fecha;
    private String tipo;
    private BigDecimal valor;
    private BigDecimal saldo;
}
