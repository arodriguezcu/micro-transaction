package com.everis.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Conexion con MongoDB.
 */
@NoRepositoryBean
public interface InterfaceRepository<T, K> extends ReactiveMongoRepository<T, K> {

}
