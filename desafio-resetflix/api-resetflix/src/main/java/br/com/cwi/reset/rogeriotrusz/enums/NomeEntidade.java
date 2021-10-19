package br.com.cwi.reset.rogeriotrusz.enums;

public enum NomeEntidade {
    ATOR("Ator", "Atores"),
    DIRETOR("Diretor", "Diretores"),
    ESTUDIO("Estúdio", "Estúdios");

    private String nome;
    private String plural;

    NomeEntidade(String nome, String plural) {
        this.nome = nome;
        this.plural = plural;
    }

    public String getNome(Boolean singular) {
        if(singular)
            return nome;
        return plural;
    }
}
