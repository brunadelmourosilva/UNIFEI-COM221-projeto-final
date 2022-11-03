package br.unifei.imc.lojaprodutos.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RetornoLogin {

    private Cliente cliente;
    private String token;
    
}
