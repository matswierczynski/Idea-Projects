package com.company;

/**
 * Created by matik on 04.03.2017.
 */
public class Scheduler {
    FCFS fcfs;
    SJF sjf;
    RR rr;
    Generate table;
    Queue queue;
    public Scheduler()
    {
        table = new Generate();
        for (int i=0;i<table.getProcessess().length;i++) {
            queue = new Queue(table.getProcessess(),i);
            int length=queue.getSize();

            queue.sortQueue();
            sjf = new SJF (queue);
            int sJf=sjf.run();

            queue.shuffleQueue();

            fcfs = new FCFS(queue);
            int fCfS=fcfs.run();

            rr = new RR(queue);
            int rR = rr.run();

            System.out.println("Pakiet nr "+(i+1)+":");
            System.out.println("FCFS: "+fCfS/length+" ms");
            System.out.println("SJF: "+sJf/length+" ms");
            System.out.println("RR: "+rR/length+" ms");
            System.out.println();

        }

    }


}
