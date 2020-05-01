package me.surendra.design_patterns.Template;

import me.surendra.design_patterns.Template.Order.NetOrder;
import me.surendra.design_patterns.Template.Order.OrderProcessTemplate;
import me.surendra.design_patterns.Template.Order.StoreOrder;

public class OrderClient {

    public static void main(String... args) {
        System.out.println("$$$$$$$ NetOrder instance of the Template: $$$$$$$");
        OrderProcessTemplate netOrder = new NetOrder();
        netOrder.processOrder();
        System.out.println("$$$$$$$ StoreOrder instance of the Template: $$$$$$$");
        OrderProcessTemplate storeOrder = new StoreOrder();
        storeOrder.processOrder();
    }

}
