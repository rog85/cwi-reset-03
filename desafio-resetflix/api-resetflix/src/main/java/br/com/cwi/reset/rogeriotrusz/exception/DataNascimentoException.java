package br.com.cwi.reset.rogeriotrusz.exception;

import br.com.cwi.reset.rogeriotrusz.enums.NomeEntidade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataNascimentoException extends Exception{
    public DataNascimentoException(NomeEntidade entidade) {
        super(String.format("Não é possível cadastrar %s não nascidos.",
                entidade.getNome(false).toLowerCase()));
    }
}
