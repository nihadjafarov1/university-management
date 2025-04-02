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
@Table(name = "faculties")
public class Faculty extends BaseEntity {
    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @ManyToOne
    @JoinColumn(name = "university_id")
    University university;

    @OneToMany
    List<Department> departments;

    @OneToMany(mappedBy = "faculty")
    List<Major> majors;

    @OneToMany(mappedBy = "faculty")
    List<Tutor> tutors;
}
