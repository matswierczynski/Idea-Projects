package com.company;

import java.util.Date;

/**
 * Created by matik on 04.03.2017.
 */
public class RR {
    Date date;
    long time;
    Queue queue;

    public RR(Queue q){

        queue = q;

    }

    public int run()
    {
        date=new Date();
        time=date.getTime();
        long summary=0;
        for (int i=0;i<queue.getSize();i++)
        {
            date=new Date();
            long wT=date.getTime();
            Process pr=queue.getProcess(i);
            int initialValue=pr.getLength();
            for(int k=0;k<pr.getLength();k++){
                pr.decreaseLength();
            }
            long waitingTime=wT-time;
            pr.setWaitingTime(waitingTime);
            pr.setLength(initialValue);
            summary+=waitingTime;

        }
        return (int)summary/queue.getSize();
    }


}
