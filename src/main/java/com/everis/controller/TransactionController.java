package com.everis.controller;

import com.everis.model.Transaction;
import com.everis.model.Transfer;
import com.everis.model.Withdrawal;
import com.everis.service.InterfaceTransactionService;
import com.everis.service.InterfaceTransferService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Controlador del Transaction.
 */
@RestController
@RequestMapping("/transaction")
public class TransactionController {
   
  @Autowired
  private InterfaceTransactionService service;
  
  @Autowired
  private InterfaceTransferService transferService;
  
  /** Metodo para listar todas las transacciones. */ 
  @GetMapping
  public Mono<ResponseEntity<List<Transaction>>> findAll() { 
      
    return service.findAllTransaction()
        .map(objectFound -> ResponseEntity
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(objectFound));
    
  }

  /** Metodo para listar todas las transacciones por numero de tarjeta. */ 
  @GetMapping("/{cardNumber}")
  public Mono<ResponseEntity<List<Transaction>>> findAllByCardNumber(@PathVariable("cardNumber") 
      String cardNumber) { 
  
    return service.findAllByCardNumber(cardNumber)
        .map(objectFound -> ResponseEntity
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(objectFound));
    
  }
  
  /** Metodo para listar los ultimos 10 transacciones por numero de tarjeta. */
  @GetMapping("list10/{cardNumber}")
  public Mono<ResponseEntity<List<Transaction>>> findTop10ByCardNumber(@PathVariable("cardNumber") 
      String cardNumber) { 
  
    return service.findTop10ByCardNumber(cardNumber)
        .map(objectFound -> ResponseEntity
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(objectFound));
    
  }
  
  /** Metodo para listar todas las comisiones por numero de tarjeta. */ 
  @GetMapping("/commission/{cardNumber}")
  public Mono<ResponseEntity<List<Transaction>>> findAllByCommission(@PathVariable("cardNumber") 
      String cardNumber) { 
  
    return service.findAllByCommission(cardNumber)
        .map(objectFound -> ResponseEntity
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(objectFound));
    
  }
  
  /** Metodo para crear una transferencia. */ 
  @PostMapping
  public Mono<ResponseEntity<Withdrawal>> createTransfer(@RequestBody Transfer transfer) {
    
    return transferService.createTransfer(transfer)
        .map(objectFound -> ResponseEntity
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(objectFound));
    
  }
  
}
