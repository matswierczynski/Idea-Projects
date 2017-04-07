package com.company;

import java.util.ArrayList;

/**
 * Created by matik on 11.03.2017.
 */
public class FCFS {
    private ArrayList<Request> list;

    public FCFS(ArrayList l)
    {
        list = new ArrayList<Request>(l);
    }

    public int handle()
    {
        int sum=0;
        int size=list.size();
        for(int i=0;i<size-1;i++)
        {
           sum+=Math.abs(list.get(1).getCylNr()-list.get(0).getCylNr());
           list.remove(0);
        }
        return sum;
    }
}
