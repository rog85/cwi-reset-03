package br.com.cwi.reset.rogeriotrusz.exception;

import br.com.cwi.reset.rogeriotrusz.enums.NomeEntidade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NomeJaCadastradoException extends Exception{
    public NomeJaCadastradoException(NomeEntidade entidade, String nome) {
        super(String.format("Já existe um %s cadastrado para o nome '%s.'",
                entidade.getNome().toLowerCase(), nome));
    }
}
