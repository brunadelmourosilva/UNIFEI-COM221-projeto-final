package br.unifei.imc.lojaprodutos.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLIENTE_ID")
    private Integer id;

    @Column(name = "NOME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @JsonIgnore
    @Column(name = "SENHA")
    private String password;

    @JsonIgnore
    @OneToOne(mappedBy = "cliente", fetch = FetchType.LAZY)
    private Cartao cartao;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Endereco> addresses;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Pedido> orders;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<Role> roles;

    public List<GrantedAuthority> rolesAsGrantedAuthorities(){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNomeRole())).collect(Collectors.toList());
    }

}
