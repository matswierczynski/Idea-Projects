package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Pager pager=null;
        Scanner scan=new Scanner(System.in);
        System.out.println("\nIle stron chcesz wylosować?");
        int size = scan.nextInt();
        System.out.println("\nZ jakiego zakresu losować strony?");
        int range = scan.nextInt();
        System.out.println("\nIle ramek posiada system?");
        int frames= scan.nextInt();
        pager=new Pager(range,size);
        //pager.showPagesQueue();

        FIFO fifo = new FIFO(frames,pager.getPagesQueue(),pager.getPages());
        OPT opt = new OPT(frames,pager.getPagesQueue(),pager.getPages());
        LRU lru =new LRU(frames,pager.getPagesQueue(),pager.getPages());
        LRUapprox lruapprox = new LRUapprox(frames,pager.getPagesQueue(),pager.getPages());
        RAND rand = new RAND(frames,pager.getPagesQueue(),pager.getPages());
        System.out.println("FIFO: "+fifo.handle());
        System.out.println("OPT: "+opt.handle());
        System.out.println("LRU: "+lru.handle());
        System.out.println("LRU Approximate: "+lruapprox.handle());
        System.out.println("RAND: "+rand.handle());
    }
}
