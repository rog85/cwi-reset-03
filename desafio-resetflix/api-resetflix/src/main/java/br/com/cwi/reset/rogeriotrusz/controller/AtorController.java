package br.com.cwi.reset.rogeriotrusz.controller;

import br.com.cwi.reset.rogeriotrusz.model.Ator;
import br.com.cwi.reset.rogeriotrusz.request.AtorRequest;
import br.com.cwi.reset.rogeriotrusz.response.AtorEmAtividade;
import br.com.cwi.reset.rogeriotrusz.service.AtorService;
import br.com.cwi.reset.rogeriotrusz.FakeDatabase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/atores")
public class AtorController {

    private AtorService atorService;

    public AtorController() {
        this.atorService = new AtorService(FakeDatabase.getInstance());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAtor(@RequestBody AtorRequest atorRequest) throws Exception {
        atorService.criarAtor(atorRequest);
    }

    @GetMapping("/em_atividade")
    public List<AtorEmAtividade> listarAtoresEmAtividade(@RequestParam String filtroNome) throws Exception {
        return atorService.listarAtoresEmAtividade(filtroNome);
    }

    @GetMapping("/{id}")
    public Ator consultarAtor(@PathVariable Integer id) throws Exception{
        return atorService.consultarAtor(id);
    }

    @GetMapping
    public List<Ator> consultarAtores() throws Exception{
        return atorService.consultarAtores();
    }
}