package com.company;
import iterators.*;
import java.util.Iterator;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        boolean close = false;
        int choice=0;
        Scanner scan =new Scanner(System.in);
        Rand rand=null;
        FilterDeck fd=null;
        Predicate pred=null;
        Deck iterator=null;

        do {
            System.out.printf("%nWitaj w aplikacji Talia Kart%nWybierz nr działania:" +
                    "%n1: Utworzenie listy%n2: Wyświetlanie listy" +
                    "%n3: Wyświetlanie liczby elementów listy" +
                    "%n4: Wyświetlanie kart o podanej wartości" +
                    "%n5: Wyświetlanie kart o podanym kolorze" +
                    "%n6: Wyświetlanie ilości zakrytych kart" +
                    "%n7: Wyświetlanie ilości odkrytych kart" +
                    "%n8: Usuwanie kart o podanej wartości" +
                    "%n0: Koniec pracy%n");


            choice = scan.nextInt();
            System.out.println();

            switch (choice) {
                case 0:{
                    close=true;
                    break;
                }

                case 1: {
                    rand = new Rand();
                    break;
                }
                case 2: {
                    iterator = new Deck(rand.getList());
                    iterator.first();
                    while (!iterator.isDone()) {
                        System.out.println(iterator.current());
                        iterator.next();
                    }
                    break;
                }

                case 3: {
                    System.out.println("Lista zawiera " + rand.getSize() + " elementów/ty");
                    break;
                }
                case 4: {
                    System.out.printf("%nKarty o jakich wartościach chcesz wyświetlić?%n");
                    Scanner scan1=new Scanner(System.in);
                    String val=scan1.nextLine();
                    pred=new Predicate();
                    pred.acceptCondition("Value",val);
                    fd=new FilterDeck(iterator,pred);
                    fd.first();
                    while (!fd.isDone()) {
                        System.out.println(fd.current());
                        fd.next();
                    }
                    break;
                }
                case 5: {
                    System.out.printf("%nKarty o jakich kolorach chcesz wyświetlić?%n");
                    Scanner scan1=new Scanner(System.in);
                    String col=scan1.nextLine();
                    pred=new Predicate();
                    pred.acceptCondition("Color",col);
                    fd=new FilterDeck(iterator,pred);
                    fd.first();
                    while (!fd.isDone()) {
                        System.out.println(fd.current());
                        fd.next();
                    }
                    break;
                }

                case 6:{
                    System.out.printf("%nWyświetl ilość kart zakrytych%n");
                    ArrayList<Card> list=rand.getList();
                    int k=0;
                    for(int i=0;i<list.size();i++)
                    {
                        if((list.get(i).isHidden()))
                            k++;


                    }
                    System.out.println("Lista zawiera "+k+" kart zakrytych");
                    break;


                }

                case 7:
                {
                    System.out.printf("%nWyświetl ilości kart odkrytych%n");
                    ArrayList<Card> list=rand.getList();
                    int k=0;
                    for(Card x:list)
                    {
                        if(!(x.isHidden()))
                            k++;
                    }
                    System.out.println("Lista zawiera "+k+" kart odkrytych");
                    break;


                }

                case 8: {
                    System.out.printf("%nKarty o jakich wartościach chcesz usunąć?%n");
                    ArrayList<Card> list=rand.getList();
                    Scanner scan1=new Scanner(System.in);
                    int val=scan1.nextInt();
                    for (Iterator<Card> it = list.iterator(); it.hasNext(); ) {
                        Card karta=it.next();
                        if(karta.getValue()==val)
                        it.remove();

                    }
                    break;
                }
                default: {
                    break;
                }


            }
        }

        while (!close);
    }
}
