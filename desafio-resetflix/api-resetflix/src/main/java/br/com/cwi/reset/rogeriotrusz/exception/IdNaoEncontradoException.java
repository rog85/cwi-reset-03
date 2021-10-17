package br.com.cwi.reset.rogeriotrusz.exception;

import br.com.cwi.reset.rogeriotrusz.enums.NomeEntidade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IdNaoEncontradoException extends Exception {
    public IdNaoEncontradoException(NomeEntidade entidade, Integer id) {
        super(String.format("Nenhum %s encontrado com o parâmetro id=%s, favor verifique os parâmetros informados.",
                entidade.getNome().toLowerCase(), id.toString()));
    }
}
