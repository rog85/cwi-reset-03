package br.com.cwi.reset.primeiroprojetospring.domain;

import java.time.LocalDate;

public class Diretor extends Pessoa{

    private int qtdFilmesDirigidos;

    public int getQtdFilmesDirigidos() {
        return qtdFilmesDirigidos;
    }

    public Diretor(String nome, LocalDate dataNascimento, int qtdFilmesDirigidos, Genero genero) {
        super(nome, dataNascimento, genero);
        this.qtdFilmesDirigidos = qtdFilmesDirigidos;
    }

}
