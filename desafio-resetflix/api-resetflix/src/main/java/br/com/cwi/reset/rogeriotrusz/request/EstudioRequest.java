package br.com.cwi.reset.rogeriotrusz.request;

import br.com.cwi.reset.rogeriotrusz.enums.StatusAtividade;
import java.time.LocalDate;

public class EstudioRequest {
    private String nome;
    private String descricao;
    private LocalDate dataCriacao;
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
