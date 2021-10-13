package br.com.cwi.reset.rogeriotrusz;

public class IdNaoEncontradoException extends Exception {
    public IdNaoEncontradoException(NomeEntidade entidade, Integer id) {
        super(String.format("Nenhum %s encontrado com o parâmetro id=%s, favor verifique os parâmetros informados.",
                entidade.getNome().toLowerCase(), id.toString()));
    }
}
