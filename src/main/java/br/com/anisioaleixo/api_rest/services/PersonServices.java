package br.com.anisioaleixo.api_rest.services;

import br.com.anisioaleixo.api_rest.data.DTO.V1.PersonDTO;
import br.com.anisioaleixo.api_rest.excepition.ResourceNotFoundException;
import static br.com.anisioaleixo.api_rest.mapper.ObjectMapper.parseObject;
import static br.com.anisioaleixo.api_rest.mapper.ObjectMapper.parseListObjects;

import br.com.anisioaleixo.api_rest.mapper.PersonMapper;
import br.com.anisioaleixo.api_rest.model.Person;
import br.com.anisioaleixo.api_rest.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    public PersonRepository repository;

    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    public List<PersonDTO> findAll() {
        logger.info("Finding all people!");
        return parseListObjects(repository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id) {
        logger.info("Finding one person!");
        var entity =  repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("no records found for this ID"));
        return parseObject(entity, PersonDTO.class);
    }

    public PersonDTO created(PersonDTO person) {
        logger.info("Creating one person!");
        var entity = parseObject(person, Person.class);
        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public PersonDTO update(PersonDTO person) {
        logger.info("Updating one person!");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("no records found for this ID"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");
        Person person = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("no records found for this ID"));
        repository.delete(person);
    }

}
