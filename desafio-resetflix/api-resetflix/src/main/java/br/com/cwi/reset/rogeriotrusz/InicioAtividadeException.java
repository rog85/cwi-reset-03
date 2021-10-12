package br.com.cwi.reset.rogeriotrusz;

public class InicioAtividadeException extends Exception {
    public InicioAtividadeException() {
        super("Ano de início de atividade inválido para o ator cadastrado.");
    }
}
