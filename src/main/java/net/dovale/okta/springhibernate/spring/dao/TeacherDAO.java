package net.dovale.okta.springhibernate.spring.dao;

import net.dovale.okta.springhibernate.spring.entities.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherDAO extends CrudRepository<Teacher, Long> {
}
