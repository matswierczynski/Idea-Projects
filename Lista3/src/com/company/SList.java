package com.company;

import java.util.Iterator;
import java.util.Iterator;

/**
 * Created by matik on 21.03.2017.
 */
public class SList implements SinglyLinked{

    private final Element _headAndTail = new Element(); //wartownik
    private int size; //dłuość listy

    public SList() {
        clear();
    }

    private void clear(){
        size = 0;
        _headAndTail.setNext(_headAndTail);
    }

    public void add(Object o)
    {
        Element element=_headAndTail.getNext();
        int index=0;
        boolean immediateStop=false;
        while (element!=_headAndTail && element.getKey()!=null && !immediateStop) {
            if (((Card) o).getValue() > ((Card) element.getKey()).getValue()) {
                index++;
                element = element.getNext();
            } else {
                if (((Card) o).getValue() < ((Card) element.getKey()).getValue()) {
                    immediateStop=true;
                }

                else {
                    if(((Card) o).getColor() < ((Card) element.getKey()).getColor()){
                        immediateStop=true;
                        index++;
                    }

                    else{immediateStop=true;}
                }
            }
        }


        insert(index,o);

    }

    public void insert(int index, Object o) throws IndexOutOfBoundsException
    {
        if(index<0 || index>getSize()) throw new IndexOutOfBoundsException();
        Element element = new Element();
        element.setKey((Card)o);
        element.AttachBefore(getPreviousElementOfIndex(index));
        size++;
    }

    private Element getElement(int index){

        Element element =_headAndTail.next;
        for(int i=index;i>0;--i)
            element=element.getNext();
        return element;
    }

    private Element getPreviousElementOfIndex(int index){

        Element element =_headAndTail;
        for(int i=index;i>0;--i)
            element=element.getNext();
        return element;
    }

    public boolean delete(int index) throws IndexOutOfBoundsException{
    checkOutofBounds(index);
    Element element;
    element=getPreviousElementOfIndex(index);
    element.detach();
    --size;
    return element!=null;
    }
    public boolean deleteColor (Object key){
        Element prevelement=_headAndTail;
        boolean isRemoved=false;
        Element element=_headAndTail.getNext();
        while (element!=_headAndTail && element.getKey()!=null) {
            if (Card.getColorFromName((String) key) == ((Card) element.getKey()).getColor()) {
                prevelement.detach();
                isRemoved=true;
                size--;
            }
            if(!isRemoved){
                prevelement = element;
            }
            else
            {isRemoved=false;}

            element = element.getNext();
        }

        return prevelement!=_headAndTail;

    }

    public boolean deleteValue (Object key){
        Element prevelement=_headAndTail;
        boolean isRemoved=false;
        Element element=_headAndTail.getNext();
        while (element!=_headAndTail && element.getKey()!=null) {
            if (Card.getValueFromName((String) key) == ((Card) element.getKey()).getValue()) {
                prevelement.detach();
                isRemoved=true;
                size--;
            }
            if(!isRemoved){
                prevelement = element;
            }
            else
            {isRemoved=false;}

            element = element.getNext();
        }

        return prevelement!=_headAndTail;

    }


    public boolean deleteDuplicates(){
        Element queue = _headAndTail.getNext();
        while(queue!=_headAndTail) {
            Element element=queue.getNext();
            Element prevelement=queue;
            while (element != _headAndTail && element.getKey() != null) {
                if (((Card) queue.getKey()).getValue() == ((Card) element.getKey()).getValue() &&
                        ((Card) queue.getKey()).getColor() == ((Card) element.getKey()).getColor()) {

                    prevelement.detach();
                    size--;
                }
                prevelement=element;
                element = element.getNext();

            }

            queue=queue.getNext();
        }

        return queue==_headAndTail;

    }


    public boolean isEmpty() {                  // zwraca true, jeśli lista jest pusta
        return (size>0);
    }



    private void checkOutofBounds(int index) throws IndexOutOfBoundsException {
        if(index <0 || index>=getSize())
            throw new IndexOutOfBoundsException();
    }



    public void searchColor(String color) {      // szukanie elementu o podanym kolorze
        ValueIterator _iterator=new ValueIterator();
        _iterator.first();
        while (_iterator.hasNext()){
            if(((Card)_iterator.get_current().getKey()).getColor()==Card.getColorFromName(color))
                System.out.println(_iterator.get_current().getKey());
                _iterator.next();
        }
    }

    public void searchValue(String value) {        //szukanie elementu o podanej wartości
        ValueIterator _iterator = new ValueIterator();
        _iterator.first();
        while (_iterator.hasNext()) {
            if (((Card) _iterator.get_current().getKey()).getValue() == Card.getValueFromName(value))
                System.out.println(_iterator.get_current().getKey());
            _iterator.next();

        }
    }

    public void showAll() { // wyświetlanie listy

        Element element = _headAndTail.getNext();
        while (element != _headAndTail) {
            System.out.println(element);
            element = element.getNext();

        }
    }
    public void nrOfElements() {               }  //wyświetlanie liczby elementów listy

    public int getSize(){
            return size;
        }


    private class Element {               ///KLASA DEFINUJĄCA ELEMENT
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

        public void setKey(Card key) {
            this.key = key;
        }

        private Element getNext() {
            return next;
        }

        private Object getKey() {
            return key;
        }

        public String toString(){ return key.toString();};

        private void AttachBefore(Element previous)
        {
            setNext(previous.getNext());
            previous.setNext(this);
        }
    }

    private final class ValueIterator implements Iterator<Element>{
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