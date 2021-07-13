package com.everis.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * Clase Response.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
public class Response {
  private Object data;
  private String error;
}
