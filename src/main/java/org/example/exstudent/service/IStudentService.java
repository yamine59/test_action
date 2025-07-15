package org.example.exstudent.service;

import java.util.List;
import java.util.UUID;

public interface IStudentService <T>{

    void saveOrUpdate(T t);
    T getStudentById(UUID id);
    List<T> getAllStudent();
    void deleteStudent(UUID id);

}
