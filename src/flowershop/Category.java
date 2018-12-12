/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowershop;

/**
 *
 * @author Desomond
 */
public class Category {
    private String category;
    private String cID;
    private String cType;
    private Integer cQuantity;
    private Double cPrice;
    private String stock;

    public Category(String category, String cID, String cType, Integer cQuantity, Double cPrice, String stock) {
        this.category = category;
        this.cID = cID;
        this.cType = cType;
        this.cQuantity = cQuantity;
        this.cPrice = cPrice;
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getcID() {
        return cID;
    }

    public void setcID(String cID) {
        this.cID = cID;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public Integer getcQuantity() {
        return cQuantity;
    }

    public void setcQuantity(Integer cQuantity) {
        this.cQuantity = cQuantity;
    }

    public Double getcPrice() {
        return cPrice;
    }

    public void setcPrice(Double cPrice) {
        this.cPrice = cPrice;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Category{" + "category=" + category + ", cID=" + cID + ", cType=" + cType + ", cQuantity=" + cQuantity + ", cPrice=" + cPrice + ", stock=" + stock + '}';
    }
    
}
