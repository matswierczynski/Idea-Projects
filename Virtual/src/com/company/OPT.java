package com.company;

/**
 * Created by matik on 25.03.2017.
 */
public class OPT {
    private int frames;
    private Page[] _queueList=null;
    private Page[] _list=null;

    public OPT(int size, Page[] listQueue, Page[] list){
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
        int _current=0;
        int maxIdle=0;
        int frcounter=0;
        int loadpagecounter=0;
        int framenr=0;
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
                    for(int k=0;k<frames;k++){
                            for(int j=_queueList.length-1;j>=i;j--){
                                if(queue[k]==_queueList[j].getNr()){
                                    _current=j;
                                    j=0;
                                }
                                if(_current>maxIdle){
                                    maxIdle=_current;
                                    framenr=k;
                            }
                        }
                        _current=0;
                    }
                    if (maxIdle>0) {
                        _list[_queueList[maxIdle].getNr()].setBit(false);
                        queue[framenr] = page.getNr();
                        page.setBit(true);
                        loadpagecounter++;
                    }
                    else {
                        _list[queue[0]].setBit(false);
                        queue[0] = page.getNr();
                        loadpagecounter++;
                        page.setBit(true);
                    }

                }
            }
        }
        return loadpagecounter;
    }
}
