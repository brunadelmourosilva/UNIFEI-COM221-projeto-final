package br.unifei.imc.lojaprodutos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TB_CARTAO")
public class Cartao {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CARTAO_ID")
  private Integer id;

  @Column(name = "NUMERO_CARTAO")
  private String cardNumber;

  @Column(name = "VALIDADE")
  private String validity;

  @JsonIgnore
  @Column(name = "CODIGO_SEGURANCA")
  private String securityCode;

  @JsonIgnore
  @OneToOne
  @JoinColumn(name = "RF_CLIENTE")
  private Cliente cliente;

  public Cartao(String cardNumber, String validity, String securityCode, Cliente cliente) {
    this.cardNumber = cardNumber;
    this.validity = validity;
    this.securityCode = securityCode;
    this.cliente = cliente;
  }
}
