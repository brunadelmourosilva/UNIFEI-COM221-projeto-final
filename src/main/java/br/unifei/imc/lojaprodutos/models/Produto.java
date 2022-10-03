package br.unifei.imc.lojaprodutos.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TB_PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUTO_ID")
    private Integer id;

    @Column(name = "NOME_PRODUTO")
    private String nome;

    @Column(name = "QTD_ESTOQUE")
    private Integer estoque;

    @Column(name = "PRECO")
    private Double preco;

    @Column(name = "URL_IMAGEM")
    private String imageUrl;

    @ManyToMany
    @JoinTable(
            name = "TB_PRODUTO_CATEGORIA",
            joinColumns = @JoinColumn(name = "RF_PRODUTO"),
            inverseJoinColumns = @JoinColumn(name = "RF_CATEGORIA"))
    private List<Categoria> categorias;

    @ManyToMany
    @JoinTable(
            name = "TB_PRODUTO_PEDIDO",
            joinColumns = @JoinColumn(name = "RF_PRODUTO"),
            inverseJoinColumns = @JoinColumn(name = "RF_PEDIDO"))
    private List<Pedido> pedidos;

}