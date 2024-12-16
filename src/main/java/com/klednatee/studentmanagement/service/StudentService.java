package com.klednatee.studentmanagement.service;

import com.klednatee.studentmanagement.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();

    void createStudent(StudentDto student);
}
