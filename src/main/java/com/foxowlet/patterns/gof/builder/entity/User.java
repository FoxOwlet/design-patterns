package com.foxowlet.patterns.gof.builder.entity;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public class User {
    private final String firstName;
    private final String lastName;
    private final String userName;
    private final String email;
    private final String address;
    private final LocalDate birthDate;

    User(String firstName, String lastName, String userName, String email, String address, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.address = address;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
