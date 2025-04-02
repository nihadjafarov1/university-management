package com.university.universitymanagement.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee extends BaseEntity {
    @Column(name = "hire_date")
    Instant hireDate;

    @Column(name = "fire_date")
    Instant fireDate;

    @ManyToOne
    @JoinColumn(name = "person_id")
    Person person;
}