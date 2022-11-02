package br.unifei.imc.lojaprodutos.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
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

    @ManyToMany(mappedBy = "orders")
    private List<Produto> products;

    @ManyToOne
    @JoinColumn(name = "RF_CLIENTE")
    private Cliente customer;

}