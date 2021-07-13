package com.everis.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Clase CreditPayment.
 */
@Document(collection = "credit_consumer")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CreditPayment {

  @Id
  private String id;
  
  @Field(name = "amount")
  private Double amount;
  
  @Field(name = "purchase")
  private Purchase purchase;
  
  @Field(name = "description")
  private String description;
  
  @Field(name = "paymentDate")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime paymentDate;
  
}
