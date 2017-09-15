package org.home.model.handler;

import org.home.listener.EMFListener;

import javax.persistence.EntityManager;

public class RecordHandler {

    public boolean removeRecord(int id) {
        EntityManager em = null;
        int result = 0;
        try {
            em = EMFListener.getEntityManager();
            em.getTransaction().begin();
            String query = "delete Record record where record.id = :id";
            result = em.createQuery(query)
                    .setParameter("id", id)
                    .executeUpdate();
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            EMFListener.closeEntityManager(em);
        }
        return result > 0;
    }
}
