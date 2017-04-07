package com.company;

/**
 * Created by matik on 29.03.2017.
 */
public class Order {
    private String name;
    private int quantity;

   public Order(){
       name=null;
       quantity=0;
   }
   public Order(String name, int quantity) {
   this.name=name;
   this.quantity=quantity;
   }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString(){
       return name+" "+quantity;
    }
}
