package com.company;

/**
 * Created by matik on 03.04.2017.
 */
public class Firma extends List {
    public Firma (int size) {super(size);}
    public Warehouse addWarehouses(){
        Warehouse wh = Warehouse.addWarehouse();
        try {
            super.enqueue(wh);
        }
        catch (NullPointerException e){System.out.println("Podany obiekt jest pusty");}
        return wh;
    }
    public Warehouse removeWarehouses(){
        Object o = null;
        o = super.dequeue();
        if(o==null)
            return null;
        return ((Warehouse)((Element)o).getKey());

    }

}
