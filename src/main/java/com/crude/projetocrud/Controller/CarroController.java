package com.crude.projetocrud.Controller;

import com.crude.projetocrud.ModeloCarro.Carro;
import com.crude.projetocrud.Repository.CarroRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class CarroController {
    CarroRepository repository;

    @GetMapping("/carro")
    public List<Carro> getAllCarros() {
        return repository.findAll();
    }

    @GetMapping("/carro/{id}")
    public Carro getCarroById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping("/carro")
    public Carro saveCarro(@RequestBody Carro carro) {
        return repository.save(carro);
    }

    @PutMapping("/carro")
    public ResponseEntity<Carro> atualizarCarro(@RequestBody Carro carro) {
        Carro carroAtualizado = repository.save(carro);
        return new ResponseEntity<Carro>(carroAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/carro/{id}")
    public void deleteCarro(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
