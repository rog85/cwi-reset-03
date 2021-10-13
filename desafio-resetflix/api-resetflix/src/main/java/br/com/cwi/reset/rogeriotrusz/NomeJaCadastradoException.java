package br.com.cwi.reset.rogeriotrusz;

public class NomeJaCadastradoException extends Exception{
    public NomeJaCadastradoException(NomeEntidade entidade, String nome) {
        super(String.format("Já existe um %s cadastrado para o nome '%s.'",
                entidade.getNome().toLowerCase(), nome));
    }
}
