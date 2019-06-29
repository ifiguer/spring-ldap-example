package com.example.demo.transformer;

import com.example.demo.dto.PersonDTO;
import com.example.demo.entry.PersonEntry;
import org.springframework.stereotype.Component;

@Component
public class Transformer {

    public PersonDTO transform(PersonEntry personEntry) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setFullName(personEntry.getFullName());
        personDTO.setLastName(personEntry.getLastName());
        return personDTO;
    }
}
