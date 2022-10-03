package br.unifei.imc.lojaprodutos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TB_CATEGORIA")
@Schema(hidden = true)
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORIA_ID")
    private Integer id;

    @Column(name = "NOME_CATEGORIA")
    private String nome;

    @Column(name = "URL_IMAGEM")
    private String imageUrl;

    @JsonIgnore
    @ManyToMany(mappedBy = "categorias")
    private List<Produto> produtos;

}


