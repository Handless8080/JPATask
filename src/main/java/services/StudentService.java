package services;

import entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class StudentService {
    private EntityManager entityManager = Persistence.createEntityManagerFactory("students").createEntityManager();

    public Student get(Integer id) {
        return entityManager.find(Student.class, id);
    }
}