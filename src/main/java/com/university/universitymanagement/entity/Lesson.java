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
@Table(name = "lessons")
public class Lesson extends BaseEntity {
    String type;

    @Column(name = "lesson_id")
    String lessonId;

    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;

    @ManyToMany
    List<Group> groups;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    Teacher teacher;

    @OneToMany
    List<Attendance> attendances;
}
