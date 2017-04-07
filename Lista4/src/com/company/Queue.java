package com.company;

/**
 * Created by matik on 27.03.2017.
 */
public interface Queue {
    public boolean isEmpty();  // zwraca true, jeśli lista jest pusta
    public void insert(Object o) throws IndexOutOfBoundsException;
    public Object delete() throws IndexOutOfBoundsException;
    public Object dequeue();
    public void enqueue(Object value);
    public boolean isFull();
}
