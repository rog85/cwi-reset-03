package br.com.cwi.reset.rogeriotrusz;

public class DataNascimentoException extends Exception{
    public DataNascimentoException() {
        super("Não é possível cadastrar atores não nascidos.");
    }
}
