package com.test.partial.second.charles.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

import com.test.partial.second.charles.dto.CuentaDivisaExtranjeraDTO;
import com.test.partial.second.charles.model.CuentaDivisaExtranjera;

@Mapper(componentModel = "spring", uses = { CuentaDivisaExtranjeraMapper.CuentaDivisaExtranjeraFactory.class })
public interface CuentaDivisaExtranjeraMapper {
    CuentaDivisaExtranjeraDTO toDTO(CuentaDivisaExtranjera cuenta);

    CuentaDivisaExtranjera toEntity(CuentaDivisaExtranjeraDTO dto);

    @Component
    class CuentaDivisaExtranjeraFactory {
        @ObjectFactory
        public CuentaDivisaExtranjera create(CuentaDivisaExtranjeraDTO dto) {
            return new CuentaDivisaExtranjera(dto.getId(), dto.getCode(), dto.getTipoDivisa(), dto.getAccountNumber(),
                    dto.getClientId(), dto.getSaldo(), null);
        }
    }
}
