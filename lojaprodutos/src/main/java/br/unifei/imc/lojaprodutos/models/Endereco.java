package br.unifei.imc.lojaprodutos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private String street;

    @Column(name = "NUMERO")
    private String number;

    @Column(name = "COMPLEMENTO")
    private String complement;

    @Column(name = "BAIRRO")
    private String neighborhood;

    @JsonIgnore
    @Column(name = "CEP")
    private String zipCode;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "RF_CLIENTE")
    private Cliente customer;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "RF_CIDADE")
    private Cidade city;

    @OneToMany(mappedBy = "address")
    private List<Pedido> order;

}
