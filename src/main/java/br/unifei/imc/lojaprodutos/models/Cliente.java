package br.unifei.imc.lojaprodutos.models;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Table(name = "TB_CLIENTE")
@Schema(hidden = true)
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String email;

    private String cpf;

    private String imageUrl;

    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

}
