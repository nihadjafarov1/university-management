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
    @Column(name = "name")
    String name;
    @Column(name = "surname")
    String surname;
    @Column(name = "patronymic")
    String patronymic;
    @Column(name = "fin_code")
    String finCode;
    @Column(name = "image_url")
    String imageUrl;
    @Column(name = "email")
    String email;
    @Column(name = "phone_number")
    String phoneNumber;
    @Column(name = "address")
    String address;
    @Column(name = "city")
    String city;
    @Column(name = "nationality")
    String nationality;
    @Column(name = "birth_date")
    String birthDate;
    @Column(name = "gender")
    String gender;

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
