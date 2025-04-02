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
@Table(name = "groups")
public class Group extends BaseEntity {
    @Column(name = "name")
    String name;

    @Column(name = "representative_student_id")
    String representativeStudentId;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    Faculty faculty;

    @ManyToMany
    List<Lesson> lessons;

    @ManyToMany
    List<Course> courses;

    @OneToMany(mappedBy = "group")
    List<Student> students;
}
