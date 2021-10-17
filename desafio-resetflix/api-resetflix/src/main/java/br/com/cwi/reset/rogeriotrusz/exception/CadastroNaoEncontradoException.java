package br.com.cwi.reset.rogeriotrusz.exception;

import br.com.cwi.reset.rogeriotrusz.enums.NomeEntidade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CadastroNaoEncontradoException extends Exception{
    public CadastroNaoEncontradoException(NomeEntidade entidade) {
        super(String.format("Nenhum %s cadastrado, favor cadastar %s.",
                entidade.getNome().toLowerCase(), entidade.getNome().toLowerCase().concat("es")));
    }
}
