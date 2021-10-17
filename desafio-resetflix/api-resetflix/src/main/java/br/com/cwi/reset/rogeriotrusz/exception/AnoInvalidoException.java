package br.com.cwi.reset.rogeriotrusz.exception;

import br.com.cwi.reset.rogeriotrusz.enums.NomeEntidade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AnoInvalidoException extends Exception {
    public AnoInvalidoException(NomeEntidade entidade) {
        super(String.format("Ano de início de atividade inválido para o %s cadastrado.",
                entidade.getNome().toLowerCase()));
    }
}
