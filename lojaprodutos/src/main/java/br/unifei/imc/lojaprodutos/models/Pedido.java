package br.unifei.imc.lojaprodutos.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_PEDIDO")
public class Pedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "PEDIDO_ID")
  private Integer id;

  @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
  @Column(name = "DATA_PEDIDO")
  private Date date;

  @ManyToOne
  @JoinColumn(name = "RF_CLIENTE")
  private Cliente customer;

  @ManyToMany
  @JoinTable(
    name = "TB_PRODUTO_PEDIDO",
    joinColumns = @JoinColumn(name = "RF_PEDIDO"),
    inverseJoinColumns = @JoinColumn(name = "RF_PRODUTO")
  )
  private List<Produto> products;

  @ManyToOne
  @JoinColumn(name = "RF_ENDERECO")
  private Endereco address;

  @Column(name = "VALOR_TOTAL")
  private Double totalPrice;

  @Column(name = "TIPO_PAGAMENTO")
  private Integer payment;
}
