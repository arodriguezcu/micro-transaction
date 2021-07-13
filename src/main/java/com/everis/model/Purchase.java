package com.everis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Clase Purchase.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "purchase")
@Data
public class Purchase {
  
  @Id
  private String id;

  @Field(name = "product")
  private Product product;

  @Field(name = "cardNumber")
  private String cardNumber;

  @Field(name = "amountIni")
  private Double amountIni;

  @Field(name = "amountFin")
  private Double amountFin;

}
