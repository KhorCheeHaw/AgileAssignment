/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowershop;

/**
 *
 * @author 
 */
public class Bouquets {
     private String bouquetId;
    private String bouquetType; 
     private String quantity;
     private String price;

    public Bouquets(String bouquetId, String bouquetType, String quantity, String price) {
        this.bouquetId = bouquetId;
        this.bouquetType = bouquetType;
        this.quantity = quantity;
        this.price = price;
    }

   

    public String getBouquetId() {
        return bouquetId;
    }

    public void setBouquetId(String bouquetId) {
        this.bouquetId = bouquetId;
    }

    public String getBouquetType() {
        return bouquetType;
    }

    public void setBouquetType(String bouquetType) {
        this.bouquetType = bouquetType;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  bouquetId+ "\t\t" +  bouquetType+ "\t\t" +price + "\t\t"+ quantity ;
    }

    
}
