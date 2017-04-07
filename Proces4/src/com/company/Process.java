package com.company;

/**
 * Created by matik on 04.03.2017.
 */
public class Process extends Thread {
    private int number;
    private int length;
    private int pickedUp;
    private long waitingTime;
    private long date;
    private boolean isStarted;
    private int excetuted;


    public Process (int number, int length, int pickedUp, long wT) {
        this.number=number;
        this.length=length;
        this.pickedUp=pickedUp;
        this.waitingTime=wT;
        excetuted=0;
        setStarted(false);
    }

    public void run()
    {
        //decreaseLength();
        int k=excetuted;
        try {
            while (excetuted < getLength()) {
                try {

                    k++;
                    Thread.sleep(1);
                    setExcetuted(k);

                } catch (InterruptedException e) {
                    setExcetuted(k);
                }
            }
            throw new InterruptedException();
        } catch (InterruptedException e) {};

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

    public void setStarted(boolean started) {
        isStarted = started;
    }

    public int getExcetuted() {
        return excetuted;
    }

    public void setExcetuted(int excetuted) {
        this.excetuted = excetuted;
    }

    public boolean getIsStarted() {
        return isStarted;
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
