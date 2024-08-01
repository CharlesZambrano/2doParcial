package com.test.partial.second.charles.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.partial.second.charles.model.Movimiento;

public interface MovimientoRepository extends MongoRepository<Movimiento, String> {
}
