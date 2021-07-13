package com.everis.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interface de Metodos CRUD.
 */
public interface InterfaceCrudService<T, K> {
  
  Mono<T> create(T o);

  Flux<T> findAll();
  
  Mono<T> findById(K id);

  Mono<T> update(T o);

  Mono<Void> delete(K id);
  
}
