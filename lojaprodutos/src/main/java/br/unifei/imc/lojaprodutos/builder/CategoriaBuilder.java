package br.unifei.imc.lojaprodutos.builder;


import br.unifei.imc.lojaprodutos.models.Categoria;

public class CategoriaBuilder{

    private String name;

    private String image;

    public static CategoriaBuilder builder() {
        return new CategoriaBuilder();
    }

    public CategoriaBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CategoriaBuilder image(String image) {
        this.image = image;
        return this;
    }

    public Categoria build() {
        return new Categoria(name, image);
    }
}
