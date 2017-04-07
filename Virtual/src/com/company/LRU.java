package com.company;

/**
 * Created by matik on 25.03.2017.
 */
public class LRU {
    private int frames;
    private Page[] _queueList=null;
    private Page[] _list=null;

    public LRU(int size, Page[] listQueue, Page[] list){
        if(size>0) {
            frames=size;
            _list=list;
            _queueList=listQueue;
        }
    }

    private  void clear(){
        for(int i=0;i<_list.length;i++) {
            _list[i].setBit(false);
            _list[i].setUsedTime(0);
        }
    }

    public int handle(){
        clear();
        long lastUsed=0;
        int frcounter=0;
        int loadpagecounter=0;
        int framenr=0;
        int[] queue = new int[frames];
        for (int i=0;i<_queueList.length;i++){
            Page page=_list[_queueList[i].getNr()];
            if(page.isBit()==false) {
                if (frcounter < frames) {
                    queue[frcounter] = page.getNr();
                    frcounter++;
                    loadpagecounter++;
                    page.setBit(true);
                    page.setUsedTime(System.nanoTime());
                }
                else {
                    long currentTime = System.nanoTime();
                    for (int k = 0; k < frames; k++) {
                       // System.out.println(currentTime-_list[queue[k]].getUsedTime()+" "+_list[queue[k]].isBit());
                        if (currentTime - _list[queue[k]].getUsedTime() > lastUsed) {
                            lastUsed = currentTime - _list[queue[k]].getUsedTime();
                            framenr = k;
                        }

                    }
                 //   System.out.println("Wywłaszczono: "+framenr);
                    lastUsed = 0;
                    _list[queue[framenr]].setBit(false);
                    _list[queue[framenr]].setUsedTime(0);
                    queue[framenr] = page.getNr();
                    page.setBit(true);
                    loadpagecounter++;
                    page.setUsedTime(System.nanoTime());
                }
            }

            else {
                page.setUsedTime(System.nanoTime());
            }

        }
        return loadpagecounter;
    }
}
