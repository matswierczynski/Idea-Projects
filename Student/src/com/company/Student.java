package com.company;

import java.io.*;
import java.io.Serializable;

/**
 * Created by matik on 10.03.2017.
 */
public class Student implements Serializable {
    private String nazwisko,imie;
    private long album;
    private int rok;
    private double srednia;

    public Student()
    {
        this.nazwisko=null;
        this.imie=null;
        this.album=0;
        this.rok=0;
        this.srednia=0;

    }

    public Student(String imie, String nazwisko, long album, int rok, double srednia)
    {
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.album=album;
        this.rok=rok;
        this.srednia=srednia;

    }

    public double getSrednia() {
        return srednia;
    }

    public long getAlbum() {
        return album;
    }

    public int getRok() {
        return rok;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setAlbum(long album) {
        this.album = album;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setRok(int rok) {
        this.rok = rok;
    };

    public void setSrednia(double srednia) {
        this.srednia = srednia;
    }

    public static void tabela()
    {
        System.out.println();
        for(int i=0;i<77;i++)
            System.out.printf("-");
        System.out.printf("%n");
        System.out.printf("%-25s%-20s%-15s%-6s%-9s%n","| Nazwisko","| Imie","| Album","| Rok","| Średnia |");
        for(int i=0;i<77;i++)
            System.out.printf("-");
        System.out.printf("%n");
    }

    public void wyswietl()
    {

        System.out.printf("%-25s","| "+this.nazwisko);
        System.out.printf("%-20s","| "+this.imie);
        System.out.printf("%s%09d","|     ",this.album);
        System.out.printf("%s%01d","|  ",this.rok);
        System.out.printf("%s%01.2f%s%n","  |  ",this.srednia,"   |");


    }

    public static void koniecTabeli()
    {
        for(int i=0;i<77;i++)
            System.out.printf("-");
        System.out.printf("%n");
    }

    public String toString()
    {
        return String.format("%s,%s,%09d, %01d, %01.2f",this.nazwisko,this.imie,this.album,this.rok,this.srednia);
    }

    public static void writeToFile (String file_name,Student[] stud)
    {
        ObjectOutputStream ous=null;

        try {
            FileOutputStream fus = new FileOutputStream(file_name);
            ous = new ObjectOutputStream(fus);
            ous.writeInt(stud.length);
            for(Student s: stud)
            {
              ous.writeObject(s);
            }

        }
        catch (FileNotFoundException e){System.out.println("Nie można utworzyć pliku");e.printStackTrace();}
        catch (IOException  e){ System.out.println("Nie można utworzyć pliku");e.printStackTrace();}
        finally {
            if (ous != null)
                try {
                    ous.close();
                }
                catch (IOException e){System.out.println("Nie można zamknąć pliku");e.printStackTrace();}
        }
    }

    public static Student[] readFromFile (String file_name)
    {
        ObjectInputStream ois=null;
        Student[] stud=null;

        try {
            FileInputStream fis = new FileInputStream(file_name);
            ois = new ObjectInputStream(fis);
            int length=ois.readInt();
            stud = new Student[length];
            for(int i=0;i<length;i++)
            {
                stud[i]=((Student)ois.readObject());
            }

        }
        catch (FileNotFoundException e){System.out.println("Nie można otworzyć pliku");e.printStackTrace();}
        catch (IOException  e){ System.out.println("Nie można otworzyć pliku");e.printStackTrace();}
       // catch (ClassNotFoundException e){ System.out.println("Nieobsługiwane dane");e.printStackTrace();}
        finally {
            if (ois != null)
                try {
                    ois.close();
                }
                catch (IOException e){System.out.println("Nie można zamknąć pliku");e.printStackTrace();}
                return stud;
        }
    }
}
