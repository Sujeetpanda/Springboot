package com.sujeet.demo.dao;

import com.sujeet.demo.model.Student;

import java.util.List;
import java.util.UUID;

public interface StudentDao {
    int insertNewStudent(UUID studentId, Student student);
    Student selectStudentById(UUID id);
    List<Student> selectAllStudents();
    int updateStudentById(UUID studentID,Student studentUpdate);
    int deleteStudentById(UUID studentId);
}
