package br.com.cwi.reset.rogeriotrusz.enums;

public enum NomeEntidade {
    ATOR("Ator"),
    DIRETOR("Diretor");

    private String nome;

    NomeEntidade(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
