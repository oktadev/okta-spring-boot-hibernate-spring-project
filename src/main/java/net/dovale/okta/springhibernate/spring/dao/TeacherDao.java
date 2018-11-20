package net.dovale.okta.springhibernate.spring.dao;

import net.dovale.okta.springhibernate.spring.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherDao extends JpaRepository<Teacher, Long> {

    List<Teacher> findByNameContaining(String name);
}
