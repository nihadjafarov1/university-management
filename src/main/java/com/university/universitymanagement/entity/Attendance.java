package com.university.universitymanagement.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "attendances")
public class    Attendance extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "lesson_id")
    Lesson lesson;

    @OneToOne
    @JoinColumn(name = "student_id")
    Student student;

    @Column(name = "attendance_status")
    String attendanceStatus;
}