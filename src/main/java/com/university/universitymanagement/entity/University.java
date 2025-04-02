package com.university.universitymanagement.entity;

import jakarta.persistence.Entity;
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
@Table(name = "universities")
public class University extends BaseEntity {
    String name;
    String description;

    @OneToMany(mappedBy = "university")
    List<Faculty> faculties;
}