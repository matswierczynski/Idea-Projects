package com.company;

import java.util.Random;

/**
 * Created by matik on 04.03.2017.
 */
public class Generate { //generator losowych ciągów o n-procesach

    //tablica serii i procesów w serii
    Process[][] pr;

    public Generate()
    {
        //ilość serii procesów
        int series=20;
        pr = new Process[series][];
        Random rand = new Random();
        for (int i = 0; i < series; i++) {
            //ilość procesów w serii
            int seriesL = (rand.nextInt(100))+1;
            pr[i] = new Process[seriesL];
            for (int k = 0; k < seriesL; k++) {
                //długość procesu
                int processL = rand.nextInt(20000000);
                Process process = new Process(k+1, processL, 0);
                pr[i][k] = process;
            }
        }
    }

    public Process[][] getProcessess()
    {
        return pr;
    } //zwraca tablicę procesów

    }
