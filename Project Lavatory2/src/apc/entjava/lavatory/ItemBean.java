package apc.entjava.lavatory;

/**
 * Created by Kervi on 12/14/2016.
 */

import apc.entjava.lavatory.businesslogic.ItemLogic;
import apc.entjava.lavatory.dao.ItemDao;
import apc.entjava.lavatory.model.Item;

import javax.faces.bean.ManagedBean;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class ItemBean {

    private ItemLogic itemLogic = new ItemDao();
    private List<Item> items = new ArrayList<>();
    private Item item;

    private int itemID;
    private String category;
    private String itemName;
    private String casePack;
    private BigDecimal buyCost;
    private BigDecimal unitCost;
    private String description;

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCasePack() {
        return casePack;
    }

    public void setCasePack(String casePack) {
        this.casePack = casePack;
    }

    public BigDecimal getBuyCost() {
        return buyCost;
    }

    public void setBuyCost(BigDecimal buyCost) {
        this.buyCost = buyCost;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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
        item = this.itemLogic.editItem(
                this.itemID,
                this.category,
                this.itemName,
                this.casePack,
                this.buyCost,
                this.unitCost,
                this.description);

        return "editItem2";
    }
}
