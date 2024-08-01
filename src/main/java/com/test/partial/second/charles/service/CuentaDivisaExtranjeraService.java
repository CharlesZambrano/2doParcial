package com.test.partial.second.charles.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.partial.second.charles.dto.CotizacionResponse;
import com.test.partial.second.charles.dto.CuentaDivisaExtranjeraDTO;
import com.test.partial.second.charles.model.CuentaDivisaExtranjera;
import com.test.partial.second.charles.model.Movimiento;
import com.test.partial.second.charles.repository.CuentaDivisaExtranjeraRepository;
import com.test.partial.second.charles.util.mapper.CuentaDivisaExtranjeraMapper;
import com.test.partial.second.charles.util.mapper.MovimientoMapper;

@Service
@Transactional
public class CuentaDivisaExtranjeraService {

    private final CuentaDivisaExtranjeraRepository cuentaDivisaExtranjeraRepository;
    private final CuentaDivisaExtranjeraMapper cuentaDivisaExtranjeraMapper;
    private final MovimientoMapper movimientoMapper;
    private final DivisaService divisaService;

    public CuentaDivisaExtranjeraService(CuentaDivisaExtranjeraRepository cuentaDivisaExtranjeraRepository,
            CuentaDivisaExtranjeraMapper cuentaDivisaExtranjeraMapper,
            MovimientoMapper movimientoMapper,
            DivisaService divisaService) {
        this.cuentaDivisaExtranjeraRepository = cuentaDivisaExtranjeraRepository;
        this.cuentaDivisaExtranjeraMapper = cuentaDivisaExtranjeraMapper;
        this.movimientoMapper = movimientoMapper;
        this.divisaService = divisaService;
    }

    public CuentaDivisaExtranjeraDTO compraDivisa(String cuentaId, BigDecimal montoCompra, String monedaDestino) {
        CuentaDivisaExtranjera cuenta = cuentaDivisaExtranjeraRepository.findById(cuentaId)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        CotizacionResponse cotizacion = divisaService.obtenerCotizacion(cuenta.getTipoDivisa(), monedaDestino,
                montoCompra);

        BigDecimal totalMonedaOrigen = cotizacion.getTotalMonedaOrigen();
        BigDecimal totalMonedaDestino = cotizacion.getTotalMonedaDestino();

        Movimiento movimiento = new Movimiento();
        movimiento.setFecha(new Date());
        movimiento.setTipo("DEB");
        movimiento.setValor(totalMonedaOrigen);
        movimiento.setSaldo(cuenta.getSaldo().subtract(totalMonedaOrigen));

        cuenta.getMovimientos().add(movimiento);
        cuenta.setSaldo(movimiento.getSaldo());

        cuentaDivisaExtranjeraRepository.save(cuenta);

        return cuentaDivisaExtranjeraMapper.toDTO(cuenta);
    }

    public List<CuentaDivisaExtranjeraDTO> obtenerPosicionConsolidada(String clientId) {
        List<CuentaDivisaExtranjera> cuentas = cuentaDivisaExtranjeraRepository.findByClientId(clientId);
        return cuentas.stream()
                .map(cuenta -> {
                    CotizacionResponse cotizacion = divisaService.obtenerCotizacion(cuenta.getTipoDivisa(), "USD",
                            cuenta.getSaldo());
                    BigDecimal saldoEnMonedaLocal = cuenta.getSaldo().multiply(cotizacion.getTotalMonedaOrigen());
                    CuentaDivisaExtranjeraDTO dto = cuentaDivisaExtranjeraMapper.toDTO(cuenta);
                    dto.setSaldoEnMonedaLocal(saldoEnMonedaLocal);
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
