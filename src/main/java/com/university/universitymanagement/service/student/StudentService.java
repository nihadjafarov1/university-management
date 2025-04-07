package com.university.universitymanagement.service.student;

import com.university.universitymanagement.dto.student.request.StudentCreateRequest;
import com.university.universitymanagement.dto.student.response.StudentResponse;

import java.util.List;

public interface StudentService {
    String create(StudentCreateRequest request);

    StudentResponse getById(String id);

    List<StudentResponse> getAll();

    StudentResponse update(Long id, StudentCreateRequest request);

    void delete(Long id);
}