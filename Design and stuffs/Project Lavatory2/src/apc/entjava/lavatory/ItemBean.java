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

    public String getItems1()
    {
        items = this.itemLogic.getItemHair();

        for (Item item: items)
        {
            item.getCategory();
            item.getItemName();
        }

        return "hair";
    }

    public String addItem()
    {
        this.itemLogic.addItem(item);

        return "success";
    }
}
