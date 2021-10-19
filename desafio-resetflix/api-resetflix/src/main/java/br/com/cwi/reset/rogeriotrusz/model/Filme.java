package br.com.cwi.reset.rogeriotrusz.model;

import br.com.cwi.reset.rogeriotrusz.enums.Genero;
import java.util.List;

public class Filme {
    private Integer id;
    private String nome;
    private Integer anoLancamento;
    private String capaFilme;
    private List<Genero> generos;
    private Diretor diretor;
    private Estudio estudio;
    private List<PersonagemAtor> personagens;
    private String resumo;

}