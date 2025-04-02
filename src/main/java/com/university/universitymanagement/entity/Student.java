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
@Table(name = "students")
public class Student extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "person_id")
    Person person;

    @Column(name = "student_number", nullable = false, unique = true)
    String studentNumber;

    @Column(name = "email")
    String email;

    @ManyToOne
    @JoinColumn(name = "group_id")
    Group group;

    @ManyToMany
    List<Course> courses;
}
