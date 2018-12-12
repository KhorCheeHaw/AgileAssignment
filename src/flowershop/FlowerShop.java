/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flowershop;

import java.util.Scanner;
import flowershop.Customer;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Lucus
 */
public class FlowerShop {

    static List<CCustomer> cust = new ArrayList<>();
    static List<Bouquets> bouquets = new ArrayList<Bouquets>();
    static List<FreshFlower> flower = new ArrayList<FreshFlower>();
    static List<FloralManagement> floral = new ArrayList<FloralManagement>();
    static List<Order> order = new ArrayList<Order>();
    static List<Category> cc = new ArrayList<>();
    static String CustId;
    static String tname;
    static String tlimit;
    static String ttype;
    static String torder;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("hh.mm.ss a");

    private static Scanner s;

    public static void main(String[] args) {
        initial();
        flowershopMenu();
    }

    public static void flowershopMenu() {
        s = new Scanner(System.in);
        int c1 = 0;

        do {
            System.out.println("Welcome to KCCC Flower Shop");
            System.out.println("-----------------------------------------------");
            System.out.println("1. Staff");
            System.out.println("2. Customer");
            c1 = manageSelectionError();
            flush();
            switch (c1) {
                case 1:
                    StaffLogin();
                    System.out.println();
                    break;
                case 2:
                    CustMain();
                    System.out.println();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Please choose between 0 to 2.");
                    break;
            }
        } while (c1 != 0);
    }

    public static void CustMenu() {
        s = new Scanner(System.in);
        int c1 = 0;

        do {
            System.out.println("Welcome to Flower Shop (Customer)");
            System.out.println("-----------------------------------------------");
            System.out.println("1. Make Order");
            System.out.println("2. Check My Credit Limit");
            System.out.println("3. Edit Profile");
            System.out.println("4. Views Invoice");
            System.out.println("5. Views Order");
            System.out.println("6. Log Out");
            c1 = manageSelectionError();
            flush();
            switch (c1) {
                case 1:
                    startOrder();
                    System.out.println();
                    break;
                case 2:
                    checkCreditLimit();
                    System.out.println();
                    break;
                case 3:
                    modifyCust();
                    System.out.println();
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    flowershopMenu();
                    System.out.println();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Please choose between 0 to 2.");
                    break;
            }
        } while (c1 != 0);
    }

    public static void CustMain() {
        s = new Scanner(System.in);
        int c1;
        int d1 = 0;
        int q1 = 0;
        do {
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

        } while (d1 == 1);
    }

    public static void registerCustomer() {
        String sid = "C";
        String sname;
        String sphno;
        String stype;
        String spass;
        String slimit;

        System.out.print("Enter your name: ");
        sname = s.nextLine();

        sphno = handlePhnoErr();

        stype = CustomerType();

        s.nextLine();
        spass = passwordValidation();

        slimit = "0";

        if (cust.isEmpty()) {
            sid += String.format("%02d", cust.size() + 1);
        } else {
            int lastEidNumber = Integer.parseInt(cust.get(cust.size() - 1).getCustId().substring(1));
            sid = "C" + String.format("%02d", lastEidNumber + 1);
        }

        cust.add(new CCustomer(sid, sname, sphno, stype, spass, slimit));

//                    for(int i = 0; i < cust.size() ; i++){
//                        System.out.println(cust.get(i));
//                    }
        System.out.println("You had sucessfully registered");
        System.out.println("Here is your details");
        System.out.println("Customer ID \t Name \t\t Phone Number \t Customer Type ");
        System.out.println(sid + "\t\t" + sname + "\t\t" + sphno + "\t\t" + stype);

        if (stype == "Cooperate") {
            System.out.println("You may check your credit limit after login");
        }

    }

    public static void modifyCust() {
        int o = 0;
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

        for (int i = 0; i < cust.size(); i++) {
            if (CustId.equals(cust.get(i).getCustId())) {
                System.out.println("Here is Your Details");
                System.out.println("Customer ID \t Name \t\t Phone Number \t Customer Type ");
                System.out.println(cust.get(i).getCustId() + "\t\t" + cust.get(i).getName() + "\t\t" + cust.get(i).getPhone() + "\t\t" + cust.get(i).getCustomerType());

                System.out.print("Do you wish to edit ur profile? (y/n)");
                sel = s.next();

                int p = 0;
                do {

                    if (sel.equals("n")) {
                        CustMenu();
                    } else if (sel.equals("y")) {
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

                    } else {
                        System.out.println("Invalid input");
                        p++;
                        break;
                    }
                } while (p != 0);
            }
        }
    }

    public static void login() {
        int o = 0, q1 = 0;
        do {

            String cid;
            String password;
            boolean user = false;

            System.out.print("Enter ur Customer id: ");

            //s.nextLine();
            cid = s.next();

            System.out.print("Enter ur password: ");
            System.out.flush();
            password = s.next();

            for (int i = 0; i < cust.size(); i++) {
                if (cid.equals(cust.get(i).getCustId()) && password.equals(cust.get(i).getPassword())) {
                    user = true;
                    CustId = cid;

                }
            }
            if (user == false) {
                System.out.println("Incorrect!! Please Try again!!");
                o++;
            } else {
                System.out.println("You are allow to access the main menu");
                o = 0;
            }
        } while (o != 0);

        System.out.println("Enter 1 to access menu");
        q1 = s.nextInt();
        if (q1 == 1) {
            CustMenu();
        }

    }

    public static void StaffMenu() {
        s = new Scanner(System.in);
        int c1 = 0;

        do {
            System.out.println("Welcome to Flower Shop (Staff)");
            System.out.println("-----------------------------------------------");
            System.out.println("1. Catalog Maintainance");
            System.out.println("2. Record Time Stamp");
            System.out.println("3. Customer Maintainance");
            System.out.println("4. Display Current Date Order");
            System.out.println("5. Display Delivery Route");
            System.out.println("6. Manage Consumer Payment");
            System.out.println("7. Log Out");
            c1 = manageSelectionError();
            flush();
            switch (c1) {
                case 1:
                    CatelogMaintainance();
                    System.out.println();
                    break;
                case 2:
                    recordTimestamp();
                    System.out.println();
                    break;
                case 3:
                    CustMaintain();
                    System.out.println();
                    break;
                case 4:
                    displayOrder();
                    System.out.println();
                    break;
                case 5:
                    displayDeliveryRoute();
                    System.out.println();
                    break;
                case 6:
                    manageConsumerPayment();
                    System.out.println();
                    break;
                case 7:
                    flowershopMenu();
                    System.out.println();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Please choose between 0 to 5.");
                    break;
            }
        } while (c1 != 0);
    }

    public static void StaffLogin() {
        int o = 0;
        String Username;
        String Password;
        String username;
        String password = "";

        Password = "admin123";
        Username = "Admin";

        System.out.println("\t KCCC Flower Shop (Staff )");
        System.out.println("---------------------------------------------");
        do {
            Scanner input1 = new Scanner(System.in);
            System.out.print("Enter Username : ");
            username = input1.next();

            System.out.print("Enter Password : ");
            password = input1.next();

            if (!username.equals(Username) && password.equals(Password)) {
                System.out.println("Invalid Username!");
            } else if (!password.equals(Password) && username.equals(Username)) {
                System.out.println("Invalid Password!");
            } else if (!password.equals(Password) && !username.equals(Username)) {
                System.out.println("Invalid Username & Password!!");
            } else {
                System.out.println("Correct username and password!");
                o++;
                break;

            }
        } while (Username != username && Password != password);

        if (o != 0) {
            StaffMenu();
        }
    }

    public static void CustMaintain() {
        s = new Scanner(System.in);
        int c1 = 0;

        do {
            System.out.println("Customer Maintainance (Staff)");
            System.out.println("-----------------------------------------------");
            System.out.println("1. Set Cooperate Customer Credit Limit");
            System.out.println("2. Classify Customer Type");
            System.out.println("3. Log Out");
            c1 = manageSelectionError();
            flush();
            switch (c1) {
                case 1:
                    setCreditLimit();
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    break;
                case 3:
                    flowershopMenu();
                    System.out.println();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Please choose between 0 to 3.");
                    break;
            }
        } while (c1 != 0);
    }

