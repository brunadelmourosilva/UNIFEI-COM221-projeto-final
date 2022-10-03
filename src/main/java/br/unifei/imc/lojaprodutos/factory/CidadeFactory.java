package br.unifei.imc.lojaprodutos.factory;

import br.unifei.imc.lojaprodutos.models.Categoria;
import br.unifei.imc.lojaprodutos.models.Cidade;
import br.unifei.imc.lojaprodutos.models.Estado;

import java.util.List;

public class CidadeFactory {

    public static List<Cidade> createCidades(List<Estado> estados){

        Estado sp = estados.get(0);
        Estado mg = estados.get(1);
        Estado rj = estados.get(2);

        return List.of(
                Cidade.builder().nome("Campinas").estado(sp).build(),
                Cidade.builder().nome("Itajubá").estado(mg).build(),
                Cidade.builder().nome("Rezende").estado(rj).build()
        );
    }

}