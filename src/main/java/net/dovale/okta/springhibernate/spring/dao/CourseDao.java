package net.dovale.okta.springhibernate.spring.dao;

import net.dovale.okta.springhibernate.spring.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Long> {}
