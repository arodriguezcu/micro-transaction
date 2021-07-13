package com.everis.service;

import com.everis.model.Purchase;
import reactor.core.publisher.Mono;

/**
 * Interface de Metodos del Purchase.
 */
public interface InterfacePurchaseService extends InterfaceCrudService<Purchase, String> {
  
  Mono<Purchase> findByCardNumber(String cardNumber);

}
