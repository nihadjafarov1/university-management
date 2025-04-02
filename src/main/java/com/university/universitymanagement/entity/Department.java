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
@Table(name = "departments")
public class Department extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "faculty_id")
    Faculty faculty;

    @OneToMany
    List<Teacher> teachers;
}
