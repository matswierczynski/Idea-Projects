package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Created by matik on 08.03.2017.
 */
public class SJFLT {
    Date date;
    long time;
    ArrayList<Process> queue;

    public SJFLT(Queue q) {
        queue = new ArrayList();
        for (int i = 0; i < q.getSize(); i++)
            queue.add(q.getProcess(i));
    }


    public long run()
    {
        date = new Date();
        time = date.getTime();
        long summary = 0;
        Collections.sort(queue,new ProcessComparatorByLength());


        for (int k = 0; k < queue.size(); k++) {
            queue.get(k).setDate();     //przypisanie czasu ropoczęcia wykonywania kolejki
        }

        while (queue.isEmpty() == false) { //dla niepustej kolejki
            for (int i = 0; i < queue.size(); i++) { //dla wszystkich elementów kolejki
                date = new Date();
                long wT = date.getTime(); //pobranie aktualnego czasu
                summary += wT - queue.get(i).getDate();   //zsumowanie czasu oczekiwania na pierwsze wykonanie

                try {
                    //Ustawianie czasu wywłaszczenia
                    for (int k = 0; k < 200000; k++) { //wykonywanie procesu przez dany czas lub do zakończenia
                        queue.get(i).DecreaseState();

                        if (queue.get(i).getActualState() >= queue.get(i).getLength()) //zakończenie procesu przed czasem
                            throw new IndexOutOfBoundsException();
                    }
                    date = new Date();  //zapisanie momentu wywłaszczenia niezakończonego procesu
                    queue.get(i).setDate();
                } catch (IndexOutOfBoundsException e) {
                    queue.remove(i); //usunięcie zakończonego procesu z kolejki
                }

            }

        }
        return summary; //średni czas oczekiwania
    }
}

