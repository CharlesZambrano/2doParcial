package com.test.partial.second.charles.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.partial.second.charles.dto.CuentaDivisaExtranjeraDTO;
import com.test.partial.second.charles.service.CuentaDivisaExtranjeraService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/cuentaDivisaExtranjera")
@CrossOrigin(origins = "*")
@Tag(name = "CuentaDivisaExtranjera", description = "Endpoints para la gestión de cuentas de divisas extranjeras")
public class CuentaDivisaExtranjeraController {

    private final CuentaDivisaExtranjeraService cuentaDivisaExtranjeraService;

    public CuentaDivisaExtranjeraController(CuentaDivisaExtranjeraService cuentaDivisaExtranjeraService) {
        this.cuentaDivisaExtranjeraService = cuentaDivisaExtranjeraService;
    }

    @PostMapping("/compra")
    @Operation(summary = "Compra de divisa", description = "Permite la compra de divisa y registra el movimiento en el core bancario")
    public CuentaDivisaExtranjeraDTO compraDivisa(@RequestParam String cuentaCode, @RequestParam BigDecimal montoCompra,
            @RequestParam String monedaDestino) {
        return cuentaDivisaExtranjeraService.compraDivisa(cuentaCode, montoCompra, monedaDestino);
    }

    @PostMapping("/venta")
    @Operation(summary = "Venta de divisa", description = "Permite la venta de divisa y registra el movimiento en el core bancario")
    public CuentaDivisaExtranjeraDTO ventaDivisa(@RequestParam String cuentaCode, @RequestParam BigDecimal montoVenta,
            @RequestParam String monedaDestino) {
        return cuentaDivisaExtranjeraService.ventaDivisa(cuentaCode, montoVenta, monedaDestino);
    }

    @GetMapping("/posicionConsolidada/{clientId}")
    @Operation(summary = "Posición consolidada del cliente", description = "Permite conocer el saldo en todas las monedas extranjeras que posee un cliente")
    public List<CuentaDivisaExtranjeraDTO> obtenerPosicionConsolidada(@PathVariable String clientId) {
        return cuentaDivisaExtranjeraService.obtenerPosicionConsolidada(clientId);
    }
}
