package com.company;

import java.util.Comparator;

/**
 * Created by matik on 11.03.2017.
 */
public class RequestComparatorByMinMax implements Comparator<Request> { //porównywanie procesów po położeniu cylindra
@Override
public int compare(Request r1, Request r2)
        {
        return r1.getCylNr() > r2.getCylNr() ? +1 : r1.getCylNr() < r2.getCylNr() ? -1 : 0;
        }
}
