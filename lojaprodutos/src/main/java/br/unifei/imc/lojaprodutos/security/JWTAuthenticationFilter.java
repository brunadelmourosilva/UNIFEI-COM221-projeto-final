package br.unifei.imc.lojaprodutos.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.unifei.imc.lojaprodutos.models.Cliente;
import br.unifei.imc.lojaprodutos.models.RetornoLogin;
import br.unifei.imc.lojaprodutos.repositories.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private ClienteRepository clienteRepository;
    private AuthenticationManager authenticationManager;
    private JWTUtil jwtUtil;


    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {

        try {
            Credenciais creds = new ObjectMapper()
                    .readValue(req.getInputStream(), Credenciais.class);

            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getSenha(), new ArrayList<>());

            Authentication auth = authenticationManager.authenticate(authToken);

            return auth;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        UsuarioSS usuario = (UsuarioSS) auth.getPrincipal();

        String token = "Bearer " + jwtUtil.generateToken(usuario);

        Cliente cliente = clienteRepository.findByEmail(usuario.getEmail());

        RetornoLogin retornoLogin = jwtUtil.constroiRetornoLogin(cliente, token);

        setHttpResponseConfigs(res, retornoLogin);

    }

    private void setHttpResponseConfigs(HttpServletResponse res, RetornoLogin retorno){

        String json;
        try {
            json = new ObjectMapper().writeValueAsString(retorno);

            res.setStatus(HttpStatus.OK.value());
            res.setContentType("application/json");
            res.setCharacterEncoding("UTF-8");
            res.getWriter().write(json);
            res.flushBuffer();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    

}