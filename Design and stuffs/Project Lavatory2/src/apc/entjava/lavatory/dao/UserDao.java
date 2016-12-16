package apc.entjava.lavatory.dao;

import apc.entjava.lavatory.businesslogic.UserService;
import apc.entjava.lavatory.model.User;

/**
 * Created by Kervi on 12/14/2016.
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserDao implements UserService {

    private EntityManagerFactory emf;
    public UserDao() {
        emf = Persistence.createEntityManagerFactory("LavatoryDb");
    }

    @Override
    public void register(User newUser) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(newUser);
            em.getTransaction().commit();
        } catch(Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
    }

    @Override
    public User login(String username, String password) {
        EntityManager em = emf.createEntityManager();
        User user = null;
        em.getTransaction().begin();
        try {
            user = em.createQuery("select u from User u where u.username = :username and u.password = :password", User.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
            em.getTransaction().commit();
        } catch(Exception e) {
            em.getTransaction().rollback();
        }

        em.close();
        return user;
    }
}