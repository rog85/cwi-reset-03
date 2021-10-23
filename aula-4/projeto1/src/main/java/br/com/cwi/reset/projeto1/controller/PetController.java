package br.com.cwi.reset.projeto1.controller;

import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.exception.PetJaExistenteException;
import br.com.cwi.reset.projeto1.exception.PetNaoExistenteException;
import br.com.cwi.reset.projeto1.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    private PetService petService = new PetService();

    @PostMapping
    public ResponseEntity<Pet> cadastrarPet(@RequestBody Pet pet) {
        try {
            Pet petSalvo = petService.salvar(pet);
            return ResponseEntity.ok(petSalvo);
        } catch (PetJaExistenteException ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public List<Pet> getPet() {
        return petService.listarTodos();
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Pet> getByNome(@PathVariable String nome) {
        Pet pet = petService.buscarPorNome(nome);
        if (pet == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pet);
    }

    @PutMapping
    public ResponseEntity<Pet> atualizarPet(@RequestBody Pet pet) {
        try {
            return ResponseEntity.ok(petService.atualizar(pet));
        } catch (PetNaoExistenteException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{nome}")
    public ResponseEntity deletarPet(@PathVariable String nome) {
        try {
            petService.deletar(nome);
            return ResponseEntity.ok().build();
        } catch (PetNaoExistenteException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
