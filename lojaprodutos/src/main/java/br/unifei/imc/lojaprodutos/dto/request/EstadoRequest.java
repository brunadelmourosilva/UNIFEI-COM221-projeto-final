package br.unifei.imc.lojaprodutos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EstadoRequest {

    private Integer id;

    private String name;
}
