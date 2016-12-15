package apc.entjava.lavatory.dao;

import apc.entjava.lavatory.model.Item;
import apc.entjava.lavatory.businesslogic.ItemLogic;

/**
 * Created by Kervi on 12/14/2016.
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemDao implements ItemLogic{

    private EntityManagerFactory emf;
    private List<Item> items = new ArrayList<>();

    public ItemDao() {
        emf = Persistence.createEntityManagerFactory("LavatoryDB");
    }

    @Override
    public void addItem(Item item) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(item);
            em.getTransaction().commit();
        } catch(Exception e) {
            em.getTransaction().rollback();
        }
        em.close();

    }

    @Override
    public List<Item> getItemHair() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            items = em.createQuery("select i from Item i where i.category = 'Hair'", Item.class)
                    .getResultList();
            em.getTransaction().commit();
        } catch(Exception e) {
            em.getTransaction().rollback();
        }

        em.close();

        return items;
    }
}
