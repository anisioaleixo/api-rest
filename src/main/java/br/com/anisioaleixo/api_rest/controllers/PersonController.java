package br.com.anisioaleixo.api_rest.controllers;

import br.com.anisioaleixo.api_rest.model.Person;
import br.com.anisioaleixo.api_rest.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonServices services;

    @GetMapping(value = "/{id}", produces = "application/json")
    public Person findById(@PathVariable String id) {
        return services.findById(id);
    }
}
