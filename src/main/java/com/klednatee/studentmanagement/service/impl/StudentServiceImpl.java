package com.klednatee.studentmanagement.service.impl;

import com.klednatee.studentmanagement.dto.StudentDto;
import com.klednatee.studentmanagement.entity.Student;
import com.klednatee.studentmanagement.mapper.StudentMapper;
import com.klednatee.studentmanagement.repository.StudentRepository;
import com.klednatee.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = students.stream()
                .map((student)-> StudentMapper.mapToStudentDto(student)).collect(Collectors.toList());
        return studentDtos;
    }

    public void createStudent(StudentDto studentDto){
        Student student = StudentMapper.mapToStudent(studentDto);
        studentRepository.save(student);
    }
}
