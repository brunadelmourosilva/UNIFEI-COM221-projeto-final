package br.unifei.imc.lojaprodutos.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TB_CIDADE")
public class Cidade {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CIDADE_ID")
  private Integer id;

  @Column(name = "NOME_CIDADE")
  private String name;

  @OneToMany(mappedBy = "city")
  private List<Endereco> addresses;

  @ManyToOne
  @JoinColumn(name = "RF_ESTADO")
  private Estado state;

  public Cidade(String name, Estado state) {
    this.name = name;
    this.state = state;
  }
}
