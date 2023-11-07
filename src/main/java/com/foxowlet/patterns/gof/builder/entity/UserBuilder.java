package com.foxowlet.patterns.gof.builder.entity;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;

public class UserBuilder {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String address = Locale.getDefault().getDisplayCountry();
    private LocalDate birthDate;

    public UserBuilder() {
    }

    public UserBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder userName(String userName) {
        this.userName = userName;
        return this;
    }

    public UserBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder address(String address) {
        this.address = address;
        return this;
    }

    public UserBuilder birthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public User build() {
        return new User(Objects.requireNonNull(firstName),
                Objects.requireNonNull(lastName),
                Objects.requireNonNull(userName),
                Objects.requireNonNull(email),
                Objects.requireNonNull(address),
                Objects.requireNonNull(birthDate));
    }
}
