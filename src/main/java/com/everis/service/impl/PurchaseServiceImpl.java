package com.everis.service.impl;

import com.everis.model.Purchase;
import com.everis.repository.InterfacePurchaseRepository;
import com.everis.repository.InterfaceRepository;
import com.everis.service.InterfacePurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Implementacion de Metodos del Service Purchase.
 */
@Service
public class PurchaseServiceImpl extends CrudServiceImpl<Purchase, String> 
    implements InterfacePurchaseService {

  @Autowired
  private InterfacePurchaseRepository repository;
  
  @Override
  protected InterfaceRepository<Purchase, String> getRepository() {
  
    return repository;
  
  }

  @Override
  public Mono<Purchase> findByCardNumber(String cardNumber) {
  
    return repository.findByCardNumber(cardNumber);
  
  }
  
}
