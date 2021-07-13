package com.everis.service;

import com.everis.model.Account;
import reactor.core.publisher.Mono;

/**
 * Interface de Metodos del Account.
 */
public interface InterfaceAccountService extends InterfaceCrudService<Account, String> {
  
  Mono<Account> findByAccountNumber(String accountNumber);
  
}
