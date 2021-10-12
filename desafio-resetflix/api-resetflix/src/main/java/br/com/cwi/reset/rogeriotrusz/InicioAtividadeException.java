package br.com.cwi.reset.rogeriotrusz;

public class InicioAtividadeException extends Exception {
    public InicioAtividadeException(String entidade) {
        super(String.format("Ano de início de atividade inválido para o %s cadastrado.", entidade));
    }
}
