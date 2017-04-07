package com.company;
import java.util.Random;

/**
 * Created by matik on 17.03.2017.
 */
public class Rand {
    private SList list = new SList();

    public Rand() {
        int tmp;
        Random rand = new Random();
        while ((tmp = rand.nextInt(14)) != 0) {
            Card card = new Card(tmp, rand.nextInt(4));
            list.add(card);
        }
    }

public SList getList() {return list;};

}