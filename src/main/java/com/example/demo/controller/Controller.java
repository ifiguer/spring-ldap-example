package com.example.demo.controller;

import com.example.demo.delegate.Delegate;
import com.example.demo.dto.PersonDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private Delegate delegate;

    public Controller(Delegate delegate) {
        this.delegate = delegate;
    }

    @GetMapping("/{lastName}")
    public PersonDTO person(@PathVariable String lastName) {
        return delegate.retrievePerson(lastName);
    }
}
