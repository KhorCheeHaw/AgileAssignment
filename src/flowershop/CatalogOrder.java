/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowershop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Kelly
 */
public class CatalogOrder {

    /**
     * @param args the command line arguments
     */
    static List<Category> cc = new ArrayList<>();
    static List<Order> order = new ArrayList<Order>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        cc.add(new Category("Flower", "F01", "Rose", 10, 10.50, "High"));
        cc.add(new Category("Bouquet", "B01", "Posy", 3, 10.50, "Finish"));
        cc.add(new Category("FloralArrangement", "FA01", "Oval", 3, 10.50, "Low"));
        Scanner sc = new Scanner(System.in);
//        System.out.print("Please enter order id: ");
//        while (!sc.hasNextInt()) {
//            System.out.print("Please type again (eg:1001):");
//            sc.next();
//            int orderId = sc.nextInt();
      //  }

        menu();

    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n1. Fresh Flower\n");
        System.out.print("2. Bouquets\n");
        System.out.print("3. Floral Management\n");
        System.out.print("Please select : ");

        int select = sc.nextInt();

        if (select == 1) {
            flower();
        } else if (select == 2) {
            bouquet();
        } else if (select == 3) {
            floral();
        } else {
            System.out.print("Please choose 1,2 or 3.\n");
            menu();
        }

    }

    public static void bouquet() {

        // List<Category> cc = new ArrayList<>();
        String choice;
        String pickMethod;
        double price;
        double totalPrice = 0;
         System.out.print("Please enter order id: ");
         
        while (!sc.hasNextInt()) {
            System.out.print("Please type again (eg:1001):");
            sc.nextInt();
            
        }
        int orderId = sc.nextInt();
        
//
//        cc.add(new Category("Flower", "F01", "Rose", 10, 10.50, "High"));
//        cc.add(new Category("Bouquet", "B01", "Posy", 0, 10.50, "Finish"));
//        cc.add(new Category("FloralArrangement", "FA01", "Oval", 3, 10.50, "Low"));

        do {

            System.out.println("ID\t\t Type\t\t Price(RM)\t\t Quantity\t\tStock ");
            System.out.println("--------------------------------------");
            for (int i = 0; i < cc.size(); i++) {
                if (cc.get(i).getcQuantity() > 0 && cc.get(i).getCategory().equals("Bouquet")) {
                    System.out.println(cc.get(i).getcID() + "\t " + cc.get(i).getcType() + "\t\t " + cc.get(i).getcPrice() + "\t   " + cc.get(i).getcQuantity() + "\t   " + cc.get(i).getStock());
                }
            }

            Scanner sc = new Scanner(System.in);

            System.out.print("\nPlease enter the id of bouquet: ");
            while (!sc.hasNext()) {
                System.out.print("Please reenter again (eg:FA01):");
                sc.next();
            }
            String cID = sc.next();

            System.out.print("\nPlease enter the quantity of flower: ");
            while (!sc.hasNextInt()) {
                System.out.print("It is not an integer,please reenter again:");
                sc.next();
            }
            int quantity = sc.nextInt();

            for (int i = 0; i < cc.size(); i++) {
                if ((cID).equals(cc.get(i).getcID())) {

                    int total = (cc.get(i).getcQuantity()) - quantity;
                    cc.get(i).setcID(cc.get(i).getcID());
                    cc.get(i).setcType(cc.get(i).getcType());
                    cc.get(i).setcQuantity((total));
                    cc.get(i).setcPrice(cc.get(i).getcPrice());
                    cc.get(i).setStock(cc.get(i).getStock());

                    price = cc.get(i).getcPrice() * quantity;
                    totalPrice += price;
                }
            }

            System.out.print("Please enter pick up method      : ");
            System.out.print("\n(sp = self pick-up / d = delivery) ");
            pickMethod = sc.next();

            System.out.print("\nDo you want to continue order?(y = yes, n = no):");
            choice = sc.next();

            while (!"n".equals(choice) && !"y".equals(choice)) {
                System.out.print("Please type y or n:");
                choice = sc.next();
            }

            System.out.print("\nYou have chosen\n");
            System.out.print("-----------------\n");
            System.out.print(" Id: " + cID);
            System.out.println("\nQuantity: " + quantity);
        } while (!"n".equals(choice));
        System.out.println("\nTotal price: " + totalPrice);

        System.out.println("\nPick up method: " + pickMethod);

        System.out.println("\nThank you, please come again.");
        
         order.add(new Order(orderId, "Julius", "29/11/2018", pickMethod, "   Pending", "    Pending", String.valueOf(totalPrice)));
     
         System.out.println("No\t Name\t Date(DD/MM/YYYY)  Pick-up Status    Payment Status\tTimestamp\t Total Price(RM)");
         System.out.println("-----------------------------------------------------------------------------------");
         for (int i = 0; i < order.size(); i++) {
                System.out.println(order.get(i).getOrderId() + "\t " + order.get(i).getName() + "\t   " + order.get(i).getDate() + "\t   " + order.get(i).getPickUpStatus() + "     \t" + order.get(i).getPaymentStatus() + "\t" + order.get(i).getTimestamp() + "\t" + order.get(i).getPrice());
            }
         
    }

    public static void flower() {

          String choice;
        String pickMethod;
        double price;
        double totalPrice = 0;
//
//        cc.add(new Category("Flower", "F01", "Rose", 10, 10.50, "High"));
//        cc.add(new Category("Bouquet", "B01", "Posy", 0, 10.50, "Finish"));
//        cc.add(new Category("FloralArrangement", "FA01", "Oval", 3, 10.50, "Low"));

        do {

            System.out.println("ID\t\t Type\t\t Price(RM)\t\t Quantity\t\tStock ");
            System.out.println("--------------------------------------");
            for (int i = 0; i < cc.size(); i++) {
                if (cc.get(i).getcQuantity() > 0 && cc.get(i).getCategory().equals("Flower")) {
                    System.out.println(cc.get(i).getcID() + "\t " + cc.get(i).getcType() + "\t\t " + cc.get(i).getcPrice() + "\t   " + cc.get(i).getcQuantity() + "\t   " + cc.get(i).getStock());
                }
            }

            Scanner sc = new Scanner(System.in);

            System.out.print("\nPlease enter the id: ");
            while (!sc.hasNext()) {
                System.out.print("Please reenter again (eg:FA01):");
                sc.next();
            }
            String cID = sc.next();

            System.out.print("\nPlease enter the quantity of flower: ");
            while (!sc.hasNextInt()) {
                System.out.print("It is not an integer,please reenter again:");
                sc.next();
            }
            int quantity = sc.nextInt();

            for (int i = 0; i < cc.size(); i++) {
                if ((cID).equals(cc.get(i).getcID())) {

                    int total = (cc.get(i).getcQuantity()) - quantity;
                    cc.get(i).setcID(cc.get(i).getcID());
                    cc.get(i).setcType(cc.get(i).getcType());
                    cc.get(i).setcQuantity((total));
                    cc.get(i).setcPrice(cc.get(i).getcPrice());
                    cc.get(i).setStock(cc.get(i).getStock());

                    price = cc.get(i).getcPrice() * quantity;
                    totalPrice += price;
                }
            }

            System.out.print("Please enter pick up method      : ");
            System.out.print("\n(sp = self pick-up / d = delivery) ");
            pickMethod = sc.next();

            System.out.print("\nDo you want to continue order?(y = yes, n = no):");
            choice = sc.next();

            while (!"n".equals(choice) && !"y".equals(choice)) {
                System.out.print("Please type y or n:");
                choice = sc.next();
            }

            System.out.print("\nYou have chosen\n");
            System.out.print("-----------------\n");
            System.out.print(" Id: " + cID);
            System.out.println("\nQuantity: " + quantity);
        } while (!"n".equals(choice));
        System.out.println("\nTotal price: " + totalPrice);

        System.out.println("\nPick up method: " + pickMethod);

        System.out.println("\nThank you, please come again.");
    }

    public static void floral() {

          String choice;
        String pickMethod;
        double price;
        double totalPrice = 0;
//
//        cc.add(new Category("Flower", "F01", "Rose", 10, 10.50, "High"));
//        cc.add(new Category("Bouquet", "B01", "Posy", 0, 10.50, "Finish"));
//        cc.add(new Category("FloralArrangement", "FA01", "Oval", 3, 10.50, "Low"));

        do {

            System.out.println("ID\t\t Type\t\t Price(RM)\t\t Quantity\t\tStock ");
            System.out.println("--------------------------------------");
            for (int i = 0; i < cc.size(); i++) {
                if (cc.get(i).getcQuantity() > 0 && cc.get(i).getCategory().equals("FloralArrangement")) {
                    System.out.println(cc.get(i).getcID() + "\t " + cc.get(i).getcType() + "\t\t " + cc.get(i).getcPrice() + "\t   " + cc.get(i).getcQuantity() + "\t   " + cc.get(i).getStock());
                }
            }

            Scanner sc = new Scanner(System.in);

            System.out.print("\nPlease enter the id: ");
            while (!sc.hasNext()) {
                System.out.print("Please reenter again (eg:FA01):");
                sc.next();
            }
            String cID = sc.next();

            System.out.print("\nPlease enter the quantity of flower: ");
            while (!sc.hasNextInt()) {
                System.out.print("It is not an integer,please reenter again:");
                sc.next();
            }
            int quantity = sc.nextInt();

            for (int i = 0; i < cc.size(); i++) {
                if ((cID).equals(cc.get(i).getcID())) {

                    int total = (cc.get(i).getcQuantity()) - quantity;
                    cc.get(i).setcID(cc.get(i).getcID());
                    cc.get(i).setcType(cc.get(i).getcType());
                    cc.get(i).setcQuantity((total));
                    cc.get(i).setcPrice(cc.get(i).getcPrice());
                    cc.get(i).setStock(cc.get(i).getStock());

                    price = cc.get(i).getcPrice() * quantity;
                    totalPrice += price;
                }
            }

            System.out.print("Please enter pick up method      : ");
            System.out.print("\n(sp = self pick-up / d = delivery) ");
            pickMethod = sc.next();

            System.out.print("\nDo you want to continue order?(y = yes, n = no):");
            choice = sc.next();

            while (!"n".equals(choice) && !"y".equals(choice)) {
                System.out.print("Please type y or n:");
                choice = sc.next();
            }

            System.out.print("\nYou have chosen\n");
            System.out.print("-----------------\n");
            System.out.print(" Id: " + cID);
            System.out.println("\nQuantity: " + quantity);
        } while (!"n".equals(choice));
        System.out.println("\nTotal price: " + totalPrice);

        System.out.println("\nPick up method: " + pickMethod);

        System.out.println("\nThank you, please come again.");
    }
}