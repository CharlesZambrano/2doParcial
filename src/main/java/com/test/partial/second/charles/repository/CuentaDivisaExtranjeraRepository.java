package com.test.partial.second.charles.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.partial.second.charles.model.CuentaDivisaExtranjera;

public interface CuentaDivisaExtranjeraRepository extends MongoRepository<CuentaDivisaExtranjera, String> {
    List<CuentaDivisaExtranjera> findByClientId(String clientId);

    Optional<CuentaDivisaExtranjera> findByCode(String code);
}
