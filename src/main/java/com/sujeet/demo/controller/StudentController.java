package com.sujeet.demo.controller;

import com.sujeet.demo.model.Student;
import com.sujeet.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getAllStudents(){
        return studentService.selectAllStudents();
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertNewStudent(@RequestBody Student student){
        studentService.persistNewStudent(UUID.randomUUID(),student);
    }

    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE,path = "{studentId}")
    public Student getStudentById(@PathVariable UUID studentId){
        return studentService.selectStudentById(studentId);
    }

    @RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE,path = "{studentId}")
    public int updateStudentById(@PathVariable UUID studentId,@RequestBody Student newStudent){
        return studentService.updateStudentById(studentId,newStudent);
    }

    @RequestMapping(method = RequestMethod.DELETE,consumes = MediaType.APPLICATION_JSON_VALUE,path = "{studentId}")
    public int deleteStudentById(@PathVariable UUID studentId){
        return studentService.deleteStudentById(studentId);
    }
}
