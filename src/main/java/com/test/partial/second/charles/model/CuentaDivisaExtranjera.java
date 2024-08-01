package com.test.partial.second.charles.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "cuentaDivisaExtranjera")
public class CuentaDivisaExtranjera {

    @Id
    private String id;
    private String tipoDivisa;
    private String accountNumber;
    private String clientId;
    private BigDecimal saldo;
    private List<Movimiento> movimientos;

    public CuentaDivisaExtranjera(String id, String tipoDivisa, String accountNumber, String clientId, BigDecimal saldo,
            List<Movimiento> movimientos) {
        this.id = id;
        this.tipoDivisa = tipoDivisa;
        this.accountNumber = accountNumber;
        this.clientId = clientId;
        this.saldo = saldo;
        this.movimientos = movimientos;
    }
}
