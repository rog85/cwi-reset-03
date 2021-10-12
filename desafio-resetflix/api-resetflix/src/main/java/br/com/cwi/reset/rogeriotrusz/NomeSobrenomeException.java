package br.com.cwi.reset.rogeriotrusz;

public class NomeSobrenomeException extends Exception{
    public NomeSobrenomeException(String entidade) {
        super(String.format("Deve ser informado no mínimo nome e sobrenome para o %s.", entidade));
    }
}
