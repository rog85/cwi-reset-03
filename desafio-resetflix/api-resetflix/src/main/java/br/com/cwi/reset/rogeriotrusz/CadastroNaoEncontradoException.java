package br.com.cwi.reset.rogeriotrusz;

public class CadastroNaoEncontradoException extends Exception{
    public CadastroNaoEncontradoException(NomeEntidade entidade) {
        super(String.format("Nenhum %s cadastrado, favor cadastar %s.",
                entidade.getNome().toLowerCase(), entidade.getNome().toLowerCase().concat("es")));
    }
}
