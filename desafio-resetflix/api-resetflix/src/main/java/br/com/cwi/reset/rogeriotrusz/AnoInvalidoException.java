package br.com.cwi.reset.rogeriotrusz;

public class AnoInvalidoException extends Exception {
    public AnoInvalidoException(NomeEntidade entidade) {
        super(String.format("Ano de início de atividade inválido para o %s cadastrado.",
                entidade.getNome().toLowerCase()));
    }
}
