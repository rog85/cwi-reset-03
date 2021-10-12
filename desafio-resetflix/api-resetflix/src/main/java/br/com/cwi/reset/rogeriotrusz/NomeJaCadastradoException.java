package br.com.cwi.reset.rogeriotrusz;

public class NomeJaCadastradoException extends Exception{
    public NomeJaCadastradoException(String nome) {
        super(String.format("Já existe um ator cadastrado para o nome %s.", nome));
    }
}
