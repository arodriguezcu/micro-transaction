package com.everis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Clase Account.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "account")
@Data
public class Account {
  
  @Id
  private String id;

  @Field(name = "accountNumber")
  private String accountNumber;
  
  @Field(name = "purchase")
  private Purchase purchase;

  @Field(name = "currentBalance")
  private Double currentBalance;

}