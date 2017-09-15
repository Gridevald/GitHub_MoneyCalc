package org.home.model.handler;

import org.home.listener.EMFListener;
import org.home.model.entity.Record;
import org.home.model.entity.User;

import javax.persistence.EntityManager;
import java.util.Calendar;
import java.util.List;

public class UserHandler {

    @SuppressWarnings("unchecked")
    public User findUser(String email) {
        EntityManager em = null;
        List<User> user = null;
        try {
            em = EMFListener.getEntityManager();
            em.getTransaction().begin();
            String query = "from User user where user.email = :email";
            user = em.createQuery(query)
                    .setParameter("email", email)
                    .getResultList();
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            EMFListener.closeEntityManager(em);
        }
        if (user != null && user.size() > 0) {
            return user.get(0);
        } else {
            return null;
        }
    }

    public void addNewUser(String email, String password) {
        EntityManager em = null;
        User user = new User(email, password);
        try {
            em = EMFListener.getEntityManager();
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            EMFListener.closeEntityManager(em);
        }
    }

    @SuppressWarnings("unchecked")
    public boolean validateUser(String email, String password) {
        EntityManager em = null;
        List<User> user = null;
        try {
            em = EMFListener.getEntityManager();
            em.getTransaction().begin();
            String query = "from User user where user.email = :email and user.password = :password";
            user = em.createQuery(query)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getResultList();
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            EMFListener.closeEntityManager(em);
        }
        return (user != null && user.size() > 0);
    }

    @SuppressWarnings("unchecked")
    public void addRecord(String email, String description, double value, Calendar date) {
        EntityManager em = null;
        try {
            em = EMFListener.getEntityManager();
            em.getTransaction().begin();
            String query = "from User user where user.email = :email";
            List<User> userList = em.createQuery(query)
                    .setParameter("email", email)
                    .getResultList();
            User user = userList.get(0);
            Record record = new Record(description, value, date, user);
            user.getRecords().add(record);
            em.persist(user);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            EMFListener.closeEntityManager(em);
        }
    }
}
