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
@Table(name = "TB_ESTADO")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ESTADO_ID")
    private Integer id;

    @Column(name = "NOME_ESTADO")
    private String nome;

    @OneToMany(mappedBy = "estado")
    private List<Cidade> cidades;

}