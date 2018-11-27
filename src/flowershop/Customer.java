/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 ****/
package flowershop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import flowershop.CCustomer;
import static flowershop.FlowerShop.cust;
import static flowershop.FlowerShop.flush;
import static flowershop.FlowerShop.manageSelectionError;
/**
 *
 * @author User
 */
public class Customer {
    private static Scanner s;
    static List<CCustomer> cust = new ArrayList<>();
    public static void main(String[] args) {
        
        cust.add(new CCustomer("C01","Lucas","0161223444","Normal","123456", "0"));
        cust.add(new CCustomer("C02","Kelly","01641244567","Normal","123456", "0"));
        cust.add(new CCustomer("C03","Haw","0187766552","Normal","123456", "0"));
        s = new Scanner(System.in);
        int c1;
        int d1 = 0;
        int q1 = 0;
        do{    
            System.out.println("1. Register As Customer");
            System.out.println("2. Login");
               c1 = manageSelectionError();
            flush();
            switch (c1) {
                case 1:
                    registerCustomer();
                    System.out.println();
                    break;
                case 2:
                    login();
                    System.out.println();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Please choose between 0 to 2.");
                    break;
            }
//            System.out.print("Please Enter Your Selection: ");
//                System.out.flush();
//                c1 = s.nextInt();
//                
//                if(c1 == 1){
//                    registerCustomer();
//                    System.out.println("Enter 1 to back to menu");
//                    d1 = s.nextInt();
//                }else if(c1 == 2){
//                    login();
//                    System.out.println("Enter 1 to access menu");
//                    d1 = s.nextInt();
//                }
        
            }while(d1 == 1);   
    }
    
    public static void registerCustomer(){
                    String sid = "C";
                    String sname;
                    String sphno;
                    String stype;
                    String spass;
                  
                    
                    System.out.print("Enter your name: ");
                    s.nextLine();
                    sname = s.nextLine();
                    
                    sphno = handlePhnoErr();

                    stype = CustomerType();

                    s.nextLine();
                    spass = passwordValidation();
                    
                    if(cust.isEmpty()){
                         sid+=String.format("%02d",cust.size()+1);
                     }
                     else{
                         int lastEidNumber=Integer.parseInt(cust.get(cust.size()-1).getCustId().substring(1));
                         sid="C"+String.format("%02d",lastEidNumber+1);
                     }

                    cust.add(new CCustomer(sid, sname, sphno, stype, spass, null));
                    
                    System.out.println("You had sucessfully registered");
                    System.out.println("Here is your details");
                    System.out.println(sid);
                    System.out.println(sname);
                    System.out.println(sphno);
                    System.out.println(stype);
                    
                    
    }
    
    public static void login(){
        int o=0, q1=0;
                    do{
      
                        String cid;
                        String password;
                        boolean user = false;

                        System.out.print("Enter ur Customer id: ");
                        
                        //s.nextLine();
                        cid = s.next();

                        System.out.print("Enter ur password: ");
                        System.out.flush();
                        password = s.next();
                        
                        for(int i=0; i<cust.size(); i++){
                            if(cid.equals(cust.get(i).getCustId()) && password.equals(cust.get(i).getPassword())){
                                user = true;
                            }
                        }  
                        if(user == false){
                            System.out.println("Incorrect!! Please Try again!!");                           
                            o++;    
                        }
                        else{
                            System.out.println("You are allow to access the main menu");
                            o=0;
                        }
                    }while(o != 0);
                    
                    System.out.println("Enter 1 to access menu");
                    q1 = s.nextInt();
                    if(q1 == 1){
                         FlowerShop.CustMenu();
                    }
    }
    
    public static String handlePhnoErr(){
        //converting date of birth from NRIC
        boolean valid = false;
        int first;
        String phno = null;
        
        do{
            try{
                System.out.print("Enter phone number : ");
                phno = s.nextLine();
                
                if (!phno.matches("[0-9]+")) {
                    System.out.println("Phone number only allow integers. Please try again.");
                }
                
                first = Integer.parseInt(phno.substring(0,3).replaceFirst ("^0*", ""));
                int length = String.valueOf(phno).length();
                
                if(first == 11){
                    if(length == 10 || length == 11){
                        valid = true;
                    }
                    else{
                        System.out.println("Invalid phone number. Please try again.");
                    }
                }
                
                else if(length == 10){
                    valid = true;
                }
                
                else{
                    System.out.println("Invalid phone number. Please try again.");
                }
                   
            }catch (Exception ex){
                System.out.println("Invalid input please try again! ");
                s.nextLine();
            }
        }while(!valid);
        
        return phno;
    }
    public static String passwordValidation(){
            String password = null;
            boolean valid = false;
            String upperCaseChars = "(.*[A-Z].*)";
            String lowerCaseChars = "(.*[a-z].*)";
            String numbers = "(.*[0-9].*)";
            do{
                    System.out.print("Enter your password: ");     
                    password = s.nextLine();
                        
                        if (password.length() > 15 || password.length() < 8)
                        {
                                System.out.println("Password should be less than 15 and more than 8 characters in length.");
                                valid = false;
                        }
                         else if (!password.matches(upperCaseChars ))
                        {
                                System.out.println("Password should contain atleast one upper case alphabet");
                                valid = false;
                        }
                         else if (!password.matches(lowerCaseChars ))
                        {
                                System.out.println("Password should contain atleast one lower case alphabet");
                                valid = false;
                        }
                         else if (!password.matches(numbers ))
                        {
                                System.out.println("Password should contain atleast one number.");
                                valid = false;
                        }
                        else
                        {
                                valid = true;
                        }
            }while(!valid);
        return password;
        }
    
