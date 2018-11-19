package net.dovale.okta.springhibernate.spring.services;

import net.dovale.okta.springhibernate.spring.dao.*;
import net.dovale.okta.springhibernate.spring.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
public class DataFillerService {

    @Autowired private CourseDAO courseDAO;
    @Autowired private TeacherDAO teacherDAO;

    @PostConstruct
    @Transactional
    public void fillData(){
        Teacher pj = new Teacher("Profesor Jirafales","https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/Ruben2017.jpg/245px-Ruben2017.jpg","jirafales@example.com");
        Teacher px = new Teacher("Professor X","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9uI1Cb-nQ2uJOph4_t96KRvLSMjczAKnHLJYi1nqWXagvqWc4","director@xproject_.com");
        teacherDAO.save(pj);
        teacherDAO.save(px);
        courseDAO.save(new Course("Mathematics", 20, (short) 10, pj));
        courseDAO.save(new Course("Spanish", 20, (short) 10, pj));
        courseDAO.save(new Course("Dealing with unknown", 10, (short) 100, pj));
        courseDAO.save(new Course("Handling your mental power", 50, (short) 100, pj));
        courseDAO.save(new Course("Introduction to psychology", 90, (short) 100, pj));
    }
}
