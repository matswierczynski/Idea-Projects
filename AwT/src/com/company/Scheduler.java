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
        table = new Generate(); //tworzenie tablicy procesów
        for (int i=0;i<table.getProcessess().length;i++) {
            queue = new Queue(table.getProcessess(),i); //utworzenie kolejki
            queue.shuffleQueue(); //mieszanie procesów
            long size = queue.getSize();


            fcfs = new FCFS(queue);
            long fCfS=fcfs.run();


            sjf = new SJF (queue);
            long sJf=sjf.run();

            rr = new RR(queue);
            long rR = rr.run();

            System.out.println("Pakiet nr "+(i+1)+":");
            System.out.println("FCFS: "+fCfS/size+" ms");
            System.out.println("SJF: "+sJf/size+" ms");
            System.out.println("RR: "+rR/size+" ms");
            System.out.println();

        }

    }


}
