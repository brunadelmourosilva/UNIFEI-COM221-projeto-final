package br.unifei.imc.lojaprodutos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TB_ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ENDERECO_ID")
    private Integer id;

    @Column(name = "RUA")
    private String rua;

    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @Column(name = "BAIRRO")
    private String bairro;

    @Column(name = "CEP")
    private String cep;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "RF_CLIENTE")
    private Cliente cliente;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "RF_CIDADE")
    private Cidade cidade;

}
