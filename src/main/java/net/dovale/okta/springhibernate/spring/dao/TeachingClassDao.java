package net.dovale.okta.springhibernate.spring.dao;

import net.dovale.okta.springhibernate.spring.entities.TeachingClass;
import org.springframework.data.repository.CrudRepository;

public interface TeachingClassDao extends CrudRepository<TeachingClass, Long> {
}
