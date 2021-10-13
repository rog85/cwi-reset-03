package br.com.cwi.reset.rogeriotrusz;

public class NomeCompostoException extends Exception{
    public NomeCompostoException(NomeEntidade entidade) {
        super(String.format("Deve ser informado no mínimo nome e sobrenome para o %s.",
                entidade.getNome().toLowerCase()));
    }
}
