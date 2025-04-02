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
@Table(name = "majors")
public class Major extends BaseEntity {
    String name;
    String description;

    @ManyToMany
    List<Course> courses;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    Faculty faculty;
}
