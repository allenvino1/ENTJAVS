package apc.entjava.lavatory.businesslogic;

import apc.entjava.lavatory.model.Item;

import java.util.List;

/**
 * Created by Kervi on 12/14/2016.
 */
public interface ItemLogic {
    void addItem(Item item);
    void deleteItem(int itemID);
    List<Item> getHairItem();
    List<Item> getAllItems();

}
