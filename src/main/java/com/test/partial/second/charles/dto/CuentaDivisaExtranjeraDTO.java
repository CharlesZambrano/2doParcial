package com.test.partial.second.charles.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CuentaDivisaExtranjeraDTO {
    private String id;
    private String code;
    private String tipoDivisa;
    private String accountNumber;
    private String clientId;
    private BigDecimal saldo;
    private List<MovimientoDTO> movimientos;

    @Setter
    private BigDecimal saldoEnMonedaLocal;
}
