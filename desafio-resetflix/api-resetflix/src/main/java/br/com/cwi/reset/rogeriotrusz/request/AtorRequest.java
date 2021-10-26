package br.com.cwi.reset.rogeriotrusz.request;

import br.com.cwi.reset.rogeriotrusz.enums.StatusCarreira;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class AtorRequest {

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo 'nome'.")
    @Pattern(regexp = "^([A-z\\'\\.-ᶜ]*(\\s))+[A-z\\'\\.-ᶜ]*$", message = "Deve ser informado no mínimo nome e sobrenome para o ator.")
    private String nome;

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo 'dataNascimento'.")
    @Past(message = "Não é possível cadastrar atores não nascidos.")
    private LocalDate dataNascimento;

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo 'statusCarreira'.")
    @Enumerated(EnumType.STRING)
    private StatusCarreira statusCarreira;

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo 'anoInicioAtividade'.")
    private Integer anoInicioAtividade;

    public AtorRequest(String nome, LocalDate dataNascimento, StatusCarreira statusCarreira, Integer anoInicioAtividade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.statusCarreira = statusCarreira;
        this.anoInicioAtividade = anoInicioAtividade;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public StatusCarreira getStatusCarreira() {
        return statusCarreira;
    }

    public Integer getAnoInicioAtividade() {
        return anoInicioAtividade;
    }
}
