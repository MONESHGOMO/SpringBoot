package com.GomoCodes.Gomo.repository;

import com.GomoCodes.Gomo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
