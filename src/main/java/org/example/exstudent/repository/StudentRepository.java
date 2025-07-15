package org.example.exstudent.repository;

import org.example.exstudent.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    List<Student> findByLastnameIgnoreCaseOrFirstnameIgnoreCase(String lastname, String firstname);

    List<Student> findByLastnameContainingIgnoreCaseOrFirstnameContainingIgnoreCase(String lastname, String firstname);

    void removeById(UUID id);
}
