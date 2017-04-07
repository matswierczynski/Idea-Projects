package com.company;

import java.util.ArrayList;

/**
 * Created by matik on 11.03.2017.
 */
public class Queue { //budowanie kolejki procesów
    private final ArrayList<Request> list=new ArrayList<Request>();

    public Queue()
    {
        list.add(new Request(42,0,false,0)); //Początkowe położenie głowicy
        list.add(new Request(51,1,true,200));
        list.add(new Request(21,50,false,0));
        list.add(new Request(45,50,false,0));
        list.add(new Request(75,50,true,100));
        list.add(new Request(12,70,false,0));
        list.add(new Request(84,90,true,50));
        list.add(new Request(36,100,true,150));
        list.add(new Request(69,110,false,0));
        list.add(new Request(80,110,true,30));

    }

    public ArrayList returnQueue()
    {
        return list;
    };
}
