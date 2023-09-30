package com.foxowlet.patterns.gof.builder.entity;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String login = "iamdobby";
        String mail = "dobby@test.com";
        String country = "Italy";
        LocalDate date = LocalDate.of(2021, 9, 20);
        User dobby = new UserBuilder()
                .firstName("Dobby")
                .lastName("Swin")
                .email(mail)
                .userName(login)
                .address(country)
                .birthDate(date)
                .build();
        System.out.println(dobby);
    }
}
