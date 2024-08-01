package com.test.partial.second.charles.model;

import java.math.BigDecimal;
import java.util.Date;

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
@Document(collection = "movimiento")
public class Movimiento {

    @Id
    private String id;
    private Date fecha;
    private String tipo; // DEB or CRE
    private BigDecimal valor;
    private BigDecimal saldo;

    public Movimiento(String id, Date fecha, String tipo, BigDecimal valor, BigDecimal saldo) {
        this.id = id;
        this.fecha = fecha;
        this.tipo = tipo;
        this.valor = valor;
        this.saldo = saldo;
    }
}
