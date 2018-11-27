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
public class CCustomer {
    private String CustId; 
     private String name;
     private String phone;
     private String CustomerType;
     private String password;
     private String CreditLimit;

    public CCustomer(String CustId, String name, String phone, String CustomerType, String password, String CreditLimit) {
        this.CustId = CustId;
        this.name = name;
        this.phone = phone;
        this.CustomerType = CustomerType;
        this.password = password;
        this.CreditLimit = CreditLimit;
    }

   

    public String getCustId() {
        return CustId;
    }

    public void setCustId(String CustId) {
        this.CustId = CustId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCustomerType() {
        return CustomerType;
    }

    public void setCustomerType(String CustomerType) {
        this.CustomerType = CustomerType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getCreditLimit(){
        return CreditLimit;
    }
    
    public void setCreditLimit(String CreditLimit){
        this.CreditLimit = CreditLimit;
    }

//    @Override
//    public String toString() {
//        return "CCustomer{" + "CustId=" + CustId + ", name=" + name + ", phone=" + phone + ", CustomerType=" + CustomerType + ", password=" + password + '}';
//    }

    @Override
    public String toString() {
        return "CCustomer{" + "CustId=" + CustId + ", name=" + name + ", phone=" + phone + ", CustomerType=" + CustomerType + ", password=" + password + ", CreditLimit=" + CreditLimit + '}';
    }
     
     
    
}
