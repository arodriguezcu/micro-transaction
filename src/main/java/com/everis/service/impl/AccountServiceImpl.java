package com.everis.service.impl;

import com.everis.model.Account;
import com.everis.repository.InterfaceAccountRepository;
import com.everis.repository.InterfaceRepository;
import com.everis.service.InterfaceAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Implementacion de Metodos del Service Account.
 */
@Service
public class AccountServiceImpl extends CrudServiceImpl<Account, String> 
    implements InterfaceAccountService {

  @Autowired
  private InterfaceAccountRepository repository;

  @Override
  protected InterfaceRepository<Account, String> getRepository() {
  
    return repository;
  
  }

  @Override
  public Mono<Account> findByAccountNumber(String accountNumber) {
    
    return repository.findByAccountNumber(accountNumber);
    
  }

}
