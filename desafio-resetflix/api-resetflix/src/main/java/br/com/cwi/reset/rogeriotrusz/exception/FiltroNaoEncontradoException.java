package br.com.cwi.reset.rogeriotrusz.exception;

import br.com.cwi.reset.rogeriotrusz.enums.NomeEntidade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FiltroNaoEncontradoException extends Exception{
    public FiltroNaoEncontradoException(NomeEntidade entidade, String filtro) {
        super(String.format("%s não encontrato com o filtro '%s', favor informar outro filtro.",
                entidade.getNome(true), filtro));
    }
}
