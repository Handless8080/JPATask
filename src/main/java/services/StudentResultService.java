package services;

import entities.StudentResult;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class StudentResultService {
    private EntityManager entityManager = Persistence.createEntityManagerFactory("students").createEntityManager();

    public void addOrUpdate(StudentResult result) {
        entityManager.getTransaction().begin();
        entityManager.merge(result);
        entityManager.getTransaction().commit();
    }
}