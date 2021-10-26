package br.com.cwi.reset.rogeriotrusz.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class DiretorRequest {

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo 'nome'.")
    @Pattern(regexp = "^([A-z\\'\\.-ᶜ]*(\\s))+[A-z\\'\\.-ᶜ]*$", message = "Deve ser informado no mínimo nome e sobrenome para o diretor.")
    private String nome;

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo 'dataNascimento'.")
    @Past(message = "Não é possível cadastrar diretores não nascidos.")
    private LocalDate dataNascimento;

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo 'anoInicioAtividade'.")
    private Integer anoInicioAtividade;

    public DiretorRequest(String nome, LocalDate dataNascimento, Integer anoInicioAtividade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.anoInicioAtividade = anoInicioAtividade;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Integer getAnoInicioAtividade() {
        return anoInicioAtividade;
    }
}
