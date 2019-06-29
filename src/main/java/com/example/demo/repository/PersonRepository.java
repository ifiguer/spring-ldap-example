package com.example.demo.repository;

import com.example.demo.entry.PersonEntry;
import org.springframework.data.ldap.repository.LdapRepository;

public interface PersonRepository extends LdapRepository<PersonEntry> {
    PersonEntry findByFullName(String fullName);
    PersonEntry findByLastName(String lastName);
}
