package com.everis.topic.producer;

import com.everis.model.Deposit;
import com.everis.model.Transaction;
import com.everis.model.Withdrawal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Clase Productor del Withdrawal.
 */
@Component
public class TransactionProducer {
  
  @Autowired
  private KafkaTemplate<String, Object> kafkaTemplate;

  private String transactionTopic = "created-transaction-topic";

  private String transferWithdrawalTopic = "created-transfer-withdrawal-topic";

  private String transferDepositTopic = "created-transfer-deposit-topic";

  /** Envia datos de la transaccion al topico. */
  public void sendCreatedTransactionTopic(Transaction transaction) {
  
    kafkaTemplate.send(transactionTopic, transaction);
  
  }

  /** Envia datos de la transferencia al topico. */
  public void sendCreatedTransferWithdrawalTopic(Withdrawal withdrawal) {
  
    kafkaTemplate.send(transferWithdrawalTopic, withdrawal);
  
  }

  /** Envia datos de la transferencia al topico. */
  public void sendCreatedTransferDepositTopic(Deposit deposit) {
  
    kafkaTemplate.send(transferDepositTopic, deposit);
  
  }  
  
}