    public static void initial() {
        CCustomer customer1;
        Bouquets bouquets1;
        FreshFlower flower1;
        FloralManagement floral1;
        Order order1;
        Category cate;

        customer1 = new CCustomer("C01", "Lucas", "0161223444", "Cooperate", "123456", "0");
        cust.add(customer1);
        customer1 = new CCustomer("C02", "Kelly", "01641244567", "Normal", "123456", "0");
        cust.add(customer1);
        customer1 = new CCustomer("C03", "Haw", "0187766552", "Cooperate", "123456", "0");
        cust.add(customer1);

        bouquets1 = new Bouquets("1", "rose", "15", "20");
        bouquets.add(bouquets1);
        bouquets1 = new Bouquets("2", "abc", "15", "20");
        bouquets.add(bouquets1);
        bouquets1 = new Bouquets("3", "abc", "15", "20");
        bouquets.add(bouquets1);

        flower1 = new FreshFlower("1", "Rose", "15", "20");
        flower.add(flower1);
        flower1 = new FreshFlower("2", "Lily", "15", "20");
        flower.add(flower1);
        flower1 = new FreshFlower("3", "Orchid", "15", "20");
        flower.add(flower1);

        floral1 = new FloralManagement("1", "rose", "15", "20");
        floral.add(floral1);
        floral1 = new FloralManagement("2", "abc", "15", "20");
        floral.add(floral1);
        floral1 = new FloralManagement("3", "abc", "15", "20");
        floral.add(floral1);

        order1 = new Order("O01", "Lucas", "12/12/2018", "Self Pick-up", "Pending", "         Pending", "20", "-");
        order.add(order1);
        order1 = new Order("O02", "Kelly", "12/12/2018", "Self Pick-up", "Pending", "         Pending", "30", "-");
        order.add(order1);
        order1 = new Order("O03", "Haw", "12/12/2018", "Self Pick-up", "Pending", "         Pending", "40", "-");
        order.add(order1);
        order1 = new Order("O04", "Mong", "12/12/2018", "Self Pick-up", "Pending", "         Pending", "50", "-");
        order.add(order1);
        order1 = new Order("O05", "Chong", "12/12/2018", "Delivery", "Pending", "         Pending", "20", "Wangsa Maju");
        order.add(order1);
        order1 = new Order("O06", "Chin", "12/12/2018", "Delivery", "Pending", "         Pending", "30", "Gombak");
        order.add(order1);
        order1 = new Order("O07", "Khor", "12/12/2018", "Delivery", "Pending", "         Pending", "40", "Genting Klang");
        order.add(order1);
        order1 = new Order("O08", "Chua", "12/12/2018", "Delivery", "Pending", "         Pending", "50", "Petaling Jaya");
        order.add(order1);
        order1 = new Order("O09", "Jun", "12/12/2018", "Delivery", "Pending", "         Pending", "20", "Petaling Jaya");
        order.add(order1);
        order1 = new Order("O10", "Ying", "12/12/2018", "Delivery", "Pending", "         Pending", "30", "Gombak");
        order.add(order1);
        order1 = new Order("O11", "Chee", "12/12/2018", "Delivery", "Pending", "         Pending", "40", "Wangsa Maju");
        order.add(order1);
        order1 = new Order("O12", "Jie", "12/12/2018", "Delivery", "Pending", "         Pending", "50", "Genting Klang");
        order.add(order1);

        cate = new Category("Flower", "F01", "Rose", 10, 10.50, "High");
        cc.add(cate);
        cate = new Category("Bouquet", "B01", "Posy", 10, 10.50, "High");
        cc.add(cate);
        cate = new Category("FloralArrangement", "A01", "Oval", 3, 10.50, "Low");
        cc.add(cate);
    }

    public static int manageSelectionError() {
        int selection = 0;
        boolean valid = false;
        do {
            try {
                System.out.print("Please select Selection : ");
                selection = s.nextInt();

                valid = true;
            } catch (Exception ex) {
                System.out.println("Invalid input. Please try again! ");
                flush();
            }
        } while (!valid);
        return selection;
    }

    public static String handlePhnoErr() {
        //converting date of birth from NRIC
        boolean valid = false;
        int first;
        String phno = null;

        do {
            try {
                System.out.print("Enter phone number : ");
                phno = s.nextLine();

                if (!phno.matches("[0-9]+")) {
                    System.out.println("Phone number only allow integers. Please try again.");
                }

                first = Integer.parseInt(phno.substring(0, 3).replaceFirst("^0*", ""));
                int length = String.valueOf(phno).length();

                if (first == 11) {
                    if (length == 10 || length == 11) {
                        valid = true;
                    } else {
                        System.out.println("Invalid phone number. Please try again.");
                    }
                } else if (length == 10) {
                    valid = true;
                } else {
                    System.out.println("Invalid phone number. Please try again.");
                }

            } catch (Exception ex) {
                System.out.println("Invalid input please try again! ");
                s.nextLine();
            }
        } while (!valid);

        return phno;
    }

    public static String passwordValidation() {
        String password = null;
        boolean valid = false;
        String upperCaseChars = "(.*[A-Z].*)";
        String lowerCaseChars = "(.*[a-z].*)";
        String numbers = "(.*[0-9].*)";
        do {
            System.out.print("Enter your password: ");
            password = s.nextLine();

            if (password.length() > 15 || password.length() < 8) {
                System.out.println("Password should be less than 15 and more than 8 characters in length.");
                valid = false;
            } else if (!password.matches(upperCaseChars)) {
                System.out.println("Password should contain atleast one upper case alphabet");
                valid = false;
            } else if (!password.matches(lowerCaseChars)) {
                System.out.println("Password should contain atleast one lower case alphabet");
                valid = false;
            } else if (!password.matches(numbers)) {
                System.out.println("Password should contain atleast one number.");
                valid = false;
            } else {
                valid = true;
            }
        } while (!valid);
        return password;
    }

    public static String CustomerType() {
        boolean valid = false;
        int stype = 0;
        String custType = null;
        do {
            System.out.println("Enter your customer type: (1.Normal / 2.Cooperate) ");
            System.out.print("Enter your choice: (Only 1 or 2) ");
            stype = s.nextInt();

            if (stype != 1 && stype != 2) {
                System.out.println("Invalid input, Please try again");
                valid = false;
            } else if (stype == 1) {
                custType = "Normal";
                valid = true;
            } else if (stype == 2) {
                custType = "Cooperate";
                valid = true;
            }
        } while (!valid);
        return custType;

    }

    public static void flush() {
        s.nextLine();
    }

    public static void setCreditLimit() {
        int p = 0;
        do {
            boolean valid = false;
            String name;
            String limit;

            System.out.println("Here is the cooperate customer which havent set Credit Limit");
            for (int i = 0; i < cust.size(); i++) {
                if (cust.get(i).getCustomerType() == "Cooperate" && cust.get(i).getCreditLimit() == "0") {
                    System.out.println(cust.get(i).getName());
                }
            }

            System.out.println("Please enter the name that u want to set credit limit");
            name = s.nextLine();
            for (int i = 0; i < cust.size(); i++) {
                if (name.equals(cust.get(i).getName())) {
                    valid = true;
                    tname = name;
                }
            }
            if (valid = false) {
                System.out.println("Invalid Input!!!");
                p++;
            } else {
                for (int i = 0; i < cust.size(); i++) {
                    if (tname.equals(cust.get(i).getName())) {
                        System.out.println("Enter the credit limit for " + tname);
                        limit = s.nextLine();

                        cust.get(i).setCreditLimit(limit);
                        System.out.println("You had successfully entered credit limit for this customer");
                        p = 0;
                    }
                }
            }
        } while (p != 0);
    }

    public static void checkCreditLimit() {
        int q1;
        boolean valid = false;

        for (int i = 0; i < cust.size(); i++) {
            if (CustId.equals(cust.get(i).getCustId())) {
                if ("Cooperate".equals(cust.get(i).getCustomerType())) {
                    System.out.println("Your Credit limit is RM " + cust.get(i).getCreditLimit());
                    break;
                } else if ("Normal".equals(cust.get(i).getCustomerType())) {
                    System.out.println("Sry u dun have credit limit");
                    break;
                } else {

                }
            }

        }

        System.out.println("Enter 1 to back menu");
        q1 = s.nextInt();
        if (q1 == 1) {
            CustMenu();
        }
    }

    public static void CatelogMaintainance() {
        int c1;

        System.out.println("Fiora FlowerShop");
        System.out.println("----------------------------");
        System.out.println("1. View Product");
        System.out.println("2. Add Product");
        System.out.println("3. Edit Product");
        System.out.println("4. Go to previous page");
        c1 = manageSelectionError();
        flush();

        switch (c1) {
            case 1:
                viewAll();
                break;
            case 2:
                addAll();
                break;
            case 3:
                maintain();
                break;
            case 4:
                StaffMenu();
                break;
            default:
                System.out.println("Please choose between 0 to 3.");
                break;
        }
    }

