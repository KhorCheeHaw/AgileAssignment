/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowershop;

/**
 *
 * @author User
 */
public class FreshFlower {
    private String flowerId;
    private String flowerType; 
     private String quantity;
     private String price;

    public FreshFlower(String flowerId, String flowerType, String quantity, String price) {
        this.flowerId = flowerId;
        this.flowerType = flowerType;
        this.quantity = quantity;
        this.price = price;
    }
    

    public String getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(String flowerId) {
        this.flowerId = flowerId;
    }

    public String getFlowerType() {
        return flowerType;
    }

    public void setFlowerType(String flowerType) {
        this.flowerType = flowerType;
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
        return  flowerId + "\t\t" + flowerType + "\t\t" + price + "\t\t" + quantity;
    }
    
     
     
}
