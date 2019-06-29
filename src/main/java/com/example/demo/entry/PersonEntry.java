package com.example.demo.entry;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;

@Entry(objectClasses = { "top", "person" })
public class PersonEntry {

    @Id
    Name name;

    @Attribute(name = "cn")
    private String fullName;

    @Attribute(name = "sn")
    private String lastName;

    @Attribute(name = "whenChanged")
    private String whenChanged;

    public String getWhenChanged() {
        return whenChanged;
    }

    public void setWhenChanged(String whenChanged) {
        this.whenChanged = whenChanged;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "PersonEntry{" +
                "name=" + name +
                ", fullName='" + fullName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", whenChanged='" + whenChanged + '\'' +
                '}';
    }
}
