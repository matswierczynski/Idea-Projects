package iterators;

import java.util.ArrayList;

/**
 * Created by matik on 18.03.2017.
 */
public class Deck implements Iterator{

    final ArrayList _array;
    final int _first;
    final int _last;
    int _current=-1;

    public Deck(ArrayList array, int start, int length)
    {_array=array;
        _first=start;
        _last=start+length-1;
    }

    public Deck(ArrayList array)
    {_array=array;
        _first=0;
        _last=array.size()-1;
    }
    public void first()
    { _current=_first; }
    public void last()
    { _current=_last; }
    public void next()
    {++_current;}

    public void previous()
    {--_current; }
    public boolean isDone()
    {return _current <_first || _current> _last; }
    public Object current()
    { return _array.get(_current);}
}
