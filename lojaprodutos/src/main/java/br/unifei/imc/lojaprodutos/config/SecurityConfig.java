package br.unifei.imc.lojaprodutos.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import br.unifei.imc.lojaprodutos.repositories.ClienteRepository;
import br.unifei.imc.lojaprodutos.security.JWTAuthenticationFilter;
import br.unifei.imc.lojaprodutos.security.JWTAuthorizationFilter;
import br.unifei.imc.lojaprodutos.security.JWTUtil;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http
        .headers().frameOptions().disable()
        .and()
        .cors()
        .and()
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/login", "/h2-console/**", "/swagger-ui/**", "/v3/api-docs/**", "/estados/**", "/cidades/**").permitAll()
        .antMatchers("/categorias", "/produtos/**", "/clientes/pedidos/**","/clientes/enderecos/**", "/estados", "/cidades").hasRole("USER")
        .antMatchers(HttpMethod.POST, "/clientes").permitAll()
        .anyRequest().authenticated();

        http.addFilter(new JWTAuthenticationFilter(clienteRepository, authenticationManager(), jwtUtil));
        http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));

    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
        configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedOrigins(Arrays.asList("*"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}