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

public class ItemDao implements ItemLogic{

    private EntityManagerFactory emf;
    private List<Item> items = new ArrayList<>();

    public ItemDao() {
        emf = Persistence.createEntityManagerFactory("LavatoryDb");
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
    public void deleteItem(int itemID) {
        EntityManager em = emf.createEntityManager();
        Item item;

        em.getTransaction().begin();
        try {
            item = em.find(Item.class, itemID);
            em.remove(item);
            em.getTransaction().commit();
        } catch(Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
    }

    @Override
    public void editItem(Item item, int itemID) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        try {
            item = em.find(Item.class, itemID);
            item.setCategory(item.getCategory());
            item.setItemName(item.getItemName());
            item.setCasePack(item.getCasePack());
            item.setBuyCost(item.getBuyCost());
            item.setUnitCost(item.getUnitCost());
            item.setUnitCost(item.getUnitCost());
            em.getTransaction().commit();
        } catch(Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
    }


    @Override
    public List<Item> getAllItems() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            items = em.createQuery("select i from Item i")
                    .getResultList();
            em.getTransaction().commit();
        } catch(Exception e) {
            em.getTransaction().rollback();
        }

        em.close();

        return items;
    }

    @Override
    public Item getItemForEdit(int itemID) {
        EntityManager em = emf.createEntityManager();
        Item item = null;
        em.getTransaction().begin();
        try {
            item = em.createQuery("select i from Item i where i.itemID = :itemID", Item.class)
                    .setParameter("itemID", itemID)
                    .getSingleResult();
            em.getTransaction().commit();
        } catch(Exception e) {
            em.getTransaction().rollback();
        }

        em.close();

        return item;
    }

    @Override
    public List<Item> getHairItem() {
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
