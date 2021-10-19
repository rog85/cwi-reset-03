package br.com.cwi.reset.rogeriotrusz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GeneroDuplicadoException extends Exception{
    public GeneroDuplicadoException(){
        super("Não é permitido informar o mesmo gênero mais de uma vez para o mesmo filme.");
    }
}
