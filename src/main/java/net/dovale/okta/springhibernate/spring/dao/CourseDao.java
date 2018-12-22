package net.dovale.okta.springhibernate.spring.dao;

import net.dovale.okta.springhibernate.spring.entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseDao extends CrudRepository<Course, Long> {}
