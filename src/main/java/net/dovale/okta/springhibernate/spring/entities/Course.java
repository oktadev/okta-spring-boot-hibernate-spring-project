package net.dovale.okta.springhibernate.spring.entities;


import javax.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int workload;
    private int rate;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_course_teacher"))
    private Teacher teacher;

    public Course() {
    }

    public Course(String name, int workload, int rate, Teacher teacher) {
        this.name = name;
        this.workload = workload;
        this.rate = rate;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

}
