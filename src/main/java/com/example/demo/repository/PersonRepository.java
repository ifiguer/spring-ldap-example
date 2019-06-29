package com.example.demo.repository;

import com.example.demo.entry.PersonEntry;
import org.springframework.data.ldap.repository.LdapRepository;

public interface PersonRepository extends LdapRepository<PersonEntry>, CustomPersonRepository {
    PersonEntry findByFullName(String fullName);
    PersonEntry findByLastName(String lastName);
    PersonEntry findByLastNameAndWhenChanged(String lastName, String whenChanged);
    PersonEntry findByLastNameLike(String lastName);
    PersonEntry findByWhenChangedGreaterThan(String whenChanged);
}
