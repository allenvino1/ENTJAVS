package apc.entjava.lavatory;

/**
 * Created by Kervi on 12/14/2016.
 */

import apc.entjava.lavatory.businesslogic.ItemLogic;
import apc.entjava.lavatory.dao.ItemDao;
import apc.entjava.lavatory.model.Item;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class ItemBean {

    private ItemLogic itemLogic = new ItemDao();
    private List<Item> items = new ArrayList<>();
    private Item item;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Item getItem() {
        if(this.item==null) {
            this.item = new Item();
        }
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getHairItem()
    {
        items = this.itemLogic.getHairItem();

        return "hair";
    }

    public String addItem()
    {
        this.itemLogic.addItem(item);

        return "success";
    }

    public String getAllItemsForDelete()
    {
        items = this.itemLogic.getAllItems();

        return "deleteItem";
    }

    public String deleteItem()
    {
        this.itemLogic.deleteItem(item.getItemID());

        items = this.itemLogic.getAllItems();

        return "deleteItem";
    }

    public String getAllItemsForEdit()
    {
        items = this.itemLogic.getAllItems();

        return "editItem";
    }

    public String getItemForEdit()
    {
        item = this.itemLogic.getItemForEdit(item.getItemID());

        return "editItem2";
    }

    public String editItem()
    {
        this.itemLogic.editItem(item, item.getItemID());
        return null;
    }
}
