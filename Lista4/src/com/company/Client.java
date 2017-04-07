package com.company;

import java.util.Random;

/**
 * Created by matik on 29.03.2017.
 */
public class Client extends List {
    private String name,secName;
    private int maxSize;
    public Client(String name, String secName, int maxSize){
        super(maxSize);
        this.name=name;
        this.secName=secName;
        this.maxSize=maxSize;
        orderLoop();
    }

    public int removeFromCart(){
        Object o = super.dequeue();
        if(o!=null) {
            System.out.println(o);
            return ((Order)((Element)o).getKey()).getQuantity();
        }
        else
            throw new NullPointerException();

    }
    private void orderLoop(){
        for(int i=0;i<maxSize;i++)
            addToCart();
    }

    public int removeLoop(){
        int sum=0;
        for(int i=0;i<maxSize;i++)
           sum+= removeFromCart();
        return sum;
    }


    private void addToCart(){
        Order ordered=lottery();
        try {
            super.enqueue(ordered);
        }
        catch (NullPointerException e){System.out.println("Brak towaru do dodania, obiekt jest pusty");}
    }

    private Order lottery(){
        String orerName=null;
        int nameInt=0;
        Order newOrder=null;
        Random rand = new Random();
        nameInt=rand.nextInt(13);
        orerName=translateLottery(nameInt);
        nameInt=rand.nextInt(100);
        newOrder = new Order(orerName,nameInt);
        return newOrder;

        }

    private String translateLottery(int nameInt) {
        String orderName = null;
        switch (nameInt) {
            case 0: {
                orderName = "Makaron";
                break;
            }
            case 1: {
                orderName = "Ziemniaki";
                break;
            }
            case 2: {
                orderName = "Jabłka";
                break;
            }
            case 3: {
                orderName = "Banany";
                break;
            }
            case 4: {
                orderName = "Czekolada";
                break;
            }
            case 5: {
                orderName = "Joghurt";
                break;
            }
            case 6: {
                orderName = "Ser";
                break;
            }
            case 7: {
                orderName = "Szynka";
                break;
            }
            case 8: {
                orderName = "Chleb";
                break;
            }
            case 9: {
                orderName = "Mąka";
                break;
            }
            case 10: {
                orderName = "Cukier";
                break;
            }
            case 11: {
                orderName = "Ryż";
                break;
            }

            case 12: {
                orderName = "Warzywa mrożone";
                break;
            }

            default: {
                orderName = "Niezidentyfikowany produkt";
                break;
            }
        }
            return orderName;

    }


    public String toString(){
        return name+" "+secName;
    }
}
