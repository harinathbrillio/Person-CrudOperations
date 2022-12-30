package com.person.service;

import com.person.model.Person;
import com.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public Person savePerson(Person person) {
        return repository.save(person);
    }

    public List<Person> getPersons() {
        return repository.getAllPersons();
    }

    public Person getPersonById(int id) {
        return repository.findById(id);
    }

    public String deletePerson(int id) {
        repository.delete(id);
        return "product removed !! " + id;
    }

    public Person updatePerson(Person person) {
        return repository.update(person);
    }
}
