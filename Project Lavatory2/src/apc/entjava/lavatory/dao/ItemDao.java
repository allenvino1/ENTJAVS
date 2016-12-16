package apc.entjava.lavatory.dao;

import apc.entjava.lavatory.model.Item;
import apc.entjava.lavatory.businesslogic.ItemLogic;

/**
 * Created by Kervi on 12/14/2016.
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
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
        try{
            String path = "";

            switch(item.getCategory())
            {
                case "hair":
                    path = "resources/photos/shampoo.jpg";
                    break;
                case "face:":
                    path = "resources/photos/bowl.jpg";
                    break;
                case "body":
                    path = "resources/photos/body.jpg";
                    break;
                case "accessories":
                    path = "resources/photos/tissue.jpg";
                    break;
                default:
                    break;
            }

            item.setItemImage(path);

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
    public Item editItem(int itemID, String category, String itemName, String casePack, BigDecimal buyCost, BigDecimal unitCost, String description) {

        EntityManager em = emf.createEntityManager();

        Item item2 = null;

        em.getTransaction().begin();
        try {
            item2 = em.createQuery("select i from Item i where itemID = :itemID", Item.class)
                    .setParameter("itemID", itemID)
                    .getSingleResult();

            item2.setCategory(category);
            item2.setItemName(itemName);
            item2.setCasePack(casePack);
            item2.setBuyCost(buyCost);
            item2.setUnitCost(unitCost);
            item2.setDescription(description);

            em.merge(item2);
            em.getTransaction().commit();
        } catch(Exception e) {
        }
        em.close();

        return item2;
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
    public List<Item> getListItem(String category) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            items = em.createQuery("select i from Item i where i.category = :category", Item.class)
                    .setParameter("category", category)
                    .getResultList();
            em.getTransaction().commit();
        } catch(Exception e) {
            em.getTransaction().rollback();
        }

        em.close();

        return items;
    }
}
