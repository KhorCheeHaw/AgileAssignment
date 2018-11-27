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
public class FloralManagement {
     private String floraId;
    private String floralType; 
     private String quantity;
     private String price;

    public FloralManagement(String floraId, String floralType, String quantity, String price) {
        this.floraId = floraId;
        this.floralType = floralType;
        this.quantity = quantity;
        this.price = price;
    }

    

    public String getFloraId() {
        return floraId;
    }

    public void setFloraId(String floraId) {
        this.floraId = floraId;
    }

    public String getFloralType() {
        return floralType;
    }

    public void setFloralType(String floralType) {
        this.floralType = floralType;
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
        return  floraId + "\t\t" + floralType+ "\t\t" +price + "\t\t"+ quantity    ;
    }

    
    
}
