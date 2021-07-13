package com.everis.service.impl;

import com.everis.repository.InterfaceRepository;
import com.everis.service.InterfaceCrudService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Implementacion del CRUD. 
 */
public abstract class CrudServiceImpl<T, K> implements InterfaceCrudService<T, K> {
  
  protected abstract InterfaceRepository<T, K> getRepository();

  @Override
  public Mono<T> create(T o) {
    return getRepository().save(o);
  }

  @Override
  public Flux<T> findAll() {
    return getRepository().findAll();
  }
  
  @Override
  public Mono<T> findById(K id) {
    return getRepository().findById(id);
  }

  @Override
  public Mono<T> update(T o) {
    return getRepository().save(o);
  }

  @Override
  public Mono<Void> delete(K id) {
    return getRepository().deleteById(id);
  }

}
