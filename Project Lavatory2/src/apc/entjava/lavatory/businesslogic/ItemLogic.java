package apc.entjava.lavatory.businesslogic;

import apc.entjava.lavatory.model.Item;
import java.math.BigDecimal;

import java.util.List;

/**
 * Created by Kervi on 12/14/2016.
 */
public interface ItemLogic {
    void addItem(Item item);
    void deleteItem(int itemID);
    Item editItem(int itemID, String category, String itemName, String casePack, BigDecimal buyCost, BigDecimal unitCost, String description);
    List<Item> getHairItem();
    List<Item> getAllItems();
    Item getItemForEdit(int itemID);

}
