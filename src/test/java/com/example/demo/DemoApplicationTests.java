package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class DemoApplicationTests {

	@Autowired
	private PersonRepository personRepository;

	@Test
	public void testFindPerson() {
		Person person = personRepository.findPerson("uid=john,ou=people,dc=memorynotfound,dc=com");
		assertThat(person).isNotNull();
		assertThat(person.getFullName()).isEqualTo("John Doe");
	}

}
