package com.everis.service;

import com.everis.model.Transaction;
import java.util.List;
import reactor.core.publisher.Mono;

/**
 * Interface de Metodos del Transaction.
 */
public interface InterfaceTransactionService extends InterfaceCrudService<Transaction, String> {
    
  Mono<List<Transaction>> findAllTransaction();
  
  Mono<List<Transaction>> findAllByCardNumber(String cardNumber);
  
  Mono<List<Transaction>> findTop10ByCardNumber(String cardNumber);
  
  Mono<List<Transaction>> findAllByCommission(String cardNumber);
  
}
