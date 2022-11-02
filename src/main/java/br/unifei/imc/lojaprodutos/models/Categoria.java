package br.unifei.imc.lojaprodutos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TB_CATEGORIA")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORIA_ID")
    private Integer id;

    @Column(name = "NOME_CATEGORIA")
    private String name;

    @Column(name = "URL_IMAGEM")
    private String image;

    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    private List<Produto> products;

}


