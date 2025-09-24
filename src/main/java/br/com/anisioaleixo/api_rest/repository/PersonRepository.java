package br.com.anisioaleixo.api_rest.repository;

import br.com.anisioaleixo.api_rest.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByFirstName(String firstName);
}
