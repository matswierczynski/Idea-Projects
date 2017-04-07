package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        boolean close = false;
        int choice=0;
        Scanner scan =new Scanner(System.in);
        Rand rand=null;

        do {
            System.out.printf("%nWitaj w aplikacji Talia Kart%nWybierz nr działania:" +
                    "%n1: Utworzenie listy%n2: Wyświetlanie listy" +
                    "%n3: Wyświetlanie liczby elementów listy" +
                    "%n4: Wyświetlanie kart o podanej wartości" +
                    "%n5: Wyświetlanie kart o podanym kolorze" +
                   // "%n6: Usuwanie duplikatów" +
                   // "%n7: Podział talii na cztery części" +
                    "%n8: Usuwanie kart o podanej wartości" +
                    "%n9: Usuwanie kart o podanym kolorze" +
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
                   rand.getList().showAll();
                    break;
                }

                case 3: {
                    System.out.println("Lista zawiera " + rand.getList().getSize() + " elementów/ty");
                    break;
                }
                case 4: {
                    System.out.printf("%nKarty o jakich wartościach chcesz wyświetlić?%n");
                    Scanner scan1=new Scanner(System.in);
                    String val=scan1.nextLine();
                    rand.getList().searchValue(val);
                    break;
                }
                case 5: {
                    System.out.printf("%nKarty o jakich kolorach chcesz wyświetlić?%n");
                    Scanner scan1=new Scanner(System.in);
                    String col=scan1.nextLine();
                    rand.getList().searchColor(col);
                    break;
                }

                case 6:{
                   System.out.printf("%nUsuwanie duplikatów%n");
                    rand.getList().deleteDuplicates();
                    break;


                }

                case 7:
                {
                    System.out.printf("%nTalia o kolorach kier%n");
                    rand.getList().searchColor("Kier");
                    System.out.printf("%nTalia o kolorach karo%n");
                    rand.getList().searchColor("Karo");
                    System.out.printf("%nTalia o kolorach trefl%n");
                    rand.getList().searchColor("Trefl");
                    System.out.printf("%nTalia o kolorach pik%n");
                    rand.getList().searchColor("Pik");
                    break;
                }

                case 8: {
                    System.out.printf("%nKarty o jakich wartościach chcesz usunąć?%n");
                    Scanner scan1=new Scanner(System.in);
                    String val=scan1.next();
                    rand.getList().deleteValue(val);
                    break;
                }

                case 9: {
                    System.out.printf("%nKarty o jakich kolorach chcesz usunąć?%n");
                    Scanner scan1=new Scanner(System.in);
                    String col=scan1.next();
                    rand.getList().deleteColor(col);
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
