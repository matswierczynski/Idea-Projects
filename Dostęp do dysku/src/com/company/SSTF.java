package com.company;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by matik on 11.03.2017.
 */
public class SSTF {
    private ArrayList<Request> list;

    public SSTF(ArrayList<Request> l) {
        list = new ArrayList<Request>(l);
        list.sort(new RequestComparatorByMinMax());
    }

    public int handle() {
        int sum = 0;
        int k = 0;
        int startIndex = -1;
        int nextIndex = 0;
        int size = list.size();
        ArrayList<Request> list1 = new ArrayList<Request>(); //kolejka w górę
        ArrayList<Request> list2 = new ArrayList<Request>(); //kolejka w dół
        while (startIndex < 0) {
            if (list.get(k).getCylNr() == 42) //wyszukiwanie początkowego położenia głowicy po sortowaniu
                startIndex = k;
            k++;
        }
        if (startIndex == 0) //sprawdzanie czy jesteśmy na początku kolejki
            nextIndex = 1;
        else {
            if (startIndex == list.size() - 1) //sprawdzamy czy jesteśmy na końcu kolejki
                nextIndex = list.size() - 2;
            else {                                //sprawdzamy czy idziemy w górę czy w dół
                if (Math.abs(list.get(startIndex).getCylNr() - list.get(startIndex + 1).getCylNr()) <
                        (Math.abs(list.get(startIndex).getCylNr() - list.get(startIndex - 1).getCylNr()))) {
                    nextIndex = startIndex + 1;
                } else {
                    nextIndex = startIndex - 1;
                }
            }
        }

        if (nextIndex - startIndex > 0) {  //budowanie dwóch kolejek

            for (int i = startIndex; i < list.size(); i++)
                list1.add(list.get(i));
            list2.add(list.get(list.size() - 1));
            for (int i = startIndex - 1; i >= 0; i--)
                list2.add(list.get(i));
        } else {
            for (int i = startIndex; i > 0; i--)
                list1.add(list.get(i));
            list2.add(list.get(0));
            for (int i = startIndex + 1; i < list.size(); i++)
                list2.add(list.get(i));
        }

        list = list1;
        while(list.size()>1) {
            sum += Math.abs(list.get(1).getCylNr() - list.get(0).getCylNr());
            list.remove(0);
            if (list.size() <= 1)
                list = list2;

        }
        return sum;
    }
}
