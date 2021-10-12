package br.com.cwi.reset.rogeriotrusz;

public class NenhumAtorCadastradoException extends Exception{
    public NenhumAtorCadastradoException() {
        super("Nenhum ator cadastrado, favor cadastar atores.");
    }
}
