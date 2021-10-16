package br.com.cwi.reset.primeiroprojetospring.controller;

import br.com.cwi.reset.primeiroprojetospring.domain.Diretor;
import br.com.cwi.reset.primeiroprojetospring.domain.Filme;
import br.com.cwi.reset.primeiroprojetospring.domain.Genero;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class FilmeController {

    @GetMapping("/filme")
    public Filme getFilme(){
        Diretor diretor = new Diretor("Christopher Nolan", LocalDate.parse("1970-07-30"), 10, Genero.MASCULINO);
        Filme filme =  new Filme("Interestelar", "Conta a história de uma equipe de astronautas que viaja através de um buraco de minhoca à procura de um novo lar para a humanidade.", 169, 2014, 5, diretor);
        return filme;
    }
}
