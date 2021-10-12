package br.com.cwi.reset.rogeriotrusz;

public class NenhumAtorFiltroException extends Exception{
    public NenhumAtorFiltroException(String filtro) {
        super(String.format("Ator não encontrato com o filtro %s, favor informar outro filtro.", filtro));
    }
}
