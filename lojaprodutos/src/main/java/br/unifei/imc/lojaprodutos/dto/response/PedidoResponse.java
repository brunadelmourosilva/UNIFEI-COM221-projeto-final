package br.unifei.imc.lojaprodutos.dto.response;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponse {

    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy hh:MM:ss")
    private Date dataPedido;

    private List<ProdutoResponse> produtos;
    
}
