package br.com.cwi.reset.rogeriotrusz.controller;

import br.com.cwi.reset.rogeriotrusz.FakeDatabase;
import br.com.cwi.reset.rogeriotrusz.model.Ator;
import br.com.cwi.reset.rogeriotrusz.model.Diretor;
import br.com.cwi.reset.rogeriotrusz.request.AtorRequest;
import br.com.cwi.reset.rogeriotrusz.request.DiretorRequest;
import br.com.cwi.reset.rogeriotrusz.service.DiretorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    private DiretorService diretorService;

    public DiretorController() {
        this.diretorService = new DiretorService(FakeDatabase.getInstance());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarDiretor(@RequestBody DiretorRequest diretorRequest) throws Exception {
        diretorService.cadastrarDiretor(diretorRequest);
    }

    @GetMapping
    public List<Diretor> listarDiretores(@RequestParam String filtroNome) throws Exception {
        return diretorService.listarDiretores(filtroNome);
    }

    @GetMapping("/{id}")
    public Diretor consultarDiretor(@PathVariable Integer id) throws Exception{
        return diretorService.consultarDiretor(id);
    }
}
