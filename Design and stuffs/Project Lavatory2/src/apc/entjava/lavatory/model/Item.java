package apc.entjava.lavatory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Item {

    private int itemID;
    private String category;
    private String itemName;
    private String casePack;
    private BigDecimal buyCost;
    private BigDecimal unitCost;
    private String description;

    @Id
    @GeneratedValue
    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    @Column(nullable=false, length=50)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Column(nullable=false, length=50)
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Column(nullable=false, length=50)
    public String getCasePack() {
        return casePack;
    }

    public void setCasePack(String casePack) {
        this.casePack = casePack;
    }

    @Column(nullable=false, length=50)
    public BigDecimal getBuyCost() {
        return buyCost;
    }

    public void setBuyCost(BigDecimal buyCost) {
        this.buyCost = buyCost;
    }

    @Column(nullable=false, length=50)
    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    @Column(nullable=false, length=254)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Item(int itemID, String category, String itemName, String casePack, BigDecimal buyCost, BigDecimal unitCost, String description) {
        this.itemID = itemID;
        this.category = category;
        this.itemName = itemName;
        this.casePack = casePack;
        this.buyCost = buyCost;
        this.unitCost = unitCost;
        this.description = description;
    }

    public Item() {
    }
}
