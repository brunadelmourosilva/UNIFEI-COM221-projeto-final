package br.unifei.imc.lojaprodutos.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CidadeResponse {

    private Integer id;
    private String name;

    @JsonIgnore
    private EstadoResponse state;

}
