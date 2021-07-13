package com.everis.service.impl;

import com.everis.model.Account;
import com.everis.model.Transaction;
import com.everis.repository.InterfaceRepository;
import com.everis.repository.InterfaceTransactionRepository;
import com.everis.service.InterfaceAccountService;
import com.everis.service.InterfaceTransactionService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Implementacion de Metodos del Service Transaction.
 */
@Slf4j
@Service
public class TransactionServiceImpl extends CrudServiceImpl<Transaction, String> 
    implements InterfaceTransactionService {

  static final String CIRCUIT = "transactionServiceCircuitBreaker";
  
  @Value("${msg.error.registro.notfound.all}")
  private String msgNotFoundAll;
  
  @Value("${msg.error.registro.card.exists}")
  private String msgCardNotExists;
  
  @Autowired
  private InterfaceTransactionRepository repository;

  @Autowired
  private InterfaceTransactionService service;
  
  @Autowired
  private InterfaceAccountService accountService;

  @Override
  protected InterfaceRepository<Transaction, String> getRepository() {
  
    return repository;
  
  }
  
  @Override
  @CircuitBreaker(name = CIRCUIT, fallbackMethod = "findAllFallback")
  public Mono<List<Transaction>> findAllTransaction() { 
    
    Flux<Transaction> transactionDatabase = service.findAll()
        .switchIfEmpty(Mono.error(new RuntimeException(msgNotFoundAll)));
    
    return transactionDatabase.collectList().flatMap(Mono::just);
    
  }

  @Override
  @CircuitBreaker(name = CIRCUIT, fallbackMethod = "findAllCardFallback")
  public Mono<List<Transaction>> findAllByCardNumber(String cardNumber) { 
    
    Flux<Account> accountDatabase = accountService.findAll()
        .filter(account -> account.getPurchase().getCardNumber().equals(cardNumber))
        .switchIfEmpty(Mono.error(new RuntimeException(msgCardNotExists)));
    
    Flux<Transaction> transactionDatabase = service.findAll()
        .filter(list -> list.getPurchase().getCardNumber().equals(cardNumber))
        .switchIfEmpty(Mono.error(new RuntimeException(msgNotFoundAll)));

    return accountDatabase.collectList()
        .flatMap(p -> transactionDatabase.collectList().flatMap(Mono::just));
    
  }

  @Override
  @CircuitBreaker(name = CIRCUIT, fallbackMethod = "findAllCardFallback")
  public Mono<List<Transaction>> findTop10ByCardNumber(String cardNumber) {
    
    Flux<Account> accountDatabase = accountService.findAll()
        .filter(account -> account.getPurchase().getCardNumber().equals(cardNumber))
        .switchIfEmpty(Mono.error(new RuntimeException(msgCardNotExists)));
    
    Flux<Transaction> transactionDatabase = service.findAll()
        .filter(list -> list.getPurchase().getCardNumber().equals(cardNumber))
        .takeLast(10)
        .switchIfEmpty(Mono.error(new RuntimeException(msgNotFoundAll)));

    return accountDatabase.collectList()
        .flatMap(p -> transactionDatabase.collectList().flatMap(Mono::just));
    
  }

  @Override
  @CircuitBreaker(name = CIRCUIT, fallbackMethod = "findAllCardFallback")
  public Mono<List<Transaction>> findAllByCommission(String cardNumber) { 
    
    Flux<Account> accountDatabase = accountService.findAll()
        .filter(account -> account.getPurchase().getCardNumber().equals(cardNumber))
        .switchIfEmpty(Mono.error(new RuntimeException(msgCardNotExists)));
    
    Flux<Transaction> transactionDatabase = service.findAll()
        .filter(list -> list.getPurchase().getCardNumber().equals(cardNumber))
        .filter(list -> list.getCommission() > 0)
        .switchIfEmpty(Mono.error(new RuntimeException(msgNotFoundAll)));

    return accountDatabase.collectList()
        .flatMap(p -> transactionDatabase.collectList().flatMap(Mono::just));
    
  }
  
  /** Mensaje si no existen transacciones. */
  public Mono<List<Transaction>> findAllFallback(Exception ex) {
    
    log.info("Transacciones no encontradas, retornando fallback");
  
    List<Transaction> list = new ArrayList<>();
    
    list.add(Transaction
        .builder()
        .id(ex.getMessage())
        .build());
    
    return Mono.just(list);
    
  }
  
  /** Mensaje si no existen transacciones con ese numero de tarjeta. */
  public Mono<List<Transaction>> findAllCardFallback(String cardNumber, Exception ex) {
    
    log.info("Transacciones no encontradas, retornando fallback");
  
    List<Transaction> list = new ArrayList<>();
    
    list.add(Transaction
        .builder()
        .id(ex.getMessage())
        .description(cardNumber)
        .build());
    
    return Mono.just(list);
    
  }
  

}
