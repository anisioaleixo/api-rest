package br.com.anisioaleixo.api_rest.controllers;

import br.com.anisioaleixo.api_rest.model.Person;
import br.com.anisioaleixo.api_rest.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonServices services;

    @GetMapping(produces = "application/json")
    public List<Person> findAll() {
        return services.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Person findById(@PathVariable Long id) {
        return services.findById(id);
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Person> created(@RequestBody Person person) {
        Person createdPerson = services.created(person);
        return ResponseEntity.status(201).body(createdPerson);
    }

    @PutMapping(produces = "application/json", consumes = "application/json")
    public Person update(@RequestBody Person person) {
        return services.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        services.delete(id);
        return ResponseEntity.noContent().build();
    }

}
