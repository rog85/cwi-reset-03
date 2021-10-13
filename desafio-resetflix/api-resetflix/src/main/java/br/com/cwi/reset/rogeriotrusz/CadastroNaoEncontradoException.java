package br.com.cwi.reset.rogeriotrusz;

public class CadastroNaoEncontradoException extends Exception{
    public CadastroNaoEncontradoException(String entidade) {
        super(String.format("Nenhum %s cadastrado, favor cadastar %s.",
                entidade, String.format(entidade.concat("es"))));
    }
}
