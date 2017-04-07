package com.company;

import java.util.ArrayList;

/**
 * Created by matik on 11.03.2017.
 */
public class EDF {

    private ArrayList<Request> list;

    public EDF(ArrayList l) {
        list = new ArrayList<Request>(l);

    }

    public int handle() {
        int sum = 0;
        int k = 0;
        ArrayList<Request> list1 = new ArrayList<Request>();


        while (list.size() > 1) {

            for (int i = 0; i < list.size(); i++) { //lista z procesami priorytetowymi
                if (list.get(i).isPriority() == true) {
                    list1.add(list.get(i));
                    list.remove(i);
                    i--;

                }
            }
                list1.sort(new RequestComparatorByPriority());  //sortowanie procesów priorytetowych po deadline'ach

                sum = Math.abs(list.get(0).getCylNr() - list1.get(0).getCylNr());  //wykonywanie procesów priorytetowych
                while (list1.size() > 1) {
                    sum += Math.abs(list1.get(1).getCylNr() - list1.get(0).getCylNr());
                    list1.remove(0);
                }
                list.remove(0);
                sum += Math.abs(list1.get(0).getCylNr() - list.get(0).getCylNr());

                while (list.size() > 1) {
                    sum += Math.abs(list.get(1).getCylNr() - list.get(0).getCylNr());
                    list.remove(0);
                }


            }

        return sum;
    }
}

