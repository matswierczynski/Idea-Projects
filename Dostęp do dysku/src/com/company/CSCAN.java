package com.company;

import java.util.ArrayList;

/**
 * Created by matik on 11.03.2017.
 */
public class CSCAN {

    private ArrayList<Request> list;
    public CSCAN(ArrayList l) {
        list = new ArrayList<Request>(l);

    }

    public int handle() {
        int sum = 0;
        int k = 0;
        ArrayList<Request> list1 = new ArrayList<Request>();


        while(list.size()>1) {

            k=0;
            list1.add(list.get(0));
            for(int i=0;i<list.size()-1;i++) {
                if (list.get(k).getCylNr() < list.get(i + 1).getCylNr()) {
                    list1.add(list.get(i + 1));
                    k=i;
                }
                else {
                    k--;
                }
                k++;

            }

            while(list1.size()>1) {
                sum += Math.abs(list1.get(1).getCylNr() - list1.get(0).getCylNr());
                list.remove(list1.get(0));
                list1.remove(0);
            }
            list.remove(list1.get(0));
            if(list.size()>1) {
                sum += 99 - list1.get(0).getCylNr()+99+list.get(0).getCylNr();
            }

            list1.clear();


        }



        return sum;
    }
}
