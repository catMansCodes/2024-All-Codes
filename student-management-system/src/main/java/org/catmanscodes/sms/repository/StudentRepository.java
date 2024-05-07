package org.catmanscodes.sms.repository;

import org.catmanscodes.sms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
