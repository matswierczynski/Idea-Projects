package com.company;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by matik on 27.03.2017.
 */
public class List implements Queue {
    private final Element _headAndTail=new Element();
    private int size;
    private int maxSize;

    public List(int maxSize){

        size=0;
        this.maxSize=maxSize;
        _headAndTail.setNext(_headAndTail);
    }


    @Override
    public boolean isEmpty() {
        return size<=0;
    }

    @Override
    public void insert(Object o) throws StackOverflowError {
        if(!isFull()) {
            Element element = new Element();
            element.setKey(o);
            element.attach(getLastElement());
            size++;
        }
        else throw new StackOverflowError();

    }

    @Override
    public Object delete() throws NoSuchElementException {
        if(!isEmpty()){
            Element e=_headAndTail.getNext();
            _headAndTail.detach();
            size--;
            return e;
        }
        else throw new NoSuchElementException();
    }

    @Override
    public Object dequeue() {
        Object e=null;
        try {
            e=delete();
        }
        catch (NoSuchElementException ex){System.out.println("Kolejka jest pusta");}
        finally{return e;}
    }


    @Override
    public void enqueue(Object value) throws NullPointerException {
        if (value==null)
            throw new NullPointerException();
        try {
            insert(value);
        }
        catch (StackOverflowError e) {System.out.println("Kolejka jest pełna");}
    }

    @Override
    public boolean isFull() {
        return size+1>maxSize;
    }

    private Element getLastElement(){
        Element element =_headAndTail.getNext();
        while(element.getNext()!=_headAndTail)
            element=element.getNext();
        return element;
    }

    public int getMaxSize() {
        return maxSize;
    }

    protected class Element {               ///KLASA DEFINUJĄCA ELEMENT
        private Object key;
        private Element next;

        public Element() {
            this.key = null;
            this.next = null;

        }

        public Element(Object key) {
            this.key = key;
            this.next = null;

        }

        public Element(Object key, Element next) {
            this.key=key;
            this.next = next;

        }

        private void detach()
        {
            Element element=getNext().getNext();
            setNext(element);
        }


        public void setNext(Element next) {
            this.next = next;
        }

        public void setKey(Object key) {
            this.key = key;
        }

        private Element getNext() {
            return next;
        }

        public Object getKey() {
            return key;
        }

        public String toString(){ return key.toString();};

        private void attach(Element last)
        {
            setNext(last.getNext());
            last.setNext(this);
        }

    }

    private final class ValueIterator implements Iterator<Element> {
        private Element _current=_headAndTail.getNext();
        public void first()
        {
            _current=_headAndTail.getNext();
        }
        public boolean hasNext(){
            return _current!=_headAndTail;

        }

        public Element next(){
            _current=_current.getNext();
            return _current;

        }

        public Element get_current(){
            return _current;
        }

        public void remove(){
            Element __current =_headAndTail.getNext();
            while(__current.getNext()!=_current) {
                __current = __current.getNext();
            }
            __current.detach();


        }



    }
}
