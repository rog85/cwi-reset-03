package br.com.cwi.reset.primeiroprojetospring.controller;

import br.com.cwi.reset.primeiroprojetospring.domain.Diretor;
import br.com.cwi.reset.primeiroprojetospring.domain.Filme;
import br.com.cwi.reset.primeiroprojetospring.domain.Genero;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    private static List<Filme> listaFilmes = new ArrayList<>();

    @GetMapping
    public List<Filme> listarFilmes(){
        return listaFilmes;
    }

    @PostMapping
    public ResponseEntity<Filme> cadastrarFilme(@RequestBody Filme novoFilme){
        Boolean filmeJaExiste = false;
        for(Filme f : listaFilmes){
            if(novoFilme.getNome().equals(f.getNome())){
                filmeJaExiste = true;
            }
        }
        if(filmeJaExiste == true)
            ResponseEntity.badRequest().build();

        listaFilmes.add(novoFilme);
        return ResponseEntity.ok(novoFilme);
    }

    @GetMapping("/{nome}")
    public Filme buscarFilme(@PathVariable String nome){
        Filme encontrado = null;
        for(Filme f : listaFilmes){
            if(f.getNome().equals(nome)){
                encontrado = f;
            }
        }
        return encontrado;
    }

    @DeleteMapping("/{nome}")
    public void apagarFilme(@PathVariable String nome){
        for(Filme f : listaFilmes){
            if(f.getNome().equals(nome)){
                listaFilmes.remove(f);
            }
        }
    }

    @PutMapping
    public Filme atualizarFilme(@RequestBody Filme atualizado){
        Filme resultado = null;
        for(Filme f : listaFilmes){
            if(f.getNome().equals(atualizado.getNome())){
                listaFilmes.remove(f);
                listaFilmes.add(atualizado);
                resultado = atualizado;
            }
        }
        return resultado;
    }
}
