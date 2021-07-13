package com.everis.service;

import com.everis.model.Transfer;
import com.everis.model.Withdrawal;
import reactor.core.publisher.Mono;

/**
 * Interface de Metodos del Transfer.
 */
public interface InterfaceTransferService extends InterfaceCrudService<Transfer, String> {
  
  Mono<Withdrawal> createTransfer(Transfer transfer);
    
}
