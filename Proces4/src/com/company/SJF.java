package com.company;

import java.util.Date;

/**
 * Created by matik on 04.03.2017.
 */
public class SJF {
    Date date;
    long time;
    Queue queue;
    public SJF(Queue q){

        queue = q;

    }

    public long run()
    {
        date=new Date();
        time=date.getTime();
        long summary=0;
        for (int i=0;i<queue.getSize();i++)
        {
            date=new Date();
            long wT=date.getTime();
            Process pr=queue.getProcess(i);
            pr.setPickedUp(i+1);
            pr.start();
            long waitingTime=wT-time;
            pr.setWaitingTime(waitingTime);
            summary+=waitingTime;
            System.out.println(summary+" "+queue.getSize());
            pr.setExcetuted(0);


        }
        return summary/queue.getSize();
    }

}
