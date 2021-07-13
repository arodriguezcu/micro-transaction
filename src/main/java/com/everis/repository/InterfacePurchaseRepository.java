package com.everis.repository;

import com.everis.model.Purchase;
import reactor.core.publisher.Mono;

/**
 * Interface de Metodos del Repositorio.
 */
public interface InterfacePurchaseRepository extends InterfaceRepository<Purchase, String> {

  Mono<Purchase> findByCardNumber(String cardNumber);
  
}
