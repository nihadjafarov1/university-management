package com.university.universitymanagement.dto.student.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentCreateRequest {
    String personId;
    Long studentNo;
    String groupId;
}
