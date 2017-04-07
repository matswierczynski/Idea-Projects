package com.company;

import java.util.Comparator;

/**
 * Created by matik on 04.03.2017.
 */
public class ProcessComparatorByLength implements Comparator<Process>{
    @Override
    public int compare(Process p1, Process p2)
    {
        return p1.getLength() > p2.getLength() ? +1 : p1.getLength() < p2.getLength() ? -1 : 0;
    }
}
