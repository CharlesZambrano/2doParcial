package com.test.partial.second.charles.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

import com.test.partial.second.charles.dto.MovimientoDTO;
import com.test.partial.second.charles.model.Movimiento;

@Mapper(componentModel = "spring", uses = { MovimientoMapper.MovimientoFactory.class })
public interface MovimientoMapper {
    MovimientoDTO toDTO(Movimiento movimiento);

    Movimiento toEntity(MovimientoDTO dto);

    @Component
    class MovimientoFactory {
        @ObjectFactory
        public Movimiento create(MovimientoDTO dto) {
            return new Movimiento(dto.getId(), dto.getFecha(), dto.getTipo(), dto.getValor(), dto.getSaldo());
        }
    }
}
