package br.unifei.imc.lojaprodutos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.unifei.imc.lojaprodutos.models.Cliente;
import br.unifei.imc.lojaprodutos.repositories.ClienteRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Cliente cliente = clienteRepository.findByEmail(email);

        return new UsuarioSS(cliente.getId(), cliente.getEmail(), cliente.getPassword(), cliente.rolesAsGrantedAuthorities());
    }
}