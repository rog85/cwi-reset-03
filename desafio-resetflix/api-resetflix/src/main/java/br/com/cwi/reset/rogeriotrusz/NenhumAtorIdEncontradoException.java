package br.com.cwi.reset.rogeriotrusz;

public class NenhumAtorIdEncontradoException extends Exception {
    public NenhumAtorIdEncontradoException(Integer id) {
        super(String.format("Nenhum ator encontrado com o parâmetro id=%s, favor verifique os parâmetros informados.", id.toString()));
    }
}
