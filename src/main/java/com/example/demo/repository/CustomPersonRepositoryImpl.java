package com.example.demo.repository;

import com.example.demo.entry.PersonEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

public class CustomPersonRepositoryImpl implements CustomPersonRepository {

    @Autowired
    LdapTemplate ldapTemplate;

    @Override
    public PersonEntry findByWhenChangedGreaterThan(String whenChanged) {
        return ldapTemplate.findOne(query().where("whenChanged").gte(whenChanged), PersonEntry.class);
    }
}
