package br.unifei.imc.lojaprodutos.models;

import java.util.List;

import br.unifei.imc.lojaprodutos.dto.request.EnderecoRequest;
import br.unifei.imc.lojaprodutos.dto.request.ProdutoRequest;

public class FinalizaPedido {

    private Integer id;
    private String email;
    private EnderecoRequest endereco;
    private List<ProdutoRequest> produtos;
    private Double valorTotal;


    
}
