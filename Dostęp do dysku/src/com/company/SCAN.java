package com.company;

import javax.sql.rowset.spi.SyncResolver;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by matik on 11.03.2017.
 */
public class SCAN {

        private ArrayList<Request> list;
        public SCAN(ArrayList l) {
            list = new ArrayList<Request>(l);

        }

    public int handle() {
        int sum = 0;
        int k = 0;

        ArrayList<Request> list1 = new ArrayList<Request>();


        while(list.size()>1) { //dodawanie procesów na drodze igły w górę

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
            list.add(list1.get(0));
            if(list.size()>1) {
                sum += 99 - list1.get(0).getCylNr();
            }

            k=list.size()-1;
            for (int i =list.size() - 1;i>0; i--) {
                if (list.get(i-1).getCylNr() < list.get(k).getCylNr()) {
                    list1.add(list.get(i - 1));
                    k = i;
                } else {
                    k++;
                }
                k--;

            }


            while(list1.size()>1) {
                sum += Math.abs(list1.get(1).getCylNr() - list1.get(0).getCylNr());
                list.remove(list1.get(0));
                list1.remove(0);
            }
            if(list.size()>1) {
                sum += list1.get(0).getCylNr();
            }
            list.remove(list1.get(0));
            list.add(0,list1.get(0));
            list1.clear();


                }
        return sum;
    }
}

