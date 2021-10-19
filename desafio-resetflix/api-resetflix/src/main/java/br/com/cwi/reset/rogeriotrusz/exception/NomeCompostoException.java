package br.com.cwi.reset.rogeriotrusz.exception;

import br.com.cwi.reset.rogeriotrusz.enums.NomeEntidade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NomeCompostoException extends Exception{
    public NomeCompostoException(NomeEntidade entidade) {
        super(String.format("Deve ser informado no mínimo nome e sobrenome para o %s.",
                entidade.getNome(true).toLowerCase()));
    }
}
