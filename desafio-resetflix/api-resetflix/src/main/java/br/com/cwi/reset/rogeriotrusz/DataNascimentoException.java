package br.com.cwi.reset.rogeriotrusz;

public class DataNascimentoException extends Exception{
    public DataNascimentoException(String entidade) {
        super(String.format("Não é possível cadastrar %s não nascidos.", entidade));
    }
}
