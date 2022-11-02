package br.unifei.imc.lojaprodutos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CidadeResponse {

    private String name;
    private EstadoResponse state;

}
