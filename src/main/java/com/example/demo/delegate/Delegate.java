package com.example.demo.delegate;

import com.example.demo.dto.PersonDTO;
import com.example.demo.entry.PersonEntry;
import com.example.demo.repository.PersonRepository;
import com.example.demo.transformer.Transformer;
import org.springframework.stereotype.Component;

@Component
public class Delegate {

    private PersonRepository personRepository;
    private Transformer transformer;

    public Delegate(PersonRepository personRepository, Transformer transformer) {
        this.personRepository = personRepository;
        this.transformer = transformer;
    }

    public PersonDTO retrievePerson(String lastName) {
        PersonEntry personEntry = personRepository.findByLastName(lastName);
        return transformer.transform(personEntry);
    }
}
