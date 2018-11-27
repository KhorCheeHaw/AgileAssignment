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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter order id: ");
        sc.nextInt();
        menu();

    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n1. Fresh Flower\n");
        System.out.print("2. Bouquets\n");
        System.out.print("3. Floral Management\n");
        System.out.print("Please select the categories: ");

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

        List<Bouquets> bouquets = new ArrayList<Bouquets>();

        String choice;
        int price;
        int totalPrice = 0;

        bouquets.add(new Bouquets("1", "rose", "15", "20"));
        bouquets.add(new Bouquets("2", "abc", "15", "20"));
        bouquets.add(new Bouquets("3", "abc", "15", "20"));

        do {

            System.out.println("Id\t Bouquet Type\t Quantity  Price ");
            System.out.println("--------------------------------------");
            for (int i = 0; i < bouquets.size(); i++) {
                System.out.println(bouquets.get(i).getBouquetId() + "\t " + bouquets.get(i).getBouquetType() + "\t\t " + bouquets.get(i).getQuantity() + "\t   " + bouquets.get(i).getPrice());
            }

            Scanner sc = new Scanner(System.in);

            System.out.print("\nPlease enter the id of bouquet: ");
            while (!sc.hasNextInt()) {
                System.out.print("It is not an integer,please reenter again:");
                sc.next();
            }
            int itemNo = sc.nextInt();
           

            System.out.print("\nPlease enter the quantity of flower: ");
            while (!sc.hasNextInt()) {
                System.out.print("It is not an integer,please reenter again:");
                sc.next();
            }
            int quantity = sc.nextInt();
            

            for (int i = 0; i < bouquets.size(); i++) {
                if (Integer.toString(itemNo).equals(bouquets.get(i).getBouquetId())) {

                    int total = Integer.parseInt(bouquets.get(i).getQuantity()) - quantity;
                    bouquets.get(i).setBouquetId(bouquets.get(i).getBouquetId());
                    bouquets.get(i).setBouquetType(bouquets.get(i).getBouquetType());
                    bouquets.get(i).setQuantity(Integer.toString(total));
                    bouquets.get(i).setPrice(bouquets.get(i).getPrice());

                    price = Integer.parseInt(bouquets.get(i).getPrice()) * quantity;
                    totalPrice += price;
                }
            }

            System.out.print("\nDo you want to continue order?(y = yes, n = no):");
            choice = sc.next();

            while (!"n".equals(choice) && !"y".equals(choice)) {
                System.out.print("Please type y or n:");
                choice = sc.next();
            }

            System.out.print("\nYou have chosen\n");
            System.out.print("-----------------\n");
            System.out.print("Flower Id: " + itemNo);
            System.out.println("\nQuantity: " + quantity);
        } while (!"n".equals(choice));
        System.out.println("\nTotal price: " + totalPrice);
        System.out.println("\nThank you, please come again.");
    }

    public static void flower() {

        List<FreshFlower> flower = new ArrayList<FreshFlower>();

        String choice;
        int price;
        int totalPrice = 0;

        flower.add(new FreshFlower("1", "Rose", "15", "20"));
        flower.add(new FreshFlower("2", "Lily", "15", "20"));
        flower.add(new FreshFlower("3", "Orchid", "15", "20"));

        do {

            System.out.println("\nId\t Flower Type\t Quantity   Price ");
            System.out.println("-----------------------------------------");
            for (int i = 0; i < flower.size(); i++) {
                System.out.println(flower.get(i).getFlowerId() + "\t " + flower.get(i).getFlowerType() + "\t\t     " + flower.get(i).getQuantity() + "\t     " + flower.get(i).getPrice());
            }

            Scanner sc = new Scanner(System.in);

            System.out.print("\nPlease enter the id of flower: ");
            while (!sc.hasNextInt()) {
                System.out.print("It is not an integer,please reenter again:");
                sc.next();
            }
            int itemNo = sc.nextInt();

            System.out.print("\nPlease enter the quantity of flower: ");
            while (!sc.hasNextInt()) {
                System.out.print("It is not an integer,please reenter again:");
                sc.next();
            }
            int quantity = sc.nextInt();

            for (int i = 0; i < flower.size(); i++) {
                if (Integer.toString(itemNo).equals(flower.get(i).getFlowerId())) {

                    int total = Integer.parseInt(flower.get(i).getQuantity()) - quantity;
                    flower.get(i).setFlowerId(flower.get(i).getFlowerId());
                    flower.get(i).setFlowerType(flower.get(i).getFlowerType());
                    flower.get(i).setQuantity(Integer.toString(total));
                    flower.get(i).setPrice(flower.get(i).getPrice());

                    price = Integer.parseInt(flower.get(i).getPrice()) * quantity;
                    totalPrice += price;
                }
            }

            System.out.print("\nDo you want to continue order?(y = yes, n = no):");
            choice = sc.next();

            while (!"n".equals(choice) && !"y".equals(choice)) {
                System.out.print("Please type y or n:");
                choice = sc.next();
            }

            System.out.print("\nYou have chosen\n");
            System.out.print("-----------------\n");
            System.out.print("Flower Id: " + itemNo);
            System.out.println("\nQuantity: " + quantity);

        } while (!"n".equals(choice));
        System.out.println("\nTotal price: " + totalPrice);
        System.out.println("\nThank you, please come again.");
    }

    public static void floral() {
        List<FloralManagement> floral = new ArrayList<FloralManagement>();

        String choice;
        int price;
        int totalPrice = 0;

        floral.add(new FloralManagement("1", "rose", "15", "20"));
        floral.add(new FloralManagement("2", "abc", "15", "20"));
        floral.add(new FloralManagement("3", "abc", "15", "20"));

        do {

            System.out.println("Id\t Floral Type\t Quantity  Price ");
            System.out.println("---------------------------------------");
            for (int i = 0; i < floral.size(); i++) {
                System.out.println(floral.get(i).getFloraId() + "\t " + floral.get(i).getFloralType() + "\t\t " + floral.get(i).getQuantity() + "\t   " + floral.get(i).getPrice());
            }

            Scanner sc = new Scanner(System.in);

            System.out.print("\nPlease enter the id of floral: ");
            while (!sc.hasNextInt()) {
                System.out.print("It is not an integer,please reenter again:");
                sc.next();
            }
            int itemNo = sc.nextInt();

            System.out.print("\nPlease enter the quantity of flower: ");
            while (!sc.hasNextInt()) {
                System.out.print("It is not an integer,please reenter again:");
                sc.next();
            }
            int quantity = sc.nextInt();

            for (int i = 0; i < floral.size(); i++) {
                if (Integer.toString(itemNo).equals(floral.get(i).getFloraId())) {

                    int total = Integer.parseInt(floral.get(i).getQuantity()) - quantity;
                    floral.get(i).setFloraId(floral.get(i).getFloraId());
                    floral.get(i).setFloralType(floral.get(i).getFloralType());
                    floral.get(i).setQuantity(Integer.toString(total));
                    floral.get(i).setPrice(floral.get(i).getPrice());

                    price = Integer.parseInt(floral.get(i).getPrice()) * quantity;
                    totalPrice += price;
                }
            }

            System.out.print("\nDo you want to continue order?(y = yes, n = no):");
            choice = sc.next();

            while (!"n".equals(choice) && !"y".equals(choice)) {
                System.out.print("Please type y or n:");
                choice = sc.next();
            }

            System.out.print("\nYou have chosen\n");
            System.out.print("-----------------\n");
            System.out.print("Flower Id: " + itemNo);
            System.out.println("\nQuantity: " + quantity);
        } while (!"n".equals(choice));
        System.out.println("\nTotal price: " + totalPrice);
        System.out.println("\nThank you, please come again.");
    }
}