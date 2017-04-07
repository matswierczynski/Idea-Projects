package com.company;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by matik on 17.03.2017.
 */
public class Rand {
    private ArrayList<Card> list = new ArrayList<Card>();

    public Rand() {
        int tmp;
        list.ensureCapacity(200);
        Random rand = new Random();
        while ((tmp = rand.nextInt(15)) != 0) {
            Card card = new Card(tmp, rand.nextInt(4));
            tmp = 0;
            int i = -1;
            while ((++i < list.size()) && (list.get(i).getValue() <= card.getValue())) {
                if (list.get(i).getValue() == card.getValue()) {
                    if (list.get(i).getColor() >= card.getColor()) {
                        return;
                    }
                }
            }

            list.add(i, card);
        }
    }

    public void show()
    {
        for(Card x: list){
            System.out.println(x);
        }
    }

    public ArrayList<Card> getList() {
        return list;
    }

    public int getSize()
    {
        return list.size();
    }
}