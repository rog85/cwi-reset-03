package br.com.cwi.reset.rogeriotrusz;

public class NomeJaCadastradoException extends Exception{
    public NomeJaCadastradoException(String entidade, String nome) {
        super(String.format("Já existe um %s cadastrado para o nome %s.", entidade, nome));
    }
}
