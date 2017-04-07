package com.company;

import java.util.Comparator;

/**
 * Created by matik on 11.03.2017.
 */
public class RequestComparatorByPriority implements Comparator<Request> { //sortowanie po kolejności obsługi priorytetów
    @Override
    public int compare(Request r1, Request r2)
    {
        return r1.getPrTime() > r2.getPrTime() ? +1 : r1.getPrTime() < r2.getPrTime() ? -1 : 0;
    }
}