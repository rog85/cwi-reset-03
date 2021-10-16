package br.com.cwi.reset.primeiroprojetospring.domain;

import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    private Genero genero;

    public Pessoa(String nome, LocalDate dataNascimento, Genero genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }

    public void Apresentacao(){
        System.out.println("--PESSOA--");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + calcularIdade(dataNascimento) + " anos");
        System.out.println("Gênero: " + genero.getDescricao());
        System.out.println("-----");
    }

    public String getNome() {
        return nome;
    }

    private int calcularIdade(LocalDate dataNascimento){
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }
}
