package com.university.universitymanagement.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "persons")
public class Person extends BaseEntity {
    String name;
    String surname;
    String finCode;
    String email;
    String phone;
    String address;
    String city;
    String country;
    String postalCode;
    String birthDate;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;

    @OneToMany
    List<Student> student;

    @OneToMany
    List<Teacher> teacher;

    @OneToMany
    List<Technician> technician;

    @OneToMany
    List<Tutor> tutor;
}
