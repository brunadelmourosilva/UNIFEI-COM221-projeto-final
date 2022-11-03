package br.unifei.imc.lojaprodutos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteResponse {

    private String name;

    private String email;

    private String image;

}
