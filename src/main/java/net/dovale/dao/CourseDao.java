package net.dovale.dao;

import net.dovale.entities.Course;
import org.hibernate.SessionFactory;

public class CourseDao extends AbstractCrudDao<Course> {
    public CourseDao(SessionFactory sessionFactory) {
        super(sessionFactory, Course.class, "Course");
    }
}
