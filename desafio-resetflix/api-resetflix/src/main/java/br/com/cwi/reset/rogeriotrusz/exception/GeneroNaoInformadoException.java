package br.com.cwi.reset.rogeriotrusz.exception;

public class GeneroNaoInformadoException extends Exception{
    public GeneroNaoInformadoException(){
        super("Deve ser informado pelo menos um gênero para o cadastro do filme.");
    }
}
