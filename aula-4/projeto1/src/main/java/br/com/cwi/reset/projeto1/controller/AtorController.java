package br.com.cwi.reset.projeto1.controller;

import br.com.cwi.reset.projeto1.domain.Ator;
import br.com.cwi.reset.projeto1.service.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ator")
public class AtorController {

    @Autowired
    private AtorService service;

    @PostMapping
    public Ator cadastrarAtor(@RequestBody Ator ator) throws Exception {
        return service.salvar(ator);
    }

    @GetMapping("/{nome}")
    public Ator buscarPorNome(@PathVariable String nome) {
        return service.buscarPorNome(nome);
    }

    @GetMapping("{oscars}")
    public List<Ator> buscarPorOscars(@RequestParam Integer oscars) {
        return service.buscarPorOscars(oscars);
    }

    @DeleteMapping("/{id}")
    public void deletarAtor(@PathVariable Integer id) throws Exception {
        service.deletar(id);
    }

    @GetMapping("/filtro")
    public List<Ator> buscarPorFiltro(@RequestParam Integer numeroOscars, Integer anoNascimento) {
        return service.buscarPorFiltro(numeroOscars, anoNascimento);
    }

}
