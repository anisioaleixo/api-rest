package br.com.anisioaleixo.api_rest.services;

import br.com.anisioaleixo.api_rest.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {
        logger.info("Finding all people!");
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

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

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("FirstNamee " + i);
        person.setLastName("LastName " + i);
        person.setAddress("Some address in Brasil " + i);
        person.setGender((i % 2 == 0) ? "Male" : "Female");
        return person;
    }

    public Person created(Person person) {
        logger.info("Creating one person!");
        return person;
    }

    public Person update(Person person) {
        logger.info("Updating  one person!");
        return person;
    }

    public void delete(String id) {
        logger.info("Deleting one person!");
    }
}
