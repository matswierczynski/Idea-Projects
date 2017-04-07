package com.company;

/**
 * Created by matik on 11.03.2017.
 */
public class Request {
    private final int cylNr; //nr cylindra
    private final int reqTime; //czas zgłoszenia
    private final boolean priority; //czy posiada priorytet
    private final int prTime; //priorytetowy czas wykonania

    public Request(int cyl, int reqT, boolean prior, int prT)
    {
        cylNr=cyl;
        reqTime=reqT;
        priority=prior;
        prTime=prT;
    }

    public boolean isPriority() {
        return priority;
    }

    public int getCylNr() {
        return cylNr;
    }

    public int getPrTime() {
        return prTime;
    }

    public int getReqTime() {
        return reqTime;
    }

    public String toString()
    {
        return cylNr+" "+reqTime+" "+priority+" "+prTime;
    }


}


