package com.company;

/**
 * Created by matik on 13.03.2017.
 */
public class Uczelnia implements Iterator{

    private final int _first;
    private final int _last;
    private int _current=-1;
    private final Object[] _object;

    public Uczelnia(Object [] obj)
    {
       _object=obj;
       _first=0;
       _last=obj.length-1;

    }

    public void previous()
    {
        --_current;

    }

    public void next()
    {

        ++_current;

    }

    public void first()
    {
       _current=_first;
    }

    public void last()
    {

        _current=_last;

    }

    public boolean isDone()
    {
        return _current<_first || _current>_last;

    }

    public Object current()
    {

        return  _object[_current];

    }


}
