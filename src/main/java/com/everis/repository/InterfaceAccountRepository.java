package com.everis.repository;

import com.everis.model.Account;
import reactor.core.publisher.Mono;

/**
 * Interface de Metodos del Repositorio.
 */
public interface InterfaceAccountRepository extends InterfaceRepository<Account, String> {

  Mono<Account> findByAccountNumber(String accountNumber);
  
}
