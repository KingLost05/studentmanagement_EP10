package com.klednatee.studentmanagement.controller;

import com.klednatee.studentmanagement.dto.StudentDto;
import com.klednatee.studentmanagement.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping("/students")
    public String listStudent(Model model){
        List<StudentDto> students = studentService.getAllStudents();
        model.addAttribute("Students",students);
        return "students";
    }

    @GetMapping("/students/new")
    public String newStudent(Model model){
        StudentDto studentDto = new StudentDto();
        model.addAttribute("students",studentDto);
        return "create-student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") StudentDto student){
        studentService.createStudent(student);
        return "redirect:/students";
    }
}
