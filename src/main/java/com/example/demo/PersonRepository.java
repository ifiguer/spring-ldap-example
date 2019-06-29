package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

@Service
public class PersonRepository {

    @Autowired
    private LdapTemplate ldapTemplate;

    public Person findPerson(String dn) {
        return ldapTemplate.lookup(dn, new AttributesMapper<Person>() {
            @Override
            public Person mapFromAttributes(Attributes attributes) throws NamingException {
                Person person = new Person();
                person.setFullName((String) attributes.get("cn").get());
                person.setLastName((String) attributes.get("sn").get());
                return person;
            }
        });
    }
}
