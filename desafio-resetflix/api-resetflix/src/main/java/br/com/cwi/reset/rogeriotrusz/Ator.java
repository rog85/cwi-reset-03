package br.com.cwi.reset.rogeriotrusz;

import java.time.LocalDate;

public class Ator {

    private Integer id;
    private String nome;
    private LocalDate dataNascimento;
    private StatusCarreira statusCarreira;
    private Integer anoInicioAtividade;

    public String getNome(){
        return nome;
    }
}
