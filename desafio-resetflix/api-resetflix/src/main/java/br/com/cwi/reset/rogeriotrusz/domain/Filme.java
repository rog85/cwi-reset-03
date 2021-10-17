package br.com.cwi.reset.rogeriotrusz.domain;

import br.com.cwi.reset.rogeriotrusz.enums.Genero;

import java.util.List;

public class Filme {
    private Integer id;
    private String nome;
    private Integer anoLancamento;
    private String capaFilme;
    private List<Genero> generos;
    private Diretor diretor;
    private List<PersonagemAtor> personagens;
    private String resumo;

}