    public static void viewAll() {
        int c1;
        int d1 = 0;

        do {

            System.out.println("Fiora FlowerShop");
            System.out.println("----------------------------");
            System.out.println("1. Fresh Flower");
            System.out.println("2. Bouquets");
            System.out.println("3. Floral Arrangement");
            System.out.println("4. Back To Menu");
            c1 = manageSelectionError();
            flush();

            switch (c1) {
                case 1:
                    String F = "Flower";
                    System.out.println("ID\t\t Type\t\t Price(RM)\t\t Quantity\t\t Stock");
                    System.out.println("-----------------------------------------------");
                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals(F)) {

                            System.out.println(cc.get(i).getcID() + "\t\t" + cc.get(i).getcType() + "\t\t" + cc.get(i).getcPrice() + "\t\t" + cc.get(i).getcQuantity() + "\t\t" + cc.get(i).getStock());

                        }

                    }
                    System.out.println("Enter 1 to back to menu");
                    d1 = s.nextInt();
                    break;

                case 2:
                    String B = "Bouquet";
                    System.out.println("ID\t\t Type\t\t Price(RM)\t\t Quantity\t\tStock");
                    System.out.println("-----------------------------------------------");
                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals(B)) {

                            System.out.println(cc.get(i).getcID() + "\t\t" + cc.get(i).getcType() + "\t\t" + cc.get(i).getcPrice() + "\t\t" + cc.get(i).getcQuantity() + "\t\t" + cc.get(i).getStock());

                        }
                    }
                    System.out.println("Enter 1 to back to menu");
                    d1 = s.nextInt();
                    break;

                case 3:
                    String FA = "FloralArrangement";
                    System.out.println("ID\t\t Type\t\t Price(RM)\t\t Quantity\t\tStock");
                    System.out.println("-----------------------------------------------");
                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals(FA)) {

                            System.out.println(cc.get(i).getcID() + "\t\t" + cc.get(i).getcType() + "\t\t" + cc.get(i).getcPrice() + "\t\t" + cc.get(i).getcQuantity() + "\t\t" + cc.get(i).getStock());

                        }
                    }
                    System.out.println("Enter 1 to back to menu");
                    d1 = s.nextInt();
                    break;

                case 4:
                    CatelogMaintainance();
                    break;
                default:
                    System.out.println("Please choose between 0 to 4.");

            }

        } while (d1 == 1);

    }

    public static void addAll() {
        int c1;
        int d1 = 0;

        do {

            System.out.println("Fiora FlowerShop");
            System.out.println("----------------------------");
            System.out.println("1. Fresh Flower");
            System.out.println("2. Bouquets");
            System.out.println("3. Floral Arrangement");
            System.out.println("4. Back To Menu");
            c1 = manageSelectionError();
            flush();

            switch (c1) {
                case 1:
                    freshflower();
                    break;
                case 2:
                    bouquets();
                    break;
                case 3:
                    floralarrangement();
                    break;
                case 4:
                    CatelogMaintainance();
                    break;
                default:
                    System.out.println("Please choose between 0 to 4.");
                    break;
            }

        } while (d1 == 1);
    }

    public static void maintain() {
        int c1;
        int d1 = 0;
        do {

            System.out.println("Fiora FlowerShop");
            System.out.println("----------------------------");
            System.out.println("1. Fresh Flower");
            System.out.println("2. Bouquets");
            System.out.println("3. Floral Arrangement");
            System.out.println("4. Back To Menu");
            System.out.flush();
            c1 = s.nextInt();

            if (c1 == 1) {
                FM();

            } else if (c1 == 2) {
                BM();

            } else if (c1 == 3) {
                FAM();

            } else if (c1 == 4) {
                CatelogMaintainance();
            }

        } while (d1 == 1);
    }

    public static void freshflower() {
        int c1;
        int d1 = 0;

        String ffId = "F";
        String ffType;
        Double ffPrice;

        do {

            System.out.println("Fiora FlowerShop");
            System.out.println("----------------------------");
            System.out.println("1. Add Flower Type");
            System.out.println("2. Add Flower Quantity");
            System.out.println("3. Back");
            c1 = manageSelectionError();
            flush();

            switch (c1) {
                case 1:
//                    System.out.print("Enter Flower ID: ");
//                    s.nextLine();
//                    ffId = s.nextLine();

                    System.out.print("Enter Flower Type: ");
                    ffType = s.nextLine();

                    System.out.print("Enter Flower Price (Rm): ");
                    ffPrice = s.nextDouble();

                    if (cc.isEmpty()) {
                        ffId += String.format("%02d", cc.size() + 1);
                    } else {
                        int lastEidNumber = Integer.parseInt(cc.get(cc.size() - 1).getcID().substring(1));
                        ffId = "F" + String.format("%02d", lastEidNumber + 1);
                    }

                    cc.add(new Category("Flower", ffId, ffType, 0, ffPrice, "Finish"));

                    System.out.println("ID\t\t Type\t\t Price(RM)\t\t Quantity\t\tStock");
                    System.out.println("------------------------------------------------------------------");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("Flower")) {

                            System.out.println(cc.get(i).getcID() + "\t\t" + cc.get(i).getcType() + "\t\t" + cc.get(i).getcPrice() + "\t\t" + cc.get(i).getcQuantity() + "\t\t" + cc.get(i).getStock());

                        }

                    }
                    CatelogMaintainance();
                    break;

                case 2:
                    System.out.print("Type\n");
                    System.out.print("----------------\n");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("Flower")) {
                            System.out.println(cc.get(i).getcType());
                            System.out.print("\n");
                            System.out.flush();
                        }
                    }

                    String ffTypes;
                    System.out.println("Type in Flower Type:");
                    ffTypes = s.next();

                    for (int i = 0; i < cc.size(); i++) {
                        if (ffTypes.equals(cc.get(i).getcType())) {
                            System.out.print("How many amount you want to add?\n");
                            Integer ffQuantity = s.nextInt();

                            cc.get(i).setcID(cc.get(i).getcID());
                            cc.get(i).setcType(cc.get(i).getcType());
                            cc.get(i).setcPrice(cc.get(i).getcPrice());

                            int total = ffQuantity + cc.get(i).getcQuantity();

                            cc.get(i).setcQuantity(total);
                        }
                    }

                    System.out.println("ID\t\t Type\t\t Price(RM)\t\t Quantity\t\tStock");
                    System.out.println("--------------------------------------------------------------------");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("Flower")) {

                            System.out.println(cc.get(i).getcID() + "\t\t" + cc.get(i).getcType() + "\t\t" + cc.get(i).getcPrice() + "\t\t" + cc.get(i).getcQuantity() + "\t\t" + cc.get(i).getStock());

                        }

                    }
                    CatelogMaintainance();
                    break;

                case 3:
                    addAll();
                    break;
                default:
                    System.out.println("Please choose between 0 to 3.");
                    break;

            }

        } while (d1 == 1);
    }

    public static void bouquets() {
        int c1;
        int d1 = 0;

        String bouId = "B";
        String bouType;
        Double bouPrice;
        String bouQuantity;
        String bouTypes;

        do {

            System.out.println("Bouquets");
            System.out.println("----------------------------");
            System.out.println("1. Add Bouquet Type");
            System.out.println("2. Add Bouquet Quantity");
            System.out.println("3. Back");
            c1 = manageSelectionError();
            flush();

            switch (c1) {
                case 1:
//                    System.out.print("Enter bouquets ID: ");
//                    s.nextLine();
//                    bouId = s.nextLine();

                    System.out.print("Enter Bouquets Type: ");
                    bouType = s.nextLine();

                    System.out.print("Enter Bouquets Price (Rm): ");
                    bouPrice = s.nextDouble();

                    if (cc.isEmpty()) {
                        bouId += String.format("%02d", cc.size() + 1);
                    } else {
                        int lastEidNumber = Integer.parseInt(cc.get(cc.size() - 1).getcID().substring(1));
                        bouId = "B" + String.format("%02d", lastEidNumber + 1);
                    }
                    cc.add(new Category("Bouquet", bouId, bouType, 0, bouPrice, "Finish"));

                    System.out.println("ID\t\t Type\t\t Price(RM)\t\t Quantity\t\tStock");
                    System.out.println("-----------------------------------------------");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("Bouquet")) {

                            System.out.println(cc.get(i).getcID() + "\t\t" + cc.get(i).getcType() + "\t\t" + cc.get(i).getcPrice() + "\t\t" + cc.get(i).getcQuantity() + "\t\t" + cc.get(i).getStock());

                        }

                    }
                    CatelogMaintainance();
                    break;

                case 2:
                    System.out.print("Type\n");
                    System.out.print("----------------\n");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("Bouquet")) {

                            System.out.print(i + "\t" + cc.get(i).getcType());
                            System.out.print("\n");
                            System.out.flush();

                        }
                    }

                    String ffTypes;
                    System.out.println("Type in Bouquets Type:");
                    ffTypes = s.next();

                    for (int i = 0; i < cc.size(); i++) {
                        if (ffTypes.equals(cc.get(i).getcType())) {
                            System.out.print("How many amount you want to add?\n");
                            Integer ffQuantity = s.nextInt();

                            cc.get(i).setcID(cc.get(i).getcID());
                            cc.get(i).setcType(cc.get(i).getcType());
                            cc.get(i).setcPrice(cc.get(i).getcPrice());

                            int total = ffQuantity + cc.get(i).getcQuantity();

                            cc.get(i).setcQuantity(total);
                        }
                    }

                    System.out.println("ID\t\t Type\t\t Price(RM)\t\t Quantity\t\t Stock");
                    System.out.println("-----------------------------------------------");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("Bouquet")) {

                            System.out.println(cc.get(i).getcID() + "\t\t" + cc.get(i).getcType() + "\t\t" + cc.get(i).getcPrice() + "\t\t" + cc.get(i).getcQuantity() + "\t\t" + cc.get(i).getStock());

                        }

                    }
                    CatelogMaintainance();
                    break;

                case 3:
                    addAll();
                    break;
                default:
                    System.out.println("Please choose between 0 to 3.");
                    break;

            }

        } while (d1 == 1);
    }

    public static void floralarrangement() {
        int c1;
        int d1 = 0;

        String faId = "A";
        String faType;
        Double faPrice;
        Integer faQuantity;
        String faTypes;

        do {

            System.out.println("Floral Arrangement");
            System.out.println("----------------------------");
            System.out.println("1. Add Floral Type");
            System.out.println("2. Add Floral Quantity");
            System.out.println("3. Back");
            c1 = manageSelectionError();
            flush();

            switch (c1) {
                case 1:
//                    System.out.print("Enter Floral ID: ");
//                    s.nextLine();
//                    faId = s.nextLine();

                    System.out.print("Enter Floral Type: ");
                    faType = s.nextLine();

                    System.out.print("Enter Floral Price (Rm): ");
                    faPrice = s.nextDouble();

                    if (cc.isEmpty()) {
                        faId += String.format("%02d", cc.size() + 1);
                    } else {
                        int lastEidNumber = Integer.parseInt(cc.get(cc.size() - 1).getcID().substring(1));
                        faId = "A" + String.format("%02d", lastEidNumber + 1);
                    }

                    cc.add(new Category("FloralArrangment", faId, faType, 0, faPrice, "Finish"));

                    System.out.println("ID\t\t Type\t\t Price(RM)\t\t Quantity\t\tStock");
                    System.out.println("----------------------------------------------------------");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("FloralArrangment")) {

                            System.out.println(cc.get(i).getcID() + "\t\t" + cc.get(i).getcType() + "\t\t" + cc.get(i).getcPrice() + "\t\t" + cc.get(i).getcQuantity() + "\t\t" + cc.get(i).getStock());

                        }

                    }
                    CatelogMaintainance();
                    break;

                case 2:
                    System.out.print("Type\n");
                    System.out.print("----------------\n");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("FloralArrangment")) {

                            System.out.print(i + "\t" + cc.get(i).getcType());
                            System.out.print("\n");
                            System.out.flush();

                        }
                    }

                    String ffTypes;
                    System.out.println("Type in Floral Type:");
                    ffTypes = s.next();

                    for (int i = 0; i < cc.size(); i++) {
                        if (ffTypes.equals(cc.get(i).getcType())) {
                            System.out.print("How many amount you want to add?\n");
                            Integer ffQuantity = s.nextInt();

                            cc.get(i).setcID(cc.get(i).getcID());
                            cc.get(i).setcType(cc.get(i).getcType());
                            cc.get(i).setcPrice(cc.get(i).getcPrice());

                            int total = ffQuantity + cc.get(i).getcQuantity();

                            cc.get(i).setcQuantity(total);
                        }
                    }

                    System.out.println("ID\t\t Type\t\t Price(RM)\t Quantity");
                    System.out.println("------------------------------------------------------------");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("FloralArrangment")) {

                            System.out.println(cc.get(i).getcID() + "\t\t" + cc.get(i).getcType() + "\t\t" + cc.get(i).getcPrice() + "\t\t" + cc.get(i).getcQuantity() + "\t\t" + cc.get(i).getStock());

                        }

                    }
                    CatelogMaintainance();
                    break;

                case 3:
                    addAll();
                    break;
                default:
                    System.out.println("Please choose between 0 to 3.");
                    break;

            }
        } while (d1 == 1);
    }

    public static void FM() {
        int c1;
        int d1 = 0;

        do {

            System.out.println("Fiora FlowerShop");
            System.out.println("-----------------------------------");
            System.out.println("1. Edit Flower Type");
            System.out.println("2. Edit Flower Quantity");
            System.out.println("3. Edit Flower Price");
            System.out.println("4. Delete Flower");
            System.out.println("5. Back");
            c1 = manageSelectionError();
            flush();

            switch (c1) {

                case 1:

                    System.out.print("Flower Type\n");
                    System.out.print("----------------------------\n");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("Flower")) {
                            System.out.println(cc.get(i).getcType());
                            System.out.print("\n");
                            System.out.flush();
                        }
                    }

                    String ffTypes;
                    System.out.println("Type in Flower Type:");
                    //s.nextLine();
                    ffTypes = s.nextLine();

                    for (int i = 0; i < cc.size(); i++) {
                        if (ffTypes.equals(cc.get(i).getcType())) {
                            System.out.print("New Flower Type:\n");
                            String ffType = s.nextLine();

                            cc.get(i).setcID(cc.get(i).getcID());
                            cc.get(i).setcType(ffType);
                            cc.get(i).setcPrice(cc.get(i).getcPrice());
                            cc.get(i).setcQuantity(cc.get(i).getcQuantity());

                        }
                    }

                    System.out.println("ID\t\t Type\t\t Price(RM)\t\t Quantity\t\t Stock");
                    System.out.println("-------------------------------------------------------------------------");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("Flower")) {

                            System.out.println(cc.get(i).getcID() + "\t\t" + cc.get(i).getcType() + "\t\t" + cc.get(i).getcPrice() + "\t\t" + cc.get(i).getcQuantity() + "\t\t" + cc.get(i).getStock());

                        }

                    }
                    CatelogMaintainance();
                    break;

                case 2:
                    System.out.print("Flower Type\t\t Quantity\n");
                    System.out.print("--------------------------------------\n");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("Flower")) {
                            System.out.println(cc.get(i).getcType() + "\t\t" + cc.get(i).getcQuantity());
                            System.out.print("\n");
                            System.out.flush();
                        }
                    }

                    System.out.println("Type in Flower Type:");
                    //s.nextLine();
                    ffTypes = s.nextLine();

                    for (int i = 0; i < cc.size(); i++) {
                        if (ffTypes.equals(cc.get(i).getcType())) {
                            System.out.print("New Quantity:\n");
                            Integer ffQuantity = s.nextInt();

                            cc.get(i).setcID(cc.get(i).getcID());
                            cc.get(i).setcType(cc.get(i).getcType());
                            cc.get(i).setcPrice(cc.get(i).getcPrice());
                            cc.get(i).setcQuantity(ffQuantity);

                        }
                    }

                    System.out.println("ID\t\t Type\t\t Price(RM)\t\t Quantity\t\t Stock");
                    System.out.println("-----------------------------------------------------------------------");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("Flower")) {

                            System.out.println(cc.get(i).getcID() + "\t\t" + cc.get(i).getcType() + "\t\t" + cc.get(i).getcPrice() + "\t\t" + cc.get(i).getcQuantity() + "\t\t" + cc.get(i).getStock());

                        }

                    }
                    CatelogMaintainance();
                    break;

                case 3:
                    System.out.print("Flower Type\t\t Price\n");
                    System.out.print("--------------------------------------\n");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("Flower")) {
                            System.out.println(cc.get(i).getcType() + "\t\t" + cc.get(i).getcPrice());
                            System.out.print("\n");
                            System.out.flush();
                        }
                    }

                    System.out.println("Type in Flower Type:");
                    //s.nextLine();
                    ffTypes = s.nextLine();

                    for (int i = 0; i < cc.size(); i++) {
                        if (ffTypes.equals(cc.get(i).getcType())) {
                            System.out.print("New Price(RM):\n");
                            Double ffPrice = s.nextDouble();

                            cc.get(i).setcID(cc.get(i).getcID());
                            cc.get(i).setcType(cc.get(i).getcType());
                            cc.get(i).setcPrice(ffPrice);
                            cc.get(i).setcQuantity(cc.get(i).getcQuantity());

                        }
                    }

                    System.out.println("ID\t\t Type\t\t Price(RM)\t\t Quantity\t\t Stock");
                    System.out.println("-------------------------------------------------------------------------------");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("Flower")) {

                            System.out.println(cc.get(i).getcID() + "\t\t" + cc.get(i).getcType() + "\t\t" + cc.get(i).getcPrice() + "\t\t" + cc.get(i).getcQuantity() + "\t\t" + cc.get(i).getStock());

                        }

                    }
                    CatelogMaintainance();

                    break;

                case 4:
                    System.out.print("Flower Type\n");
                    System.out.print("----------------------\n");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("Flower")) {
                            System.out.println(cc.get(i).getcType());
                            System.out.print("\n");
                            System.out.flush();
                        }
                    }

                    System.out.println("Type in Flower Type:");
                    //s.nextLine();
                    ffTypes = s.nextLine();

                    for (int i = 0; i < cc.size(); i++) {
                        if (ffTypes.equals(cc.get(i).getcType())) {
                            System.out.print("Are you confirm to DELETE " + "(" + ffTypes + ")" + "?[Y/N]");
                            String Answer = s.nextLine();
                            if (Answer.equals("yes")) {
                                cc.remove(i).getcType();

                            } else {
                                FM();
                            }
                        }
                    }

                    System.out.println("ID\t\t Type\t\t Price(RM)\t\t Quantity\t\t Stock");
                    System.out.println("--------------------------------------------------------------------------");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("Flower")) {

                            System.out.println(cc.get(i).getcID() + "\t\t" + cc.get(i).getcType() + "\t\t" + cc.get(i).getcPrice() + "\t\t" + cc.get(i).getcQuantity() + "\t\t" + cc.get(i).getStock());

                        }

                    }
                    CatelogMaintainance();

                    break;
                default:
                    System.out.println("Please choose between 0 to 4.");
                    break;

            }

        } while (d1 == 1);

    }

    public static void BM() {
        int c1;
        int d1 = 0;

        do {

            System.out.println("Fiora FlowerShop");
            System.out.println("------------------------------------");
            System.out.println("1. Edit Bouquet Type");
            System.out.println("2. Edit Bouquet Quantity");
            System.out.println("3. Edit Bouquet Price");
            System.out.println("4. Delete Bouquet");
            System.out.println("5. Back");
            c1 = manageSelectionError();
            flush();

            switch (c1) {

                case 1:

                    System.out.print("Bouquet Type\n");
                    System.out.print("--------------------------\n");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("Bouquet")) {
                            System.out.println(cc.get(i).getcType());
                            System.out.print("\n");
                            System.out.flush();
                        }
                    }

                    String ffTypes;
                    System.out.println("Type in Bouquet Type:");
                    //s.nextLine();
                    ffTypes = s.nextLine();

                    for (int i = 0; i < cc.size(); i++) {
                        if (ffTypes.equals(cc.get(i).getcType())) {
                            System.out.print("New Bouquet Type:\n");
                            String ffType = s.nextLine();

                            cc.get(i).setcID(cc.get(i).getcID());
                            cc.get(i).setcType(ffType);
                            cc.get(i).setcPrice(cc.get(i).getcPrice());
                            cc.get(i).setcQuantity(cc.get(i).getcQuantity());

                        }
                    }

                    System.out.println("ID\t\t Type\t\t Price(RM)\t\t Quantity\t\t Stock");
                    System.out.println("------------------------------------------------------------------------");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("Bouquet")) {

                            System.out.println(cc.get(i).getcID() + "\t\t" + cc.get(i).getcType() + "\t\t" + cc.get(i).getcPrice() + "\t\t" + cc.get(i).getcQuantity() + "\t\t" + cc.get(i).getStock());

                        }

                    }
                    CatelogMaintainance();
                    break;

                case 2:
                    System.out.print("Bouquet Type\t\t Quantity\n");
                    System.out.print("------------------------------------------\n");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("Bouquet")) {
                            System.out.println(cc.get(i).getcType() + "\t\t" + cc.get(i).getcQuantity());
                            System.out.print("\n");
                            System.out.flush();
                        }
                    }

                    System.out.println("Type in Bouquet Type:");
                    //s.nextLine();
                    ffTypes = s.nextLine();

                    for (int i = 0; i < cc.size(); i++) {
                        if (ffTypes.equals(cc.get(i).getcType())) {
                            System.out.print("New Quantity:\n");
                            Integer ffQuantity = s.nextInt();

                            cc.get(i).setcID(cc.get(i).getcID());
                            cc.get(i).setcType(cc.get(i).getcType());
                            cc.get(i).setcPrice(cc.get(i).getcPrice());
                            cc.get(i).setcQuantity(ffQuantity);

                        }
                    }

                    System.out.println("ID\t\t Type\t\t Price(RM)\t\t Quantity\t\t Stock");
                    System.out.println("-------------------------------------------------------------------------------");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("Bouquet")) {

                            System.out.println(cc.get(i).getcID() + "\t\t" + cc.get(i).getcType() + "\t\t" + cc.get(i).getcPrice() + "\t\t" + cc.get(i).getcQuantity() + "\t\t" + cc.get(i).getStock());

                        }

                    }
                    CatelogMaintainance();
                    break;

                case 3:
                    System.out.print("Bouquet Type\t\t Price\n");
                    System.out.print("--------------------------------------\n");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("Bouquet")) {
                            System.out.println(cc.get(i).getcType() + "\t\t" + cc.get(i).getcPrice());
                            System.out.print("\n");
                            System.out.flush();
                        }
                    }

                    System.out.println("Type in Bouquet Type:");
                    //s.nextLine();
                    ffTypes = s.nextLine();

                    for (int i = 0; i < cc.size(); i++) {
                        if (ffTypes.equals(cc.get(i).getcType())) {
                            System.out.print("New Price(RM):\n");
                            Double ffPrice = s.nextDouble();

                            cc.get(i).setcID(cc.get(i).getcID());
                            cc.get(i).setcType(cc.get(i).getcType());
                            cc.get(i).setcPrice(ffPrice);
                            cc.get(i).setcQuantity(cc.get(i).getcQuantity());

                        }
                    }

                    System.out.println("ID\t\t Type\t\t Price(RM)\t\t Quantity\t\t Stock");
                    System.out.println("-------------------------------------------------------------------------------");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("Bouquet")) {

                            System.out.println(cc.get(i).getcID() + "\t\t" + cc.get(i).getcType() + "\t\t" + cc.get(i).getcPrice() + "\t\t" + cc.get(i).getcQuantity() + "\t\t" + cc.get(i).getStock());

                        }

                    }
                    CatelogMaintainance();

                    break;

                case 4:
                    System.out.print("Bouquet Type\n");
                    System.out.print("------------------------\n");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("Bouquet")) {
                            System.out.println(cc.get(i).getcType());
                            System.out.print("\n");
                            System.out.flush();
                        }
                    }

                    System.out.println("Type in Bouquet Type:");
                    //s.nextLine();
                    ffTypes = s.nextLine();

                    for (int i = 0; i < cc.size(); i++) {
                        if (ffTypes.equals(cc.get(i).getcType())) {
                            System.out.print("Are you confirm to DELETE " + "(" + ffTypes + ")" + "?[Y/N]");
                            String Answer = s.nextLine();
                            if (Answer.equals("yes")) {
                                cc.remove(i).getcType();

                            } else {
                                FM();
                            }
                        }
                    }

                    System.out.println("ID\t\t Type\t\t Price(RM)\t\t Quantity\t\t Stock");
                    System.out.println("-------------------------------------------------------------------------");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("Bouquet")) {

                            System.out.println(cc.get(i).getcID() + "\t\t" + cc.get(i).getcType() + "\t\t" + cc.get(i).getcPrice() + "\t\t" + cc.get(i).getcQuantity() + "\t\t" + cc.get(i).getStock());

                        }

                    }
                    CatelogMaintainance();

                    break;
                default:
                    System.out.println("Please choose between 0 to 5.");
                    break;

            }

        } while (d1 == 1);

    }

    public static void FAM() {
        int c1;
        int d1 = 0;

        do {

            System.out.println("Fiora FlowerShop");
            System.out.println("------------------------------");
            System.out.println("1. Edit FloralArrangement Type");
            System.out.println("2. Edit FloralArrangement Quantity");
            System.out.println("3. Edit FloralArrangement Price");
            System.out.println("4. Delete FloralArrangement");
            System.out.println("5. Back");
            c1 = manageSelectionError();
            flush();

            switch (c1) {

                case 1:

                    System.out.print("FloralArrangement Type\n");
                    System.out.print("------------------------------------------\n");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("FloralArrangement")) {
                            System.out.println(cc.get(i).getcType());
                            System.out.print("\n");
                            System.out.flush();
                        }
                    }

                    String ffTypes;
                    System.out.println("Type in FloralArrangement Type:");
                    //s.nextLine();
                    ffTypes = s.nextLine();

                    for (int i = 0; i < cc.size(); i++) {
                        if (ffTypes.equals(cc.get(i).getcType())) {
                            System.out.print("New FloralArrangement Type:\n");
                            String ffType = s.nextLine();

                            cc.get(i).setcID(cc.get(i).getcID());
                            cc.get(i).setcType(ffType);
                            cc.get(i).setcPrice(cc.get(i).getcPrice());
                            cc.get(i).setcQuantity(cc.get(i).getcQuantity());

                        }
                    }

                    System.out.println("ID\t\t Type\t\t Price(RM)\t\t Quantity\t\t Stock");
                    System.out.println("----------------------------------------------------------------------------------");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("FloralArrangement")) {

                            System.out.println(cc.get(i).getcID() + "\t\t" + cc.get(i).getcType() + "\t\t" + cc.get(i).getcPrice() + "\t\t" + cc.get(i).getcQuantity() + "\t\t" + cc.get(i).getStock());

                        }

                    }
                    CatelogMaintainance();
                    break;

                case 2:
                    System.out.print("FloralArrangement Type\t\t Quantity\n");
                    System.out.print("-------------------------------------------------------\n");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("FloralArrangement")) {
                            System.out.println(cc.get(i).getcType() + "\t\t" + cc.get(i).getcQuantity());
                            System.out.print("\n");
                            System.out.flush();
                        }
                    }

                    System.out.println("Type in FloralArrangement Type:");
                    //s.nextLine();
                    ffTypes = s.nextLine();

                    for (int i = 0; i < cc.size(); i++) {
                        if (ffTypes.equals(cc.get(i).getcType())) {
                            System.out.print("New Quantity:\n");
                            Integer ffQuantity = s.nextInt();

                            cc.get(i).setcID(cc.get(i).getcID());
                            cc.get(i).setcType(cc.get(i).getcType());
                            cc.get(i).setcPrice(cc.get(i).getcPrice());
                            cc.get(i).setcQuantity(ffQuantity);

                        }
                    }

                    System.out.println("ID\t\t Type\t\t Price(RM)\t\t Quantity\t\t Stock");
                    System.out.println("-------------------------------------------------------------------------");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("FloralArrangement")) {

                            System.out.println(cc.get(i).getcID() + "\t\t" + cc.get(i).getcType() + "\t\t" + cc.get(i).getcPrice() + "\t\t" + cc.get(i).getcQuantity() + "\t\t" + cc.get(i).getStock());

                        }

                    }
                    CatelogMaintainance();
                    break;

                case 3:
                    System.out.print("FloralArrangement Type\t\t Price\n");
                    System.out.print("------------------------------------------------\n");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("FloralArrangement")) {
                            System.out.println(cc.get(i).getcType() + "\t\t" + cc.get(i).getcPrice());
                            System.out.print("\n");
                            System.out.flush();
                        }
                    }

                    System.out.println("Type in FloralArrangement Type:");
                    //s.nextLine();
                    ffTypes = s.nextLine();

                    for (int i = 0; i < cc.size(); i++) {
                        if (ffTypes.equals(cc.get(i).getcType())) {
                            System.out.print("New Price(RM):\n");
                            Double ffPrice = s.nextDouble();

                            cc.get(i).setcID(cc.get(i).getcID());
                            cc.get(i).setcType(cc.get(i).getcType());
                            cc.get(i).setcPrice(ffPrice);
                            cc.get(i).setcQuantity(cc.get(i).getcQuantity());

                        }
                    }

                    System.out.println("ID\t\t Type\t\t Price(RM)\t\t Quantity\t\t Stock");
                    System.out.println("------------------------------------------------------------------");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("FloralArrangement")) {

                            System.out.println(cc.get(i).getcID() + "\t\t" + cc.get(i).getcType() + "\t\t" + cc.get(i).getcPrice() + "\t\t" + cc.get(i).getcQuantity() + "\t\t" + cc.get(i).getStock());

                        }

                    }
                    CatelogMaintainance();

                    break;

                case 4:
                    System.out.print("FloralArrangement Type\n");
                    System.out.print("---------------------------------\n");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("FloralArrangement")) {
                            System.out.println(cc.get(i).getcType());
                            System.out.print("\n");
                            System.out.flush();
                        }
                    }

                    System.out.println("Type in FloralArrangement Type:");
                    //s.nextLine();
                    ffTypes = s.nextLine();

                    for (int i = 0; i < cc.size(); i++) {
                        if (ffTypes.equals(cc.get(i).getcType())) {
                            System.out.print("Are you confirm to DELETE " + "(" + ffTypes + ")" + "?[Y/N]");
                            String Answer = s.nextLine();
                            if (Answer.equals("yes")) {
                                cc.remove(i).getcType();

                            } else {
                                FM();
                            }
                        }
                    }

                    System.out.println("ID\t\t Type\t\t Price(RM)\t\t Quantity\t\t Stock");
                    System.out.println("---------------------------------------------------------------------");

                    for (int i = 0; i < cc.size(); i++) {
                        if (cc.get(i).getCategory().equals("FloralArrangement")) {

                            System.out.println(cc.get(i).getcID() + "\t\t" + cc.get(i).getcType() + "\t\t" + cc.get(i).getcPrice() + "\t\t" + cc.get(i).getcQuantity() + "\t\t" + cc.get(i).getStock());

                        }

                    }
                    CatelogMaintainance();

                    break;
                default:
                    System.out.println("Please choose between 0 to 5.");
                    break;

            }

        } while (d1 == 1);

    }

      public static void startOrder() {

        Scanner sc = new Scanner(System.in);
        String choice;

        for (int i = 0; i < cust.size(); i++) {

            if (CustId.equals(cust.get(i).getCustId()) && "Cooperate".equals(cust.get(i).getCustomerType()) && cust.get(i).getCreditLimit().equals("0")) {

                System.out.print("Sorry, you have exceed your credit limit.\n");
                System.out.print("Please enter y to go back menu : ");
                choice = sc.next();

                while (!"y".equals(choice)) {
                    System.out.print("Please type y :");
                    choice = sc.next();
                }
                if (choice.equals("y")) {
                    CustMenu();
                }
            } else {
                orderMenu();
            }
        }

    }

    public static void orderMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n1. Fresh Flower\n");
        System.out.print("2. Bouquets\n");
        System.out.print("3. Floral Management\n");
        System.out.print("Please select 1-3: ");

        while (!sc.hasNextInt()) {
            System.out.print("Please reenter again (1,2 or 3):");
            sc.next();
        }
        int select = sc.nextInt();

        if (select == 1) {
            orderflower();
        } else if (select == 2) {
            orderbouquet();
        } else if (select == 3) {
            orderfloral();
        } else {
            System.out.print("Please choose 1,2 or 3.\n");
        }
    }

    public static void orderbouquet() {

        // List<Category> cc = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String select;
        String choice;

        String methodType = null;

        String date;
        String address;
        double price = 0;
        double totalPrice = 0;

        String orderId = "O";
        //String name;

        do {
            System.out.println("ID\t  Type\t\t Price(RM)\t Quantity\tStock ");
            System.out.println("----------------------------------------------------------------");
            for (int i = 0; i < cc.size(); i++) {
                if (cc.get(i).getcQuantity() > 0 && cc.get(i).getCategory().equals("Bouquet")) {
                    System.out.println(cc.get(i).getcID() + "\t  " + cc.get(i).getcType() + "\t\t  " + cc.get(i).getcPrice() + "\t\t  " + cc.get(i).getcQuantity() + "\t\t" + cc.get(i).getStock());
                }
            }

            System.out.print("\nPlease enter the id: ");

            String cID = sc.next();

            System.out.print("\nPlease enter the quantity: ");
            while (!sc.hasNextInt()) {
                System.out.print("It is not an integer,please reenter again:");
                sc.next();
            }
            int quantity = sc.nextInt();

           
            for (int i = 0; i < cc.size(); i++) {
                if ((cID).equals(cc.get(i).getcID())) {

                    int total = (cc.get(i).getcQuantity()) - quantity;
                    
                    if (quantity > cc.get(i).getcQuantity()) {
                            System.out.println("Sorry, stock is not enough.");
                            System.out.print("Please enter again:");
                            quantity = sc.nextInt();
                        
                        while (quantity > cc.get(i).getcQuantity()) {
                            System.out.println("Sorry, stock is not enough.");
                            System.out.print("Please enter again: ");
                            quantity = sc.nextInt();
                        }
                    }
                    cc.get(i).setcID(cc.get(i).getcID());
                    cc.get(i).setcType(cc.get(i).getcType());
                    cc.get(i).setcQuantity((total));
                    cc.get(i).setcPrice(cc.get(i).getcPrice());
                    cc.get(i).setStock(cc.get(i).getStock());

                    price = cc.get(i).getcPrice() * quantity;
                    // totalPrice += price;
                }
            }
            double credit = 0;
            for (int i = 0; i < cust.size(); i++) {
                if (CustId.equals(cust.get(i).getCustId()) && "Cooperate".equals(cust.get(i).getCustomerType())) {
                    credit = (Double.parseDouble(cust.get(i).getCreditLimit()) - price);
                    cust.get(i).setCreditLimit(String.valueOf(credit));
                    credit = Double.parseDouble(cust.get(i).getCreditLimit());

                    if (credit <= 0) {
                        System.out.print("Sorry, you have exceed your credit limit.");

                        System.out.print("\nPlease enter y to go back menu : ");
                        select = sc.next();

                        if (select.equals("y")) {
                            CustMenu();
                        }
                        while (!"y".equals(select)) {

                            System.out.print("Please type y:");
                            select = sc.next();
                        }

                    }
                }
            }


            System.out.print("Please enter pick up method      : ");
            System.out.print("\n(1 = self pick-up / 2 = delivery) ");

            while (!sc.hasNextInt()) {
                System.out.print("Invalid input, Please try again : ");
                sc.next();

            }
            int method = sc.nextInt();

            if (method == 1) {
                methodType = "Self Pick-up";

            } else if (method == 2) {
                methodType = "Delivery";
                System.out.print("\nPlease enter pick-up address: ");
                sc.nextLine();
            } else {

                System.out.print("\nInvalid input ");
            }

            address = sc.nextLine();

            System.out.print("\nPlease enter pick-up date (DD/MM/YY): ");
            date = sc.next();

            System.out.print("\nDo you want to continue order?(y = yes, n = no):");

            choice = sc.next();

            while (!"n".equals(choice) && !"y".equals(choice)) {
                System.out.print("Please type y or n:");
                choice = sc.next();
            }

            System.out.print("\nOrder Summary Details\n");
            System.out.print("------------------------\n");
            System.out.print(" Id: " + cID);
            System.out.println("\nQuantity: " + quantity);

        } while (!"n".equals(choice));

        System.out.println("\nTotal price: " + price);

        System.out.println("\nPick up method: " + methodType);

        System.out.println("\nPick up date: " + date);
        if (methodType.equals("Delivery")) {
            System.out.println("\nPick up address: " + address);
        }

          if (order.isEmpty()) {
            orderId += String.format("%02d", order.size() + 1);
        } else {
            int lastEidNumber = Integer.parseInt(order.get(order.size() - 1).getOrderId().substring(1));
            orderId = "O" + String.format("%02d", lastEidNumber + 1);
        }

        order.add(new Order(orderId, "Lucas", date, methodType, "   Pending", "    Pending", String.valueOf(price),address));

        System.out.println("\nThank you, please come again.");

        CustMenu();
       
    }

     public static void orderflower() {

        // List<Category> cc = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String select;
        String choice;

        String methodType = null;

        String date;
        String address;
        double price = 0;
        double totalPrice = 0;

        String orderId = "O";
        //String name;

        do {
            System.out.println("ID\t  Type\t\t Price(RM)\t Quantity\tStock ");
            System.out.println("----------------------------------------------------------------");
            for (int i = 0; i < cc.size(); i++) {
                if (cc.get(i).getcQuantity() > 0 && cc.get(i).getCategory().equals("Flower")) {
                    System.out.println(cc.get(i).getcID() + "\t  " + cc.get(i).getcType() + "\t\t  " + cc.get(i).getcPrice() + "\t\t  " + cc.get(i).getcQuantity() + "\t\t" + cc.get(i).getStock());
                }
            }

            System.out.print("\nPlease enter the id: ");

            String cID = sc.next();

            System.out.print("\nPlease enter the quantity: ");
            while (!sc.hasNextInt()) {
                System.out.print("It is not an integer,please reenter again:");
                sc.next();
            }
            int quantity = sc.nextInt();

           
            for (int i = 0; i < cc.size(); i++) {
                if ((cID).equals(cc.get(i).getcID())) {

                    int total = (cc.get(i).getcQuantity()) - quantity;
                    
                    if (quantity > cc.get(i).getcQuantity()) {
                            System.out.println("Sorry, stock is not enough.");
                            System.out.print("Please enter again:");
                            quantity = sc.nextInt();
                        
                        while (quantity > cc.get(i).getcQuantity()) {
                            System.out.println("Sorry, stock is not enough.");
                            System.out.print("Please enter again: ");
                            quantity = sc.nextInt();
                        }
                    }
                    cc.get(i).setcID(cc.get(i).getcID());
                    cc.get(i).setcType(cc.get(i).getcType());
                    cc.get(i).setcQuantity((total));
                    cc.get(i).setcPrice(cc.get(i).getcPrice());
                    cc.get(i).setStock(cc.get(i).getStock());

                    price = cc.get(i).getcPrice() * quantity;
                    // totalPrice += price;
                }
            }
            double credit = 0;
            for (int i = 0; i < cust.size(); i++) {
                if (CustId.equals(cust.get(i).getCustId()) && "Cooperate".equals(cust.get(i).getCustomerType())) {
                    credit = (Double.parseDouble(cust.get(i).getCreditLimit()) - price);
                    cust.get(i).setCreditLimit(String.valueOf(credit));
                    credit = Double.parseDouble(cust.get(i).getCreditLimit());

                    if (credit <= 0) {
                        System.out.print("Sorry, you have exceed your credit limit.");

                        System.out.print("\nPlease enter y to go back menu : ");
                        select = sc.next();

                        if (select.equals("y")) {
                            CustMenu();
                        }
                        while (!"y".equals(select)) {

                            System.out.print("Please type y:");
                            select = sc.next();
                        }

                    }
                }
            }


            System.out.print("Please enter pick up method      : ");
            System.out.print("\n(1 = self pick-up / 2 = delivery) ");

            while (!sc.hasNextInt()) {
                System.out.print("Invalid input, Please try again : ");
                sc.next();

            }
            int method = sc.nextInt();

            if (method == 1) {
                methodType = "Self Pick-up";

            } else if (method == 2) {
                methodType = "Delivery";
                System.out.print("\nPlease enter pick-up address: ");
                sc.nextLine();
            } else {

                System.out.print("\nInvalid input ");
            }

            address = sc.nextLine();

            System.out.print("\nPlease enter pick-up date (DD/MM/YY): ");
            date = sc.next();

            System.out.print("\nDo you want to continue order?(y = yes, n = no):");

            choice = sc.next();

            while (!"n".equals(choice) && !"y".equals(choice)) {
                System.out.print("Please type y or n:");
                choice = sc.next();
            }

            System.out.print("\nOrder Summary Details\n");
            System.out.print("------------------------\n");
            System.out.print(" Id: " + cID);
            System.out.println("\nQuantity: " + quantity);

        } while (!"n".equals(choice));

        System.out.println("\nTotal price: " + price);

        System.out.println("\nPick up method: " + methodType);

        System.out.println("\nPick up date: " + date);
        if (methodType.equals("Delivery")) {
            System.out.println("\nPick up address: " + address);
        }

          if (order.isEmpty()) {
            orderId += String.format("%02d", order.size() + 1);
        } else {
            int lastEidNumber = Integer.parseInt(order.get(order.size() - 1).getOrderId().substring(1));
            orderId = "O" + String.format("%02d", lastEidNumber + 1);
        }

        order.add(new Order(orderId, "Lucas", date, methodType, "   Pending", "    Pending", String.valueOf(price),address));

        System.out.println("\nThank you, please come again.");

        CustMenu();
        
    }

     public static void orderfloral() {

        // List<Category> cc = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String select;
        String choice;

        String methodType = null;

        String date;
        String address;
        double price = 0;
        double totalPrice = 0;

        String orderId = "O";
        //String name;

        do {
             System.out.println("ID\t  Type\t\t Price(RM)\t Quantity\tStock ");
            System.out.println("----------------------------------------------------------------");
            for (int i = 0; i < cc.size(); i++) {
                if (cc.get(i).getcQuantity() > 0 && cc.get(i).getCategory().equals("FloralArrangement")) {
                    System.out.println(cc.get(i).getcID() + "\t  " + cc.get(i).getcType() + "\t\t  " + cc.get(i).getcPrice() + "\t\t  " + cc.get(i).getcQuantity() + "\t\t" + cc.get(i).getStock());
                }
            }

            System.out.print("\nPlease enter the id: ");

            String cID = sc.next();

            System.out.print("\nPlease enter the quantity: ");
            while (!sc.hasNextInt()) {
                System.out.print("It is not an integer,please reenter again:");
                sc.next();
            }
            int quantity = sc.nextInt();

           
            for (int i = 0; i < cc.size(); i++) {
                if ((cID).equals(cc.get(i).getcID())) {

                    int total = (cc.get(i).getcQuantity()) - quantity;
                    
                    if (quantity > cc.get(i).getcQuantity()) {
                            System.out.println("Sorry, stock is not enough.");
                            System.out.print("Please enter again:");
                            quantity = sc.nextInt();
                        
                        while (quantity > cc.get(i).getcQuantity()) {
                            System.out.println("Sorry, stock is not enough.");
                            System.out.print("Please enter again: ");
                            quantity = sc.nextInt();
                        }
                    }
                    cc.get(i).setcID(cc.get(i).getcID());
                    cc.get(i).setcType(cc.get(i).getcType());
                    cc.get(i).setcQuantity((total));
                    cc.get(i).setcPrice(cc.get(i).getcPrice());
                    cc.get(i).setStock(cc.get(i).getStock());

                    price = cc.get(i).getcPrice() * quantity;
                    // totalPrice += price;
                }
            }
            double credit = 0;
            for (int i = 0; i < cust.size(); i++) {
                if (CustId.equals(cust.get(i).getCustId()) && "Cooperate".equals(cust.get(i).getCustomerType())) {
                    credit = (Double.parseDouble(cust.get(i).getCreditLimit()) - price);
                    cust.get(i).setCreditLimit(String.valueOf(credit));
                    credit = Double.parseDouble(cust.get(i).getCreditLimit());

                    if (credit <= 0) {
                        System.out.print("Sorry, you have exceed your credit limit.");

                        System.out.print("\nPlease enter y to go back menu : ");
                        select = sc.next();

                        if (select.equals("y")) {
                            CustMenu();
                        }
                        while (!"y".equals(select)) {

                            System.out.print("Please type y:");
                            select = sc.next();
                        }

                    }
                }
            }


            System.out.print("Please enter pick up method      : ");
            System.out.print("\n(1 = self pick-up / 2 = delivery) ");

            while (!sc.hasNextInt()) {
                System.out.print("Invalid input, Please try again : ");
                sc.next();

            }
            int method = sc.nextInt();

            if (method == 1) {
                methodType = "Self Pick-up";

            } else if (method == 2) {
                methodType = "Delivery";
                System.out.print("\nPlease enter pick-up address: ");
                sc.nextLine();
            } else {

                System.out.print("\nInvalid input ");
            }

            address = sc.nextLine();

            System.out.print("\nPlease enter pick-up date (DD/MM/YY): ");
            date = sc.next();

            System.out.print("\nDo you want to continue order?(y = yes, n = no):");

            choice = sc.next();

            while (!"n".equals(choice) && !"y".equals(choice)) {
                System.out.print("Please type y or n:");
                choice = sc.next();
            }

            System.out.print("\nOrder Summary Details\n");
            System.out.print("------------------------\n");
            System.out.print(" Id: " + cID);
            System.out.println("\nQuantity: " + quantity);

        } while (!"n".equals(choice));

        System.out.println("\nTotal price: " + price);

        System.out.println("\nPick up method: " + methodType);

        System.out.println("\nPick up date: " + date);
        if (methodType.equals("Delivery")) {
            System.out.println("\nPick up address: " + address);
        }

          if (order.isEmpty()) {
            orderId += String.format("%02d", order.size() + 1);
        } else {
            int lastEidNumber = Integer.parseInt(order.get(order.size() - 1).getOrderId().substring(1));
            orderId = "O" + String.format("%02d", lastEidNumber + 1);
        }

        order.add(new Order(orderId, "Lucas", date, methodType, "   Pending", "    Pending", String.valueOf(price),address));

        System.out.println("\nThank you, please come again.");

        CustMenu();
      
    }


    public static void recordTimestamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String choice;
        String choose;
        boolean valid = false;

        do {
            System.out.println("No\t Name\t Date(DD/MM/YYYY)  Pick-up Status  Price(RM)\tPayment Status\tTimestamp");
            System.out.println("-------------------------------------------------------------------------------------------");
            for (int i = 0; i < order.size(); i++) {
                if (order.get(i).getPickUpStatus().equals("Self Pick-up") && order.get(i).getDate().equals(formatter.format(date))) {
                    System.out.println(order.get(i).getOrderId() + "\t " + order.get(i).getName() + "\t   " + order.get(i).getDate() + "\t   " + order.get(i).getPickUpStatus() + "\t      " + order.get(i).getPrice() + "  \t  " + order.get(i).getPaymentStatus() + "\t" + order.get(i).getTimestamp());
                }
            }
            int p = 0;
            do {

                System.out.print("\nWhich customer had pick-up their order ?: ");

                //            if (input.hasNextInt()) {
                //                choice = input.nextInt();
                choice = s.next();

                for (int i = 0; i < order.size(); i++) {
                    if (choice.equals(order.get(i).getOrderId())) {
                        valid = true;
                        torder = choice;
                    }
                }
                if (valid == false) {
                    System.out.print("Please enter number that only have at the list: ");
                    //p++;
                } else {
                    for (int i = 0; i < order.size(); i++) {
                        if (torder.equals(order.get(i).getOrderId())) {
                            order.get(i).setOrderId(order.get(i).getOrderId());
                            order.get(i).setName(order.get(i).getName());
                            order.get(i).setDate(order.get(i).getDate());
                            order.get(i).setPickUpStatus(order.get(i).getPickUpStatus());
                            order.get(i).setPaymentStatus("Complete");
                            order.get(i).setTimestamp(sdf.format(timestamp));
                            break;
                        }
                    }

                }
            } while (valid == false);

            System.out.println("No\t Name\t Date(DD/MM/YYYY)  Pick-up Status  Price(RM)\tPayment Status\tTimestamp");
            System.out.println("-------------------------------------------------------------------------------------------");
            for (int i = 0; i < order.size(); i++) {
                if (order.get(i).getPickUpStatus().equals("Self Pick-up") && order.get(i).getDate().equals(formatter.format(date))) {
                    System.out.println(order.get(i).getOrderId() + "\t " + order.get(i).getName() + "\t   " + order.get(i).getDate() + "\t   " + order.get(i).getPickUpStatus() + "\t      " + order.get(i).getPrice() + "  \t  " + order.get(i).getPaymentStatus() + "\t" + order.get(i).getTimestamp());
                }
            }
            System.out.print("\nAre you want continue to modify the status ?(y/n): ");
            choose = s.next();

            while (!choose.equals("y") && !choose.equals("n")) {
                System.out.print("\nPlease selct y or n only: ");
                choose = s.next();
            }

        } while (!choose.equals("n"));

    }

    public static void displayOrder() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        System.out.println("No\t Name\t Date(DD/MM/YYYY)  Pick-up Status  Price(RM)\tPayment Status\tTimestamp");
        System.out.println("-------------------------------------------------------------------------------------------");
        for (int i = 0; i < order.size(); i++) {
            if (order.get(i).getDate().equals(formatter.format(date))) {
                System.out.println(order.get(i).getOrderId() + "\t " + order.get(i).getName() + "\t   " + order.get(i).getDate() + "\t   " + order.get(i).getPickUpStatus() + "\t      " + order.get(i).getPrice() + "  \t  " + order.get(i).getPaymentStatus() + "\t" + order.get(i).getTimestamp());
            }
        }
    }

    public static void manageConsumerPayment() {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String choice;
        String choose;
        boolean valid = false;

        do {
            System.out.println("No\t Name\t Date(DD/MM/YYYY)  Pick-up Status  Price(RM)\tPayment Status\t\tTimestamp\tAddress");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < order.size(); i++) {
                if (order.get(i).getPickUpStatus().equals("Delivery") && order.get(i).getDate().equals(formatter.format(date)) && order.get(i).getAddress().equals("Gombak")) {
                    System.out.println(order.get(i).getOrderId() + "\t " + order.get(i).getName() + "\t   " + order.get(i).getDate() + "\t   " + order.get(i).getPickUpStatus() + "\t      " + order.get(i).getPrice() + "  \t  " + order.get(i).getPaymentStatus() + "\t" + order.get(i).getTimestamp() + "\t" + order.get(i).getAddress());
                }
            }

            for (int i = 0; i < order.size(); i++) {
                if (order.get(i).getPickUpStatus().equals("Delivery") && order.get(i).getDate().equals(formatter.format(date)) && order.get(i).getAddress().equals("Genting Klang")) {
                    System.out.println(order.get(i).getOrderId() + "\t " + order.get(i).getName() + "\t   " + order.get(i).getDate() + "\t   " + order.get(i).getPickUpStatus() + "\t      " + order.get(i).getPrice() + "  \t  " + order.get(i).getPaymentStatus() + "\t" + order.get(i).getTimestamp() + "\t" + order.get(i).getAddress());
                }
            }

            for (int i = 0; i < order.size(); i++) {
                if (order.get(i).getPickUpStatus().equals("Delivery") && order.get(i).getDate().equals(formatter.format(date)) && order.get(i).getAddress().equals("Wangsa Maju")) {
                    System.out.println(order.get(i).getOrderId() + "\t " + order.get(i).getName() + "\t   " + order.get(i).getDate() + "\t   " + order.get(i).getPickUpStatus() + "\t      " + order.get(i).getPrice() + "  \t  " + order.get(i).getPaymentStatus() + "\t" + order.get(i).getTimestamp() + "\t" + order.get(i).getAddress());
                }
            }

            for (int i = 0; i < order.size(); i++) {
                if (order.get(i).getPickUpStatus().equals("Delivery") && order.get(i).getDate().equals(formatter.format(date)) && order.get(i).getAddress().equals("Petaling Jaya")) {
                    System.out.println(order.get(i).getOrderId() + "\t " + order.get(i).getName() + "\t   " + order.get(i).getDate() + "\t   " + order.get(i).getPickUpStatus() + "\t      " + order.get(i).getPrice() + "  \t  " + order.get(i).getPaymentStatus() + "\t" + order.get(i).getTimestamp() + "\t" + order.get(i).getAddress());
                }
            }
            int p = 0;
            do {

                System.out.print("\nWhich customer had paid their order ?: ");
                choice = s.next();

                for (int i = 0; i < order.size(); i++) {
                    if (choice.equals(order.get(i).getOrderId())) {
                        valid = true;
                        torder = choice;
                    }
                }
                if (valid == false) {
                    System.out.print("Please enter number that only have at the list: ");
                    //p++;
                } else {
                    for (int i = 0; i < order.size(); i++) {
                        if (torder.equals(order.get(i).getOrderId())) {
                            order.get(i).setOrderId(order.get(i).getOrderId());
                            order.get(i).setName(order.get(i).getName());
                            order.get(i).setDate(order.get(i).getDate());
                            order.get(i).setPickUpStatus(order.get(i).getPickUpStatus());
                            order.get(i).setPaymentStatus("Complete");
                            order.get(i).setTimestamp(sdf.format(timestamp));
                            break;
                        }
                    }

                }
            } while (valid == false);

            System.out.println("No\t Name\t Date(DD/MM/YYYY)  Pick-up Status  Price(RM)\tPayment Status\t\tTimestamp\tAddress");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < order.size(); i++) {
                if (order.get(i).getPickUpStatus().equals("Delivery") && order.get(i).getDate().equals(formatter.format(date)) && order.get(i).getAddress().equals("Gombak")) {
                    System.out.println(order.get(i).getOrderId() + "\t " + order.get(i).getName() + "\t   " + order.get(i).getDate() + "\t   " + order.get(i).getPickUpStatus() + "\t      " + order.get(i).getPrice() + "  \t  " + order.get(i).getPaymentStatus() + "\t" + order.get(i).getTimestamp() + "\t" + order.get(i).getAddress());
                }
            }

            for (int i = 0; i < order.size(); i++) {
                if (order.get(i).getPickUpStatus().equals("Delivery") && order.get(i).getDate().equals(formatter.format(date)) && order.get(i).getAddress().equals("Genting Klang")) {
                    System.out.println(order.get(i).getOrderId() + "\t " + order.get(i).getName() + "\t   " + order.get(i).getDate() + "\t   " + order.get(i).getPickUpStatus() + "\t      " + order.get(i).getPrice() + "  \t  " + order.get(i).getPaymentStatus() + "\t" + order.get(i).getTimestamp() + "\t" + order.get(i).getAddress());
                }
            }

            for (int i = 0; i < order.size(); i++) {
                if (order.get(i).getPickUpStatus().equals("Delivery") && order.get(i).getDate().equals(formatter.format(date)) && order.get(i).getAddress().equals("Wangsa Maju")) {
                    System.out.println(order.get(i).getOrderId() + "\t " + order.get(i).getName() + "\t   " + order.get(i).getDate() + "\t   " + order.get(i).getPickUpStatus() + "\t      " + order.get(i).getPrice() + "  \t  " + order.get(i).getPaymentStatus() + "\t" + order.get(i).getTimestamp() + "\t" + order.get(i).getAddress());
                }
            }

            for (int i = 0; i < order.size(); i++) {
                if (order.get(i).getPickUpStatus().equals("Delivery") && order.get(i).getDate().equals(formatter.format(date)) && order.get(i).getAddress().equals("Petaling Jaya")) {
                    System.out.println(order.get(i).getOrderId() + "\t " + order.get(i).getName() + "\t   " + order.get(i).getDate() + "\t   " + order.get(i).getPickUpStatus() + "\t      " + order.get(i).getPrice() + "  \t  " + order.get(i).getPaymentStatus() + "\t" + order.get(i).getTimestamp() + "\t" + order.get(i).getAddress());
                }
            }

            System.out.print("\nAre you want continue to modify the status ?(y/n): ");
            choose = s.next();

            while (!choose.equals("y") && !choose.equals("n")) {
                System.out.print("\nPlease selct y or n only: ");
                choose = s.next();
            }

        } while (!choose.equals("n"));
    }

    public static void displayDeliveryRoute() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        System.out.println("No\t Name\t Date(DD/MM/YYYY)  Pick-up Status  Price(RM)\tPayment Status\t\tTimestamp\tAddress");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < order.size(); i++) {
            if (order.get(i).getPickUpStatus().equals("Delivery") && order.get(i).getDate().equals(formatter.format(date)) && order.get(i).getAddress().equals("Gombak")) {
                System.out.println(order.get(i).getOrderId() + "\t " + order.get(i).getName() + "\t   " + order.get(i).getDate() + "\t   " + order.get(i).getPickUpStatus() + "\t      " + order.get(i).getPrice() + "  \t  " + order.get(i).getPaymentStatus() + "\t" + order.get(i).getTimestamp() + "\t" + order.get(i).getAddress());
            }
        }

        for (int i = 0; i < order.size(); i++) {
            if (order.get(i).getPickUpStatus().equals("Delivery") && order.get(i).getDate().equals(formatter.format(date)) && order.get(i).getAddress().equals("Genting Klang")) {
                System.out.println(order.get(i).getOrderId() + "\t " + order.get(i).getName() + "\t   " + order.get(i).getDate() + "\t   " + order.get(i).getPickUpStatus() + "\t      " + order.get(i).getPrice() + "  \t  " + order.get(i).getPaymentStatus() + "\t" + order.get(i).getTimestamp() + "\t" + order.get(i).getAddress());
            }
        }

        for (int i = 0; i < order.size(); i++) {
            if (order.get(i).getPickUpStatus().equals("Delivery") && order.get(i).getDate().equals(formatter.format(date)) && order.get(i).getAddress().equals("Wangsa Maju")) {
                System.out.println(order.get(i).getOrderId() + "\t " + order.get(i).getName() + "\t   " + order.get(i).getDate() + "\t   " + order.get(i).getPickUpStatus() + "\t      " + order.get(i).getPrice() + "  \t  " + order.get(i).getPaymentStatus() + "\t" + order.get(i).getTimestamp() + "\t" + order.get(i).getAddress());
            }
        }

        for (int i = 0; i < order.size(); i++) {
            if (order.get(i).getPickUpStatus().equals("Delivery") && order.get(i).getDate().equals(formatter.format(date)) && order.get(i).getAddress().equals("Petaling Jaya")) {
                System.out.println(order.get(i).getOrderId() + "\t " + order.get(i).getName() + "\t   " + order.get(i).getDate() + "\t   " + order.get(i).getPickUpStatus() + "\t      " + order.get(i).getPrice() + "  \t  " + order.get(i).getPaymentStatus() + "\t" + order.get(i).getTimestamp() + "\t" + order.get(i).getAddress());
            }
        }
    }

}