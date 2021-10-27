package br.com.cwi.reset.rogeriotrusz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DiretorVinculadoException extends Exception{
    public DiretorVinculadoException(){
        super("Este diretor está vinculado a um ou mais filmes, para remover o diretor é necessário remover os seus filmes de participação.");
    }
}
