package com.ing.localisation.geolocalisation.model;

import java.time.DateTimeException;
import java.time.LocalDate;

public class User {
    private Long id;
    private String name;
    private LocalDate birthDay;


    public User(Long id, String name, LocalDate birthDay) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
    }

    public User() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }
}
