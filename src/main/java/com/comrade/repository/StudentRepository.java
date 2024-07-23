package com.comrade.repository;

import com.comrade.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
   public Student findByAddress( String address);
}
