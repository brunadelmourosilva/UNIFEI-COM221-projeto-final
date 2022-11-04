package br.unifei.imc.lojaprodutos.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartaoRequest {

    private String cardNumber;

    private String validity;

    private String securityCode;

    @JsonProperty(value = "clienteId")
    private Integer id;
}
