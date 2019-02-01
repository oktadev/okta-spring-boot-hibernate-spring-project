package net.dovale;

import net.dovale.dao.*;
import net.dovale.entities.*;
import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Application {

    public static void main(String[] args){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory()) {
            CourseDao courseDAO = new CourseDao(sessionFactory);
            TeacherDao teacherDAO = new TeacherDao(sessionFactory);
            try (Session session = sessionFactory.getCurrentSession()) {
                Transaction tx = session.beginTransaction();
                // create teachers
                Teacher pj = teacherDAO.save(new Teacher("Profesor Jirafales","https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/Ruben2017.jpg/245px-Ruben2017.jpg","jirafales@example.com"));
                Teacher px = teacherDAO.save(new Teacher("Professor X","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9uI1Cb-nQ2uJOph4_t96KRvLSMjczAKnHLJYi1nqWXagvqWc4","director@xproject_.com"));
                courseDAO.save(new Course("Mathematics", 20, 10, pj));
                courseDAO.save(new Course("Spanish", 20, 10, pj));
                courseDAO.save(new Course("Dealing with unknown", 10, 100, px));
                courseDAO.save(new Course("Handling your mental power", 50, 100, px));
                courseDAO.save(new Course("Introduction to psychology", 90, 100, px));
                tx.commit();
            }
            try (Session session = sessionFactory.getCurrentSession()) {
                session.beginTransaction();
                System.out.println("Courses");
                courseDAO.list().forEach(course -> System.out.println(course.getName()));
                System.out.println("Teachers");
                teacherDAO.list().forEach(teacher -> System.out.println(teacher.getName()));
            }
        }
    }
}
