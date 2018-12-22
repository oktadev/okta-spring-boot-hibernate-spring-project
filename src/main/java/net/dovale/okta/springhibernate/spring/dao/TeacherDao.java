package net.dovale.okta.springhibernate.spring.dao;

import net.dovale.okta.springhibernate.spring.entities.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherDao extends CrudRepository<Teacher, Long> {}
