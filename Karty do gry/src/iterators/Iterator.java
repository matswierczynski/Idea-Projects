package iterators;

/**
 * Created by matik on 18.03.2017.
 */
public interface Iterator {

    public void previous();
    public void next();
    public void first();
    public void last();
    public boolean isDone();
    public Object current();

}