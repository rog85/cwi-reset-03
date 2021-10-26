package br.com.cwi.reset.rogeriotrusz.request;

import br.com.cwi.reset.rogeriotrusz.enums.StatusAtividade;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class EstudioRequest {

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo 'nome'.")
    private String nome;

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo 'descricao'.")
    private String descricao;

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo 'dataCriacao'.")
    @Past(message = "Não é possível cadastrar estúdios do futuro.")
    private LocalDate dataCriacao;

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo 'statusAtividade'.")
    @Enumerated(EnumType.STRING)
    private StatusAtividade statusAtividade;

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public StatusAtividade getStatusAtividade() {
        return statusAtividade;
    }
}
