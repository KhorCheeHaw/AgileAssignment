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
 * @author Desomond
 */
public class CatalogMaintainance {

    /**
     * @param args the command line arguments
     */
    private static Scanner s;
    static List<FreshFlower> ff = new ArrayList<>();
    static List<Bouquets> bou = new ArrayList<>();
    static List<FloralManagement> fa = new ArrayList<>();

    public static void main(String[] args) {
        // TODO code application logic here
        //freshflower
        ff.add(new FreshFlower("FF01", "Rose", "10", "10"));
        ff.add(new FreshFlower("FF02", "SunFlower", "20", "20"));
        //bouquet
        bou.add(new Bouquets("B01", "NoseGay", "11", "100"));
        bou.add(new Bouquets("B02", "Posy", "12", "110"));
        //floral
        fa.add(new FloralManagement("FM01", "Oval", "5", "130"));
        fa.add(new FloralManagement("FM02", "S", "3", "130"));
        s = new Scanner(System.in);
        int c1;
        int d1 = 0;
        do {
            
            menu();
         

        } while (d1 == 1);
    }

    public static void menu() {
        int c1;
        //int d1 = 0;
        System.out.println("Fiora FlowerShop");
        System.out.println("----------------------------");
        System.out.println("1. View Product");
        System.out.println("2. Add Product");
        System.out.println("3. Edit Product");
        System.out.println("4. Back to previous page");
        System.out.flush();
        c1 = s.nextInt();

        if (c1 == 1) {
            viewAll();

        } else if (c1 == 2) {
            addAll();

        } else if (c1 == 3) {
            maintain();

        } else if (c1 == 4){
            FlowerShop.StaffMenu();
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
            System.out.flush();
            c1 = s.nextInt();

            if (c1 == 1) {
                System.out.println("ID\t\t Type\t\t Price(RM)\t Quantity");
                System.out.println("-----------------------------------------------");
                for (int i = 0; i < ff.size(); i++) {
                    System.out.println(ff.get(i).toString());

                }
                System.out.println("Enter 1 to back to menu");
                d1 = s.nextInt();
            } else if (c1 == 2) {

                System.out.println("ID\t\t Type\t\t Price(RM)\t Quantity");
                System.out.println("-----------------------------------------------");
                for (int i = 0; i < bou.size(); i++) {
                    System.out.println(bou.get(i).toString());

                }
                System.out.println("Enter 1 to back to menu");
                d1 = s.nextInt();

            } else if (c1 == 3) {

                System.out.println("ID\t\t Type\t\t Price(RM)\t Quantity");
                System.out.println("-----------------------------------------------");
                for (int i = 0; i < fa.size(); i++) {
                    System.out.println(fa.get(i).toString());

                }
                System.out.println("Enter 1 to back to menu");
                d1 = s.nextInt();
            }else if (c1 == 4) {
                menu();
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
            System.out.flush();
            c1 = s.nextInt();

            if (c1 == 1) {
                freshflower();

            } else if (c1 == 2) {
                bouquets();

            } else if (c1 == 3) {
                floralarrangement();

            }else if (c1==4){
                menu();
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
                freshflower();

            } else if (c1 == 2) {
                bouquets();

            } else if (c1 == 3) {
                floralarrangement();

            }else if (c1==4){
                menu();
            }

        } while (d1 == 1);
    }

    public static void freshflower() {
        int c1;
        int d1 = 0;

        String ffId;
        String ffType;
        String ffPrice;
        

        do {

            System.out.println("Fiora FlowerShop");
            System.out.println("----------------------------");
            System.out.println("1. Add Flower Type");
            System.out.println("2. Add Flower Quantity");
            System.out.println("3. Back");
            System.out.flush();
            c1 = s.nextInt();

            if (c1 == 1) {

                System.out.print("Enter Flower ID: ");
                s.nextLine();
                ffId = s.nextLine();

                System.out.print("Enter Flower Type: ");
                ffType = s.nextLine();

                System.out.print("Enter Flower Price (Rm): ");
                ffPrice = s.nextLine();

                ff.add(new FreshFlower(ffId, ffType,"0", ffPrice ));
                System.out.println("ID\t\t Type\t\t Price(RM)\t Quantity");
                System.out.println("-----------------------------------------------");
                   for (int i = 0; i < ff.size(); i++) {
                    System.out.println(ff.get(i).toString());

                }
                menu();

            } else if (c1 == 2) {
                
                System.out.print("Type\n");
                System.out.print("----------------\n");
                for (int i = 0; i < ff.size(); i++) {
                    System.out.print(i + "\t" + ff.get(i).getFlowerType());
                    System.out.print("\n");
                    System.out.flush();

                }

                String ffTypes;
                System.out.println("Type in Flower Type:");
                ffTypes = s.next();
                
                for (int i = 0; i < ff.size(); i++) {
                if (ffTypes.equals(ff.get(i).getFlowerType())) {
                    System.out.print("How many amount you want to add?\n");
                    String ffQuantity = s.next();
                    ff.get(i).setFlowerId(ff.get(i).getFlowerId());
                    ff.get(i).setFlowerType(ff.get(i).getFlowerType());
                    ff.get(i).setPrice(ff.get(i).getPrice());
                    
                    int total = Integer.parseInt(ffQuantity) + Integer.parseInt(ff.get(i).getQuantity());
                    
                    ff.get(i).setQuantity(Integer.toString(total));
                    
                   
                }
                }
                  System.out.println("ID\t\t Type\t\t Price(RM)\t Quantity");
                  System.out.println("-----------------------------------------------");
                   for (int i = 0; i < ff.size(); i++) {
                   System.out.println(ff.get(i).toString());
                   
            }
                   menu();

            }else if(c1 == 3){
             addAll();
            }

        } while (d1 == 1);
    }

    public static void bouquets() {
        int c1;
        int d1 = 0;

        String bouId;
        String bouType;
        String bouPrice;
        String bouQuantity;
        String bouTypes;
        do {

            System.out.println("Bouquets");
            System.out.println("----------------------------");
            System.out.println("1. Add Bouquet Type");
            System.out.println("2. Add Bouquet Quantity");
            System.out.println("3. Back");
            System.out.flush();
            c1 = s.nextInt();

            if (c1 == 1) {
                System.out.print("Enter bouquets ID: ");
                s.nextLine();
                bouId = s.nextLine();

                System.out.print("Enter Bouquets Type: ");
                bouType = s.nextLine();

                System.out.print("Enter Bouquets Price (Rm): ");
                bouPrice = s.nextLine();

                bou.add(new Bouquets(bouId, bouType,  "0",bouPrice));
                System.out.println("ID\t\t Type\t\t Price(RM)\t Quantity");
                System.out.println("-----------------------------------------------");
                for (int i = 0; i < bou.size(); i++) {
                    System.out.println(bou.get(i).toString());

                }
                 menu();

            } else if (c1 == 2) {
                
                
                  System.out.print("Type\n");
                System.out.print("----------------\n");
                for (int i = 0; i < bou.size(); i++) {
                    System.out.print(i + "\t" + bou.get(i).getBouquetType());
                    System.out.print("\n");
                    System.out.flush();

                }

                String ffTypes;
                System.out.println("Type in Bouquets Type:");
                ffTypes = s.next();
                
                for (int i = 0; i < bou.size(); i++) {
                if (ffTypes.equals(bou.get(i).getBouquetType())) {
                    System.out.print("How many amount you want to add?\n");
                    String ffQuantity = s.next();
                    bou.get(i).setBouquetId(bou.get(i).getBouquetId());
                    bou.get(i).setBouquetType(bou.get(i).getBouquetType());
                    bou.get(i).setPrice(bou.get(i).getPrice());
                    
                    int total = Integer.parseInt(ffQuantity) + Integer.parseInt(bou.get(i).getQuantity());
                    
                    bou.get(i).setQuantity(Integer.toString(total));
                    
                   
                }
                }
                  System.out.println("ID\t\t Type\t\t Price(RM)\t Quantity");
                  System.out.println("-----------------------------------------------");
                   for (int i = 0; i < bou.size(); i++) {
                   System.out.println(bou.get(i).toString());
                   
            }
                   menu();
            } else if(c1 == 3){
            addAll();
            }

        } while (d1 == 1);
    }

    public static void floralarrangement() {
        int c1;
        int d1 = 0;

        String faId;
        String faType;
        String faPrice;
        String faQuantity;
        String faTypes;
        do {

            System.out.println("Floral Arrangement");
            System.out.println("----------------------------");
            System.out.println("1. Add Floral Type");
            System.out.println("2. Add Floral Quantity");
            System.out.println("3. Back");
            System.out.flush();
            c1 = s.nextInt();

            if (c1 == 1) {
                System.out.print("Enter Floral ID: ");
                s.nextLine();
                faId = s.nextLine();

                System.out.print("Enter Floral Type: ");
                faType = s.nextLine();

                System.out.print("Enter Floral Price (Rm): ");
                faPrice = s.nextLine();

                fa.add(new FloralManagement(faId, faType,"0", faPrice ));
                
                 System.out.println("ID\t\t Type\t\t Price(RM)\t Quantity");
                 System.out.println("-----------------------------------------------");
                for (int i = 0; i < fa.size(); i++) {
                    System.out.println(fa.get(i).toString());

                }
                 menu();

            } else if (c1 == 2) {
                System.out.print("Type\n");
                System.out.print("----------------\n");
                for (int i = 0; i < fa.size(); i++) {
                    System.out.print(i + "\t" + fa.get(i).getFloralType());
                    System.out.print("\n");
                    System.out.flush();

                }

                String ffTypes;
                System.out.println("Type in Floral Type:");
                ffTypes = s.next();
                
                for (int i = 0; i < fa.size(); i++) {
                if (ffTypes.equals(fa.get(i).getFloralType())) {
                    System.out.print("How many amount you want to add?\n");
                    String ffQuantity = s.next();
                    
                    fa.get(i).setFloraId(fa.get(i).getFloraId());
                    fa.get(i).setFloralType(fa.get(i).getFloralType());
                    fa.get(i).setPrice(fa.get(i).getPrice());
                    
                    int total = Integer.parseInt(ffQuantity) + Integer.parseInt(fa.get(i).getQuantity());
                    
                    fa.get(i).setQuantity(Integer.toString(total));
                    
                   
                }
                }
                  System.out.println("ID\t\t Type\t\t Price(RM)\t Quantity");
                  System.out.println("-----------------------------------------------");
                   for (int i = 0; i < fa.size(); i++) {
                   System.out.println(fa.get(i).toString());
                   
            }
                   menu();


            }else if (c1 == 3){
                addAll();
            }
        } while (d1 == 1);
    }
}
