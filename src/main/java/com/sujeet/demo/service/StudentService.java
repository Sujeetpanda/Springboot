package com.sujeet.demo.service;

import com.sujeet.demo.dao.StudentDao;
import com.sujeet.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("studDao") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int persistNewStudent(UUID studentId, Student student){
        UUID studentUUID = studentId == null ? UUID.randomUUID() : studentId;
        student.setId(studentUUID);
        return studentDao.insertNewStudent(studentUUID,student);
    }
    public Student selectStudentById(UUID id) {
        return studentDao.selectStudentById(id);
    }
    public List<Student> selectAllStudents() {
        return studentDao.selectAllStudents();
    }
    public int updateStudentById(UUID studentID,Student studentUpdate) {
        return studentDao.updateStudentById(studentID,studentUpdate);
    }
    public int deleteStudentById(UUID studentId) {
        Student studentById = studentDao.selectStudentById(studentId);
        if(studentById == null) {
            throw new IllegalStateException("Student not found");
        }
        return studentDao.deleteStudentById(studentId);
    }
}
