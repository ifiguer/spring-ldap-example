package com.example.demo;

import com.example.demo.entry.PersonEntry;
import com.example.demo.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.naming.Name;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class ApplicationTests {

	@Autowired
	private PersonRepository personRepository;

	@Test
	public void testFindPerson() {
		Name id = LdapUtils.newLdapName("uid=john,ou=people,dc=example,dc=com");

		Optional<PersonEntry> person = personRepository.findById(id);

		assertThat(person.isPresent()).isTrue();
		assertThat(person.get()).isNotNull();
		assertThat(person.get().getFullName()).isEqualTo("Bob Bobson");
	}

	@Test
	public void testFindByLastName() {
		String lastName = "Bobson";
		PersonEntry personEntry = personRepository.findByLastName(lastName);
		assertThat(personEntry).isNotNull();
		assertThat(personEntry.getFullName()).isEqualTo("Bob Bobson");
	}

	@Test
	public void testFindByFullName() {
		String lastName = "Bob Bobson";

		PersonEntry personEntry = personRepository.findByFullName(lastName);

		System.out.println(personEntry);

		assertThat(personEntry).isNotNull();
		assertThat(personEntry.getFullName()).isEqualTo(lastName);
	}

}