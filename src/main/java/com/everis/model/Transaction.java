package com.everis.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Clase Transaction.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "transaction")
@Data
@Builder
public class Transaction {
  
  @Id
  private String id;

  @Field(name = "transactionType")
  private String transactionType;

  @Field(name = "transactionAmount")
  private Double transactionAmount;

  @Field(name = "commission")
  private Double commission;
  
  @Field(name = "account")
  private Account account;

  @Field(name = "purchase")
  private Purchase purchase;

  @Field(name = "description")
  private String description;

  @Field(name = "transactionDate")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime transactionDate;
  
}
