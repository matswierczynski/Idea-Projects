package com.company;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by matik on 25.03.2017.
 */
public class LRUapprox {
    private int frames;
    private int _current;
    private Page[] _queueList=null;
    private Page[] _list=null;

    public LRUapprox(int size, Page[] listQueue, Page[] list){
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
        int frcounter=0;
        int loadpagecounter=0;
        int[][] queue = new int[2][frames];
        for (int i=0;i<_queueList.length;i++){
            Page page=_list[_queueList[i].getNr()];
            if(page.isBit()==false){
                if(frcounter<frames) {
                    queue[0][frcounter]=page.getNr();
                    frcounter++;
                    loadpagecounter++;
                    page.setBit(true);
                }

                else {
                    while (_current<frames && ((queue[1][_current])!=0))
                        _current++; //wyszukiwanie ramki do której długo nie było odwołania
                    if (_current>=frames)
                        _current=0;
                    _list[queue[0][_current]].setBit(false);
                    queue[0][_current]=page.getNr();
                    page.setBit(true);
                    loadpagecounter++;
                    queue[1][_current]=0;
                    _current=0;

                }
            }
            else{
                int k=0;
                while(k<_list.length && page.getNr()!=queue[0][k])
                    k++;
                queue[1][k]=1; //ustawianie bitu odwołania do ramki na true
            }
        }
        return loadpagecounter;
    }

}
