package br.com.anisioaleixo.api_rest.services;

import br.com.anisioaleixo.api_rest.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id) {
        logger.info("Finding one person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Anisio");
        person.setLastName("Aleixo");
        person.setAddress("Belém - PA - Brasil");
        person.setGender("Male");
        return person;
    }
}
