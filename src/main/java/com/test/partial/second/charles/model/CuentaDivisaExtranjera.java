package com.test.partial.second.charles.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "cuentaDivisaExtranjeras")
public class CuentaDivisaExtranjera {

    @Id
    private String id;

    @Indexed(unique = true)
    private String code;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CuentaDivisaExtranjera other = (CuentaDivisaExtranjera) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
