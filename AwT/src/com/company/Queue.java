package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Created by matik on 04.03.2017.
 */
public class Queue { //na podstawie wygenerowanych ciągów tworzy kolejkę procesów
    ArrayList<Process> queue=new ArrayList(); //kolejka procesów

    public Queue(Process[][] pr, int index) { //z tablicy tworzy ArrayList
        for (int i = 0; i < pr[index].length; i++) {
            queue.add(pr[index][i]);
        }
    }


    public void shuffleQueue()
    {
        Collections.shuffle(queue);
    } //mieszanie kolejki

    public Process getProcess(int index)
    {
        return queue.get(index);
    }

    public int getSize()
    {
        return queue.size();
    }




}