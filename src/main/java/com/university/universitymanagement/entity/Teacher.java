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
@Table(name = "teachers")
public class Teacher extends Employee {
//    private TeacherDegree teacherDegree;

    @ManyToMany
    List<Course> courses;

    @ManyToOne
    @JoinColumn(name = "department_id")
    Department department;
}
