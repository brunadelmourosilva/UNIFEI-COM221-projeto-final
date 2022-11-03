package br.unifei.imc.lojaprodutos.dto.response;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponse {

    private Integer id;
    private Date dataPedido;
    private List<ProdutoResponse> produtos;
    
}
