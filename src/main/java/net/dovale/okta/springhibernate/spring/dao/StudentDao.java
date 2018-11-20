package net.dovale.okta.springhibernate.spring.dao;

import net.dovale.okta.springhibernate.spring.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentDao extends JpaRepository<Student, Long> {

    List<Student> findByNameContaining(String name);

    List<Student> findByAgeBetween(short smallerAge, short biggerAge);

}