    public static String CustomerType(){
        boolean valid = false;
        int stype = 0;
        String custType = null;
        do{
                    System.out.println("Enter your customer type: (1.Normal / 2.Coorperate) ");
                    System.out.print("Enter your choice: (Only 1 or 2) ");
                    stype = s.nextInt();
        
                    if(stype != 1 && stype != 2){
                        System.out.println("Invalid input, Please try again");
                        valid = false;
                    }else if(stype == 1){
                        custType = "Normal";
                        valid = true;
                    }else if (stype == 2){
                        custType = "Coorperate";
                        valid = true;
                    }
        }while(!valid);
        return custType;
        
    }
    
     public static void modifyCust(){
        int o=0;
        String sel;
      
//                        String id;
//                        String password;
                        boolean user = false;
//
//                        System.out.print("Enter ur Customer id again: ");
//                        
//                        //s.nextLine();
//                        cid = s.next();
//
//                        System.out.print("Enter ur password: ");
//                        System.out.flush();
//                        password = s.next();
                        
                        for(int i=0; i<cust.size(); i++){
                            if(cust.equals(cust.get(i).getCustId())){
                                System.out.println("Here is Your Details");
                                System.out.println("Customer ID \t Name \t\t Phone Number \t Customer Type ");
                                System.out.println(cust.get(i).getCustId() + "\t\t" + cust.get(i).getName() + "\t\t" + cust.get(i).getPhone() + "\t\t" + cust.get(i).getCustomerType());
                                
                                
                                System.out.print("Do you wish to edit ur profile? (y/n)");
                                sel = s.next();
                                
                                int p=0;
                                do{
                                    
                                    if(sel.equals("n")){
                                        //main(args);
                                    }else if(sel.equals("y")){
                                        System.out.print("Enter your new name: ");
                                        flush();
                                        String sname = s.nextLine();
                    
                                        String sphno = handlePhnoErr();

                                        //flush();
                                        String spass = passwordValidation();
                                        
                                        cust.get(i).setName(sname);
                                        cust.get(i).setPhone(sphno);
                                        cust.get(i).setPassword(spass);
                                        user = true;
                                        
                                        System.out.println("Update Successfully");
                                        
                                    }else{
                                        System.out.println("Invalid input");
                                        p++;
                                        break;
                                    }
                                }while(p != 0);
                            }
                        }  
    }
     
      public static void setCreditLimit(){
        int p=0;
        do{
        boolean valid = false;
        String name;
        String limit;
        
        
        
            System.out.println("Here is the cooperate customer which havent set Credit Limit");
             for(int i=0 ; i<cust.size() ; i++){
                 if(cust.get(i).getCustomerType() == "Cooperate" && cust.get(i).getCreditLimit() == "0"){
                     System.out.println(cust.get(i).getName());
                 }
             }

                System.out.println("Please enter the name that u want to set credit limit");
                name = s.nextLine();
                for(int i=0 ; i<cust.size() ; i++){
                        if(name.equals(cust.get(i).getName())){
                            valid = true;
                            //tname = name;
                        }                  
                }
                if(valid = false){
                    System.out.println("Invalid Input!!!");
                    p++;
                }
                else{
                    for(int i=0 ; i<cust.size() ; i++){
                         if(cust.equals(cust.get(i).getName())){
                             System.out.println("Enter the credit limit for " + cust);
                             limit = s.nextLine();

                             cust.get(i).setCreditLimit(limit);
                             System.out.println("You had successfully entered credit limit for this customer");
                             p=0;
                         }
                    }
                }
        }while(p!=0);
    }
    public static void checkCreditLimit(){
        int q1;
        boolean valid = false;
        
       for(int i=0; i< cust.size(); i++){
            if(cust.equals(cust.get(i).getCustId())){
                if("Cooperate".equals(cust.get(i).getCustomerType())){
                    System.out.println("Your Credit limit is RM " + cust.get(i).getCreditLimit());
                    break;
                } 
                else if("Normal".equals(cust.get(i).getCustomerType())){
                    System.out.println("Sry u dun have credit limit");
                    break;
                }else{
                    
                }     
            }
            
        }
        
       
        System.out.println("Enter 1 to back menu");
                    q1 = s.nextInt();
                    if(q1 == 1){
                         //CustMenu();
                    }
    }
}
