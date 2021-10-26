package br.com.cwi.reset.rogeriotrusz.request;

import br.com.cwi.reset.rogeriotrusz.enums.TipoAtuacao;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class PersonagemAtorRequest {

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo 'idAtor'.")
    private Integer idAtor;

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo 'nomePersonagem'.")
    private String nomePersonagem;

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo 'descricaoPersonagem'.")
    private String descricaoPersonagem;

    @Enumerated(EnumType.STRING)
    private TipoAtuacao tipoAtuacao;

    public PersonagemAtorRequest(Integer idAtor, String nomePersonagem, String descricaoPersonagem, TipoAtuacao tipoAtuacao) {
        this.idAtor = idAtor;
        this.nomePersonagem = nomePersonagem;
        this.descricaoPersonagem = descricaoPersonagem;
        this.tipoAtuacao = tipoAtuacao;
    }

    public Integer getIdAtor() {
        return idAtor;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public String getDescricaoPersonagem() {
        return descricaoPersonagem;
    }

    public TipoAtuacao getTipoAtuacao() {
        return tipoAtuacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonagemAtorRequest that = (PersonagemAtorRequest) o;
        return Objects.equals(idAtor, that.idAtor) && Objects.equals(nomePersonagem, that.nomePersonagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAtor, nomePersonagem);
    }
}
