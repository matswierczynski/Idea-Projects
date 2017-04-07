package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Created by matik on 04.03.2017.
 */
public class Queue {
    ArrayList<Process> queue=new ArrayList();

    public Queue(Process[][] pr, int index) {
        for (int i = 0; i < pr[index].length; i++) {
            queue.add(pr[index][i]);
        }
    }

    public void modifiedTime(int index)
    {
        Date date = new Date();
       Process pr= queue.get(index);
       pr.setDate(date.getTime());
        queue.set(index,pr);
    }

        public void shuffleQueue()
    {
        Collections.shuffle(queue);
    }

    public void sortQueue()
    {
        Collections.sort(queue,new ProcessComparatorByLength());
    }

    public Process getProcess(int index)
    {
        return queue.get(index);
    }

    public int getSize()
    {
        return queue.size();
    }

    }
