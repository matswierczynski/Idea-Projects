package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by matik on 25.03.2017.
 */
public class RAND {
    private int frames;
    private int _current;
    private Page[] _queueList=null;
    private Page[] _list=null;

    public RAND(int size, Page[] listQueue, Page[] list){
        if(size>0) {
            frames=size;
            _list=list;
            _queueList=listQueue;
        }
    }

    private  void clear(){
        for(int i=0;i<_list.length;i++)
            _list[i].setBit(false);
    }


    public int handle(){
        clear();
        _current=0;
        Random rand = new Random();
        int frcounter=0;
        int loadpagecounter=0;
        int[] queue = new int[frames];
        for (int i=0;i<_queueList.length;i++){
            Page page=_list[_queueList[i].getNr()];
            if(page.isBit()==false){
                if(frcounter<frames) {
                    queue[frcounter]=page.getNr();
                    frcounter++;
                    loadpagecounter++;
                    page.setBit(true);
                }

                else {
                    _current=rand.nextInt(frames);
                    _list[queue[_current]].setBit(false);
                    queue[_current]=page.getNr();
                    page.setBit(true);
                    loadpagecounter++;

                }
            }
        }
        return loadpagecounter;
    }


}
