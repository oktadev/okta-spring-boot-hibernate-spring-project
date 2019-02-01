package net.dovale.dao;

import org.hibernate.SessionFactory;
import net.dovale.entities.Teacher;

public class TeacherDao extends AbstractCrudDao<Teacher> {

    public TeacherDao(SessionFactory sessionFactory) {
        super(sessionFactory, Teacher.class, "Teacher");
    }
}
