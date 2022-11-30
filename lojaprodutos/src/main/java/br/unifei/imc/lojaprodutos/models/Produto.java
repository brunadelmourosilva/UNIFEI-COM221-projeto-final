package br.unifei.imc.lojaprodutos.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_PRODUTO")
public class Produto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "PRODUTO_ID")
  private Integer id;

  @Column(name = "NOME_PRODUTO")
  private String name;

  @Column(name = "PRECO")
  private Double price;

  @Column(name = "URL_IMAGEM")
  private String image;

  @ManyToMany
  @JoinTable(
    name = "TB_PRODUTO_CATEGORIA",
    joinColumns = @JoinColumn(name = "RF_PRODUTO"),
    inverseJoinColumns = @JoinColumn(name = "RF_CATEGORIA")
  )
  private List<Categoria> categories;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
    name = "TB_PRODUTO_PEDIDO",
    joinColumns = @JoinColumn(name = "RF_PRODUTO"),
    inverseJoinColumns = @JoinColumn(name = "RF_PEDIDO")
  )
  private List<Pedido> orders;

  public Produto(String name, Double price, String image, List<Categoria> categories) {
    this.name = name;
    this.price = price;
    this.image = image;
    this.categories = categories;
  }
}
