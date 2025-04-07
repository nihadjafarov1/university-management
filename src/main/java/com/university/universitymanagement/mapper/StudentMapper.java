package com.university.universitymanagement.mapper;

import com.university.universitymanagement.dto.student.request.StudentCreateRequest;
import com.university.universitymanagement.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {
    Student createDtoToEntity(StudentCreateRequest studentCreateRequest);
}
