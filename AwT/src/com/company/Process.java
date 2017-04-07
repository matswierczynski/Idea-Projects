package com.company;

import java.util.Date;

/**
 * Created by matik on 04.03.2017.
 */
public class Process  {
    private int number; //nr procesu
    private int length; //długość procesu
    private int pickedUp; //moment nadejścia procesu
    private long date;        //czas wywłaszczenia procesu
    private int actualState;  //aktualny stan wykonywania procesu

    public Process (int number, int length, int pickedUp) {
        this.number=number;
        this.length=length;
        this.pickedUp=pickedUp;
        this.actualState=0;
    }

    public int getNumber()
    {
        return number;
    }

    public int getLength() {
        return length;
    }

    public int getPickedUp() {
        return pickedUp;
    }


    public long getDate() {
        return date;
    }

    public void setDate() {
        Date date = new Date();
        this.date=date.getTime();
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public void setPickedUp(int pickedUp) {
        this.pickedUp = pickedUp;
    }

    public void SetActualState(int value)
    {
        this.actualState=value;
    }

    public void DecreaseState() {this.actualState++;}

    public int getActualState() {
        return actualState;
    }

    public void setActualState(int actualState) {
        this.actualState = actualState;
    }

    public String toString()
    {
        return getNumber()+" "+getPickedUp()+" "+getLength();
    }


}
