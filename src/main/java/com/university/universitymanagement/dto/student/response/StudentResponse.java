package com.university.universitymanagement.dto.student.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentResponse {
    String id;
    String fullName;
    String user;
    String email;
    String phoneNumber;
    LocalDate dateOfBirth;
    Long universityId;
}