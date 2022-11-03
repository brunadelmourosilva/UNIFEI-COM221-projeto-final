package br.unifei.imc.lojaprodutos.factory;

import br.unifei.imc.lojaprodutos.models.Cidade;
import br.unifei.imc.lojaprodutos.models.Estado;

import java.util.List;

public class CidadeFactory {

    public static List<Cidade> createCidades(List<Estado> estados){

        var sp = estados.get(0);
        var mg = estados.get(1);
        var rj = estados.get(2);

        return List.of(
                Cidade.builder().name("Campinas").state(sp).build(),
                Cidade.builder().name("Itajubá").state(mg).build(),
                Cidade.builder().name("Ouro Fino").state(mg).build(),
                Cidade.builder().name("Santa Rita do Sapucaí").state(mg).build(),
                Cidade.builder().name("Rezende").state(rj).build()
        );
    }

}
