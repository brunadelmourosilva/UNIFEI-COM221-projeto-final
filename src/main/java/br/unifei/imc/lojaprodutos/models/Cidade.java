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
@Table(name = "TB_CIDADE")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CIDADE_ID")
    private Integer id;

    @Column(name = "NOME_CIDADE")
    private String nome;

    @OneToMany(mappedBy = "cidade")
    private List<Endereco> enderecos;

    @ManyToOne
    @JoinColumn(name = "RF_ESTADO")
    private Estado estado;

}
