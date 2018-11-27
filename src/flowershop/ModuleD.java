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
import java.sql.Timestamp;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khor
 */
public class ModuleD {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("hh.mm.ss a");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
    public static void recordTimestamp(){
            
        // TODO code application logic here
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        List<Order> order = new ArrayList<Order>();

        int choice;
        String choose;
        
        order.add(new Order(1001, "Lucas", "11/11/2018", "Self Pick-up", "Pending", "         Pending"));
        order.add(new Order(1002, "Kelly", "11/11/2018", "Self Pick-up", "Pending", "         Pending"));
        order.add(new Order(1003, "Haw", "11/11/2018", "Self Pick-up", "Pending", "         Pending"));
        order.add(new Order(1004, "Mong", "11/11/2018", "Self Pick-up", "Pending", "         Pending"));

        do {
            System.out.println("No\t Name\t Date(DD/MM/YYYY)  Pick-up Status    Payment Status\tTimestamp");
            System.out.println("-----------------------------------------------------------------------------------");
            for (int i = 0; i < order.size(); i++) {
                System.out.println(order.get(i).getOrderId() + "\t " + order.get(i).getName() + "\t   " + order.get(i).getDate() + "\t   " + order.get(i).getPickUpStatus() + "     \t" + order.get(i).getPaymentStatus() + "\t" + order.get(i).getTimestamp());
            }

            System.out.print("\nWhich customer had pick-up their order ?: ");
            Scanner input = new Scanner(System.in);

            if (input.hasNextInt()) {
                choice = input.nextInt();

                for (int i = 0; i < order.size(); i++) {
                    if (order.get(i).getOrderId() ==  choice) {

                        order.get(i).setOrderId(order.get(i).getOrderId());
                        order.get(i).setName(order.get(i).getName());
                        order.get(i).setDate(order.get(i).getDate());
                        order.get(i).setPickUpStatus(order.get(i).getPickUpStatus());
                        order.get(i).setPaymentStatus("Complete");
                        order.get(i).setTimestamp(sdf.format(timestamp));
                    }
                }
            } else {
                input.next();
                choice = 0;
            }

            while (choice < 1) {
                System.out.print("Please enter number that only have at the list: ");
                if (input.hasNextInt()) {
                    choice = input.nextInt();
                } else {
                    String dummy = input.next();
                    choice = 0;
                }
            }

            System.out.println("No\t Name\t Date(DD/MM/YYYY)  Pick-up Status    Payment Status\tTimestamp");
            System.out.println("-----------------------------------------------------------------------------------");
            for (int i = 0; i < order.size(); i++) {
                System.out.println(order.get(i).getOrderId() + "\t " + order.get(i).getName() + "\t   " + order.get(i).getDate() + "\t   " + order.get(i).getPickUpStatus() + "     \t" + order.get(i).getPaymentStatus() + "\t" + order.get(i).getTimestamp());
            }

            System.out.print("\nAre you want continue to modify the status ?(y/n): ");
            choose = input.next();

            while (!choose.equals("y") && !choose.equals("n")) {
                System.out.print("\nPlease selct y or n only: ");
                choose = input.next();
            }
            
        }while(!choose.equals("n"));
        
        FlowerShop.StaffMenu();
    }
}
