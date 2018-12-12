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
public class Invoice {
    private String orderId;
    private String cname;
    private String item;
    private String qtt;
    private String pric;

    public Invoice(String orderId, String cname, String item, String qtt, String pric) {
        this.orderId = orderId;
        this.cname = cname;
        this.item = item;
        this.qtt = qtt;
        this.pric = pric;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getQtt() {
        return qtt;
    }

    public void setQtt(String qtt) {
        this.qtt = qtt;
    }

    public String getPric() {
        return pric;
    }

    public void setPric(String pric) {
        this.pric = pric;
    }

    
    
}
