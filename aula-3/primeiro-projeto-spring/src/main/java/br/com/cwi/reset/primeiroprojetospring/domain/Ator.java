package br.com.cwi.reset.primeiroprojetospring.domain;

import java.time.LocalDate;

public class Ator extends Pessoa{

    private int nroOscarsGanhos;

    public Ator(String nome, LocalDate dataNascimento, int nroOscarsGanhos, Genero genero) {
        super(nome, dataNascimento, genero);
        this.nroOscarsGanhos = nroOscarsGanhos;
    }
}
