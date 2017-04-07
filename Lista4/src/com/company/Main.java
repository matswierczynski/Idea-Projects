package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Firma fr=null;
        Warehouse wh=null;
        boolean close=false;
        int choice=0;
        Scanner scanner;

        do {

            System.out.println("Menu aplikacji"+
                            "\n1:Utwórz firmę"+
                             "\n2:Dodaj magazyn"+
                            "\n3:Dodaj klienta"+
                            "\n4:Obsłuż klientów"+
                             "\n5:Usuń magazyn\n");
            do {
                scanner = new Scanner(System.in);
                System.out.println("Wybierz opcję");
                if (scanner.hasNextInt())
                    choice = scanner.nextInt();
                else
                    System.out.println("Podałeś niepoprawne dane");
            } while (choice==0);

            switch (choice) {
                case 1: {
                    fr=new Firma(5);
                    break;
                }

                case 2:{
                    wh=fr.addWarehouses();
                }

                case 3: {
                    try {
                        wh.addClient();
                    } catch (NullPointerException e) {
                        System.out.println("Brak magazynu, nie można dodać klienta!");

                    }

                    finally {
                        break;
                    }

                }


                case 4: {
                    try {
                        wh.removeClient();
                    } catch (NullPointerException e) {
                        System.out.println("Brak magazynu do obsłużenia!");
                        break;
                    }
                }

                case 5:{
                    wh=fr.removeWarehouses();
                    if (wh!=null)
                    wh.removeClient();
                    else
                        System.out.println("Lista jest pusta");
                    break;
                }

                case 6: {
                    close = true;
                    break;
                }
            }

        }  while (close==false);


    }

}
