package br.unifei.imc.lojaprodutos.services;

import br.unifei.imc.lojaprodutos.dto.request.CartaoRequest;
import br.unifei.imc.lojaprodutos.dto.response.CartaoResponse;
import br.unifei.imc.lojaprodutos.models.Cartao;
import br.unifei.imc.lojaprodutos.repositories.CartaoRepository;
import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartaoService {

    private ClienteService clienteService;

    private CartaoRepository cartaoRepository;
    private ModelMapper modelMapper;


    public CartaoResponse insertCard(CartaoRequest cartaoRequest) {
        var cliente = clienteService.getCustomerById(cartaoRequest.getId());

        var cartao = modelMapper.map(cartaoRequest, Cartao.class);
        cartao.setCliente(cliente);

        cartao = cartaoRepository.save(cartao);

        return modelMapper.map(cartao, CartaoResponse.class);
    }

    public CartaoResponse getCardByCustomer(Integer id) {
        try {
            var cartao = cartaoRepository.findCartaoByClienteId(id);

            return modelMapper.map(cartao, CartaoResponse.class);
        } catch (ObjectNotFoundException ex) {
            throw new ObjectNotFoundException(1, "Usuário não encontrado.");
        }

    }
}
