package com.company;

import javax.xml.bind.Element;
import java.util.Scanner;

/**
 * Created by matik on 30.03.2017.
 */
public class Warehouse extends List {

    public Warehouse(int maxSize){
        super(maxSize);
    }
    public void addClient(){
        String [] data=getData();
        Client client = new Client(data[0], data[1],getSize());
        try {
            super.enqueue(client);
        }
        catch (NullPointerException e){System.out.println("Podany obiekt jest pusty");}
    }

    public void removeClient(){
        Object o = null;

        do {
            o = super.dequeue();
            if (o != null) {
                System.out.println(o + " : zlecenie zrealizowane " +((Client)(((Element)o).getKey())).removeLoop());
            }
        }
        while(o!=null);

    }

    private String[] getData(){
        Scanner scanner = new Scanner(System.in);
        String [] tab = new String[2];
        System.out.println("Podaj imie klienta");
        tab[0]=scanner.nextLine();
        System.out.println("Podaj nazwisko klienta");
        tab[1]=scanner.nextLine();
        return tab;
    }

    private int getSize(){
        int correctSize=0;
        Scanner scanner;
        do {
            scanner = new Scanner(System.in);
            System.out.println("Podaj wielkość listy zakupów");
            if (scanner.hasNextInt())
                correctSize = scanner.nextInt();
            else
                System.out.println("Podałeś niepoprawne dane");
        } while (correctSize==0);

        return correctSize;
    }

    public void handleClients(){

    }

    public static Warehouse addWarehouse(){
        int correctSize=0;
        Scanner scanner;
        do {
            scanner = new Scanner(System.in);
            System.out.println("Podaj maksmalną ilość obsługiwnaych klientów przez magazyn");
            if (scanner.hasNextInt())
                correctSize = scanner.nextInt();
            else
                System.out.println("Podałeś niepoprawne dane");
        } while (correctSize==0);

        Warehouse wh = new Warehouse(correctSize);
        return wh;
    }
}
