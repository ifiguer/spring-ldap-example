package com.example.demo.repository;

import com.example.demo.entry.PersonEntry;

public interface CustomPersonRepository {
    PersonEntry findByWhenChangedGreaterThan(String whenChanged);
}
