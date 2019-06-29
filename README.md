# Spring LDAP Example

Sample Spring Web MVC application using Spring LDAP and an in-memory LDAP server using UnboundID.

## Packages

### repository

Contains examples on using Spring LDAP Repositories as described in the [docs](https://docs.spring.io/spring-ldap/docs/2.3.1.RELEASE/reference/#repositories).

This way we don't have to write queries. Just define an interface that extends `LdapRepository<PersonEntry>` where `PersonEntry` is an Entry class (see entry package). This gives us some methods we can use without doing anything else.

We can get even more functionality by just adding method signatures. There is no need to implement the query in this case.

```java
public interface PersonRepository extends LdapRepository<PersonEntry>, CustomPersonRepository {
    PersonEntry findByFullName(String fullName);
}
```

Note that this only works if `fullName` is a field in PersonEntry with the annotation `@Attribute`.

We can do complex queries such as:

```java
PersonEntry findByLastNameAndWhenChanged(String lastName, String whenChanged);
```

However, greater than queries are not supported. A the signature below results in the following error message:

```
java.lang.IllegalArgumentException: GREATER_THAN (1): [IsGreaterThan, GreaterThan] queries are not supported for LDAP repositories
```

```java
PersonEntry findByWhenChangedGreaterThan(String whenChanged);
```

But we can provide our own implementation in 3 steps:

1. Create another interface with the method signature. I will call it CustomPersonRepository.

```java
public interface CustomPersonRepository {
    PersonEntry findByWhenChangedGreaterThan(String whenChanged);
}
```

2. Extend this interface in `PersonRepository`.

```java
public interface PersonRepository extends LdapRepository<PersonEntry>, CustomPersonRepository {
    ...
}
```

3. Create an implementation named CustomRepositoryImpl. It is important that the name ends in Impl.

```java
public class CustomPersonRepositoryImpl implements CustomPersonRepository {

    @Autowired
    LdapTemplate ldapTemplate;

    @Override
    public PersonEntry findByWhenChangedGreaterThan(String whenChanged) {
        return ldapTemplate.findOne(query().where("whenChanged").gte(whenChanged), PersonEntry.class);
    }
}
```