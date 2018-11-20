package net.dovale.okta.springhibernate.spring.dao;

import net.dovale.okta.springhibernate.spring.entities.TeachingClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeachingClassDao extends JpaRepository<TeachingClass, Long> {
}
