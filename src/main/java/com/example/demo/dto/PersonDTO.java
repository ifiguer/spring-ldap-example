package com.example.demo.dto;

public class PersonDTO {

    private String fullName;
    private String lastName;

    public PersonDTO() {
    }

    public PersonDTO(String fullName, String lastName) {
        this.fullName = fullName;
        this.lastName = lastName;
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
        return "PersonDTO{" +
                "fullName='" + fullName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
