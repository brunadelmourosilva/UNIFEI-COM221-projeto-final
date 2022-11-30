package br.unifei.imc.lojaprodutos.exceptions;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {

  private String msg;

  @JsonFormat(pattern = "dd/MM/yyyy H:mm:ss", locale = "pt_BR", timezone = "Brazil/East")
  private Date timestamp;
}
