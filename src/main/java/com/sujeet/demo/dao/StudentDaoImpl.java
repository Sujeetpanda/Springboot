package com.sujeet.demo.dao;

import com.sujeet.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("studDao")
public class StudentDaoImpl implements StudentDao{

    private final Map<UUID,Student> database;

    public StudentDaoImpl(Map<UUID, Student> database) {
        this.database = new HashMap<>();
    }

    @Override
    public int insertNewStudent(UUID studentId, Student student) {
        database.put(studentId,student);
        return 1;
    }

    @Override
    public Student selectStudentById(UUID studnetId) {
        return database.get(studnetId);
    }

    @Override
    public List<Student> selectAllStudents() {
        return new ArrayList<>(database.values());
    }

    @Override
    public int updateStudentById(UUID studentID, Student studentUpdate) {
        database.put(studentID,studentUpdate);
        return 1;
    }

    @Override
    public int deleteStudentById(UUID studentId) {
        database.remove(studentId);
        return 0;
    }
}
