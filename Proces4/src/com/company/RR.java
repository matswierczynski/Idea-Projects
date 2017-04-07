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
        while (queue.isEmpty()==false) {
            for (int i = 0; i < queue.getSize(); i++) {
                date = new Date();
                long wT = date.getTime();
                Process pr = queue.getProcess(i);

                    if (pr.getDate() == 0) {
                        date = new Date();
                        summary += date.getTime() - time;
                        pr.setDate(date.getTime());
                    } else {
                        date = new Date();
                        summary += date.getTime() - pr.getDate();
                    }

                    if(pr.getIsStarted()==false) {
                        pr.start();
                        pr.setStarted(true);
                    }
                    try {
                        Thread.sleep(10);
                            //System.out.println("Żyje");

                    } catch (InterruptedException e) {
                        System.out.println("Usunięty");
                        queue.remove(i);
                    };
                    date = new Date();
                    pr.setDate(date.getTime());

                }
            }

        return (int)summary/queue.getSize();
    }


}
