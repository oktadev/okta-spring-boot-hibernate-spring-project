package net.dovale.okta.springhibernate.spring.services;

import net.dovale.okta.springhibernate.spring.dao.*;
import net.dovale.okta.springhibernate.spring.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
public class DataFillerService {
    private CourseDao courseDao;
    private TeacherDao teacherDao;
    private TeachingClassDao teachingClassDao;
    private StudentDao studentDao;

    @Autowired
    public DataFillerService(CourseDao courseDao, TeacherDao teacherDao, TeachingClassDao teachingClassDao, StudentDao studentDao) {
        this.courseDao = courseDao;
        this.teacherDao = teacherDao;
        this.teachingClassDao = teachingClassDao;
        this.studentDao = studentDao;
    }

    @PostConstruct
    @Transactional
    public void fillData(){
        Teacher pj = teacherDao.save(new Teacher("Profesor Jirafales","https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/Ruben2017.jpg/245px-Ruben2017.jpg","jirafales@example.com"));
        Teacher px = teacherDao.save(new Teacher("Professor X","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9uI1Cb-nQ2uJOph4_t96KRvLSMjczAKnHLJYi1nqWXagvqWc4","director@xproject_.com"));
        Course mathematics = courseDao.save(new Course("Mathematics", 20,  10, pj));
        Course spanish = courseDao.save(new Course("Spanish", 20,  10, pj));
        Course dealingWithUnknown = courseDao.save(new Course("Dealing with unknown", 10,  100, px));
        Course handlingYourMentalPower = courseDao.save(new Course("Handling your mental power", 50,  100, px));
        Course introductionToPsychology = courseDao.save(new Course("Introduction to psychology", 90,  100, px));
        Student studendChaves = studentDao.save(new Student("Chaves",  34));
        Student studendQuico = studentDao.save(new Student("Quico",  35));
        Student studendCyclops = studentDao.save(new Student("Cyclops",  25));
        Student studentIceman = studentDao.save(new Student("Iceman",  30));
        Student studendArchangel = studentDao.save(new Student("Archangel",  29));
        teachingClassDao.save(new TeachingClass(mathematics, pj, Arrays.asList(studendChaves, studendQuico), 1988));
        teachingClassDao.save(new TeachingClass(spanish, pj, Arrays.asList(studendChaves, studendQuico), 1988));
        teachingClassDao.save(new TeachingClass(dealingWithUnknown, px, Arrays.asList(studendCyclops, studentIceman), 1995));
        teachingClassDao.save(new TeachingClass(dealingWithUnknown, px, Arrays.asList(studendArchangel), 1996));
    }
}
