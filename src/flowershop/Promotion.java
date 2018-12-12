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
public class Promotion {
    private String pID;
    private String pPackage;
    private String pType;   
    private Double pPrice;

    public Promotion(String pID, String pPackage, String pType, Double pPrice) {
        this.pID = pID;
        this.pPackage = pPackage;
        this.pType = pType;
        this.pPrice = pPrice;
    }

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public String getpPackage() {
        return pPackage;
    }

    public void setpPackage(String pPackage) {
        this.pPackage = pPackage;
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
    }

    public Double getpPrice() {
        return pPrice;
    }

    public void setpPrice(Double pPrice) {
        this.pPrice = pPrice;
    }

    @Override
    public String toString() {
        return "Promotion{" + "pID=" + pID + ", pPackage=" + pPackage + ", pType=" + pType + ", pPrice=" + pPrice + '}';
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
}
