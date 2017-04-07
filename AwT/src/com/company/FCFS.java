package com.company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Created by matik on 04.03.2017.
 */
public class FCFS {
    Date date;
    long time;
    ArrayList<Process> queue;

    public FCFS(Queue q){
            queue=new ArrayList();
            for(int i=0;i<q.getSize();i++) {
                queue.add(q.getProcess(i));
                queue.get(i).setActualState(0);
            }
        }

    public long run()
    {

        date=new Date();
        time=date.getTime();
        long summary=0;
        int i=0;
        while(queue.isEmpty()==false) //dla wszytskich procesów w serii
        {
            i++;
            date=new Date();
            long wT=date.getTime(); //pobranie początkowego czasu rozpoczecia wykonywania kolejki
            queue.get(0).setPickedUp(i+1);            //ustawienie nr zgłoszenia
            while(queue.get(0).getActualState()<=queue.get(0).getLength()){ //wykonywanie procesu
                queue.get(0).DecreaseState();
            }
            long waitingTime=wT-time; //określenie czasu oczekiwania
            queue.remove(0);
            summary+=waitingTime;//zsumowanie czasu wykonania

        }
        return summary; //średni czas oczekiwania
    }

}
