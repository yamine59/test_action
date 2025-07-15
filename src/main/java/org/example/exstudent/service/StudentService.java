package org.example.exstudent.service;

import org.example.exstudent.repository.StudentRepository;
import org.example.exstudent.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService implements IStudentService<Student> {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public void saveOrUpdate(Student student) {
        studentRepository.save(student);
    }

    public Student getStudentById(UUID id){
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public List<Student> getStudentByName (String search){
        String name = search.toLowerCase();
        if (name.isEmpty()){
            return studentRepository.findAll();

        } else if (name.length() <= 3 ) {

            return studentRepository.findByLastnameContainingIgnoreCaseOrFirstnameContainingIgnoreCase(search,search);
        }else {
            return studentRepository.findByLastnameIgnoreCaseOrFirstnameIgnoreCase(search,search);
        }
    }

    public void deleteStudent (UUID id){
        studentRepository.deleteById(id);
    }

}
