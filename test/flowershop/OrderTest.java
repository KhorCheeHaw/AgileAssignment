/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flowershop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cheehaw
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import flowershop.Order;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cheehaw
 */
public class OrderTest {

    static List<Order> order = new ArrayList<Order>();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("hh.mm.ss a");
    private static Order instance;

    public OrderTest() {

    }

    @Before
    public void setUp() {
        this.instance = new Order("O13", "Soo", "12/12/2018", "Delivery", "Pending", "Pending", "50", "Genting Klang");
    }

    /**
     * Test of getOrderId method, of class Order.
     */
    @Test
    public void testGetOrderId() {
        System.out.println("getOrderId");
        String expResult = "O13";
        String result = instance.getOrderId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setOrderId method, of class Order.
     */
    @Test
    public void testSetOrderId() {
        String OrderId = "O";

        if (order.isEmpty()) {
            OrderId += String.format("%02d", order.size() + 1);
        } else {
            int lastEidNumber = Integer.parseInt(order.get(order.size() - 1).getOrderId().substring(1));
            OrderId = "O" + String.format("%02d", lastEidNumber + 1);
        }

        System.out.println("setOrderId");
        String orderId = OrderId;
        instance.setOrderId(orderId);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getName method, of class Order.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "Soo";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setName method, of class Order.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Soo";
        instance.setName(name);

    }

    /**
     * Test of getDate method, of class Order.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        String expResult = "12/12/2018";
        String result = instance.getDate();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setDate method, of class Order.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        String date = "12/12/2018";
        instance.setDate(date);

    }

    /**
     * Test of getPickUpStatus method, of class Order.
     */
    @Test
    public void testGetPickUpStatus() {
        System.out.println("getPickUpStatus");
        String expResult = "Delivery";
        String result = instance.getPickUpStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPickUpStatus method, of class Order.
     */
    @Test
    public void testSetPickUpStatus() {
        System.out.println("setPickUpStatus");
        String pickUpStatus = "Delivery";
        instance.setPickUpStatus(pickUpStatus);

    }

    /**
     * Test of getPaymentStatus method, of class Order.
     */
    @Test
    public void testGetPaymentStatus() {
        System.out.println("getPaymentStatus");
        String expResult = "Pending";
        String result = instance.getPaymentStatus();
        assertEquals(expResult, result);

    }

    /**
     * Test of setPaymentStatus method, of class Order.
     */
    @Test
    public void testSetPaymentStatus() {
        System.out.println("setPaymentStatus");
        String paymentStatus = "Pending";
        instance.setPaymentStatus(paymentStatus);
    }

    /**
     * Test of getTimestamp method, of class Order.
     */
    @Test
    public void testGetTimestamp() {
        System.out.println("getTimestamp");
        String expResult = "Pending";
        String result = instance.getTimestamp();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTimestamp method, of class Order.
     */
    @Test
    public void testSetTimestamp() {
        System.out.println("setTimestamp");
        String timestamp = "Pending";
        instance.setTimestamp(timestamp);
    }

    /**
     * Test of getPrice method, of class Order.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        String expResult = "50";
        String result = instance.getPrice();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPrice method, of class Order.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        String price = "50";
        instance.setPrice(price);

    }

    /**
     * Test of getAddress method, of class Order.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        String expResult = "Genting Klang";
        String result = instance.getAddress();
        assertEquals(expResult, result);

    }

    /**
     * Test of setAddress method, of class Order.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "Genting Klang";
        instance.setAddress(address);

        main(null);
    }

    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        Order order1;

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

        System.out.println("No\t Name\t Date(DD/MM/YYYY)  Pick-up Status  Price(RM)\tPayment Status\t\tTimestamp\tAddress");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < order.size(); i++) {
            if (order.get(i).getPickUpStatus().equals("Delivery") && order.get(i).getDate().equals(formatter.format(date)) && order.get(i).getAddress().equals("Gombak")) {
                System.out.println(order.get(i).getOrderId() + "\t " + order.get(i).getName() + "\t   " + order.get(i).getDate() + "\t   " + order.get(i).getPickUpStatus() + "\t      " + order.get(i).getPrice() + "  \t  " + order.get(i).getPaymentStatus() + "\t" + order.get(i).getTimestamp() + "\t" + order.get(i).getAddress());

            }
        }
        
        if(instance.getPickUpStatus().equals("Delivery") && instance.getDate().equals(formatter.format(date)) && instance.getAddress().equals("Gombak")){
            System.out.println(instance.getOrderId() + "\t " + instance.getName() + "\t   " + instance.getDate() + "\t   " + instance.getPickUpStatus() + "\t      " + instance.getPrice() + "  \t  " + instance.getPaymentStatus() + "  \t\t " + instance.getTimestamp() + "\t" + instance.getAddress());
        }

        for (int i = 0; i < order.size(); i++) {
            if (order.get(i).getPickUpStatus().equals("Delivery") && order.get(i).getDate().equals(formatter.format(date)) && order.get(i).getAddress().equals("Genting Klang")) {
                System.out.println(order.get(i).getOrderId() + "\t " + order.get(i).getName() + "\t   " + order.get(i).getDate() + "\t   " + order.get(i).getPickUpStatus() + "\t      " + order.get(i).getPrice() + "  \t  " + order.get(i).getPaymentStatus() + "\t" + order.get(i).getTimestamp() + "\t" + order.get(i).getAddress());
                
            }
        }
        
        if(instance.getPickUpStatus().equals("Delivery") && instance.getDate().equals(formatter.format(date)) && instance.getAddress().equals("Genting Klang")){
            System.out.println(instance.getOrderId() + "\t " + instance.getName() + "\t   " + instance.getDate() + "\t   " + instance.getPickUpStatus() + "\t      " + instance.getPrice() + "  \t  " + instance.getPaymentStatus() + "  \t\t " + instance.getTimestamp() + "\t" + instance.getAddress());
        }

        for (int i = 0; i < order.size(); i++) {
            if (order.get(i).getPickUpStatus().equals("Delivery") && order.get(i).getDate().equals(formatter.format(date)) && order.get(i).getAddress().equals("Wangsa Maju")) {
                System.out.println(order.get(i).getOrderId() + "\t " + order.get(i).getName() + "\t   " + order.get(i).getDate() + "\t   " + order.get(i).getPickUpStatus() + "\t      " + order.get(i).getPrice() + "  \t  " + order.get(i).getPaymentStatus() + "\t" + order.get(i).getTimestamp() + "\t" + order.get(i).getAddress());
            }
        }

        if(instance.getPickUpStatus().equals("Delivery") && instance.getDate().equals(formatter.format(date)) && instance.getAddress().equals("Wangsa Maju")){
            System.out.println(instance.getOrderId() + "\t " + instance.getName() + "\t   " + instance.getDate() + "\t   " + instance.getPickUpStatus() + "\t      " + instance.getPrice() + "  \t  " + instance.getPaymentStatus() + "  \t\t " + instance.getTimestamp() + "\t" + instance.getAddress());
        }
        
        for (int i = 0; i < order.size(); i++) {
            if (order.get(i).getPickUpStatus().equals("Delivery") && order.get(i).getDate().equals(formatter.format(date)) && order.get(i).getAddress().equals("Petaling Jaya")) {
                System.out.println(order.get(i).getOrderId() + "\t " + order.get(i).getName() + "\t   " + order.get(i).getDate() + "\t   " + order.get(i).getPickUpStatus() + "\t      " + order.get(i).getPrice() + "  \t  " + order.get(i).getPaymentStatus() + "\t" + order.get(i).getTimestamp() + "\t" + order.get(i).getAddress());
                
            }
        }
        
        if(instance.getPickUpStatus().equals("Delivery") && instance.getDate().equals(formatter.format(date)) && instance.getAddress().equals("Petaling Jaya")){
            System.out.println(instance.getOrderId() + "\t " + instance.getName() + "\t   " + instance.getDate() + "\t   " + instance.getPickUpStatus() + "\t      " + instance.getPrice() + "  \t  " + instance.getPaymentStatus() + "  \t\t " + instance.getTimestamp() + "\t" + instance.getAddress());
        }
    }
}
