package com.company;

/**
 * Created by matik on 04.03.2017.
 */
public class Process  {
    private int number;
    private int length;
    private int pickedUp;
    private long waitingTime;
    private long date;

    public Process (int number, int length, int pickedUp, int wT) {
        this.number=number;
        this.length=length;
        this.pickedUp=pickedUp;
        this.waitingTime=wT;
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

    public long getWaitingTime() {
        return waitingTime;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setWaitingTime(long waitingTime) {
        this.waitingTime = waitingTime;
    }

    public void setPickedUp(int pickedUp) {
        this.pickedUp = pickedUp;
    }

    public void decreaseLength()
    {
        this.length--;
    }

    public String toString()
    {
        return getNumber()+" "+getPickedUp()+" "+getLength();
    }

}
