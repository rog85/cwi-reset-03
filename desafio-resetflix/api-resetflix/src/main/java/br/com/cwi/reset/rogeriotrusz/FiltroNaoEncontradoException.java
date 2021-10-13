package br.com.cwi.reset.rogeriotrusz;

public class FiltroNaoEncontradoException extends Exception{
    public FiltroNaoEncontradoException(String entidade, String filtro) {
        super(String.format("%s não encontrato com o filtro %s, favor informar outro filtro.",
                entidade, filtro));
    }
}
