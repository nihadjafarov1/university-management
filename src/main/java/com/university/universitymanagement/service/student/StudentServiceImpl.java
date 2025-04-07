package com.university.universitymanagement.service.student;

import com.university.universitymanagement.dto.student.request.StudentCreateRequest;
import com.university.universitymanagement.dto.student.response.StudentResponse;
import com.university.universitymanagement.entity.Student;
import com.university.universitymanagement.mapper.StudentMapper;
import com.university.universitymanagement.repository.auth.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@Service
public class StudentServiceImpl implements StudentService {
    StudentMapper studentMapper;
    StudentRepository studentRepository;

    @Override
    public String create(StudentCreateRequest request) {
        Student student = studentMapper.createDtoToEntity(request);
        Student savedStudent = studentRepository.save(student);
        return savedStudent.getId();
    }

    @Override
    public StudentResponse getById(String id) {
        return null;
    }

    @Override
    public List<StudentResponse> getAll() {
        return List.of();
    }

    @Override
    public StudentResponse update(Long id, StudentCreateRequest request) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
