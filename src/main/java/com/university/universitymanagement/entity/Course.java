package com.university.universitymanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "courses")
public class Course extends BaseEntity {
    String name;
    String description;

    @OneToMany(mappedBy = "course")
    List<Lesson> lessons;

    @ManyToMany
    List<Group> groups;

    @ManyToMany
    List<Major> majors;

    @ManyToMany
    List<Teacher> teachers;
}
