package com.company;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        Student[] stud=null;
        stud=new Student[Integer.parseInt(args[0])];
        System.out.println(args[0]);
        System.out.println(args[1]);
        for(int i=0;i<stud.length;i++)
        {
            System.out.printf("Podaj nazwisko: ");
            String nazwisko=scan.next();
            System.out.printf("%nPodaj imię: ");
            String imie=scan.next();
            System.out.printf("%nPodaj numer albumu: ");
            long nr=scan.nextLong();
            System.out.printf("%nPodaj rok studiów: ");
            int rok=scan.nextInt();
            System.out.printf("%nPodaj średnią: ");
            double srednia=scan.nextDouble();
            stud[i]=new Student(imie,nazwisko,nr,rok,srednia);

        }
        Student.tabela();
        for(int i=0;i<Integer.parseInt(args[0]);i++)
            stud[i].wyswietl();
        Student.koniecTabeli();

        Student.writeToFile(args[1],stud);
        Student[] stud1=Student.readFromFile(args[1]);
        if(stud1!=null)
        {
            Student.tabela();
            for(int x=0;x<stud1.length;x++)
                stud1[x].wyswietl();
            Student.koniecTabeli();
        }

        Uczelnia it = new Uczelnia(stud);
        it.first();
        while (!it.isDone())
        {
            Object o=it.current();
            ((Student)o).wyswietl();
            it.next();
        }
    }
}
