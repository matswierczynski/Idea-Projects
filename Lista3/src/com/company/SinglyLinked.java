package com.company;

/**
 * Created by matik on 21.03.2017.
 */
public interface SinglyLinked {
    public boolean isEmpty();  // zwraca true, jeśli lista jest pusta
    public void add(Object o) throws IndexOutOfBoundsException;  // wstawianie nowego elementu do listy
    public void insert(int index, Object o) throws IndexOutOfBoundsException;
    public boolean delete(int index) throws IndexOutOfBoundsException;
    public boolean  deleteColor (Object o);
    public boolean deleteValue (Object key);
    public void searchColor(String color); // szukanie podanego elementu,
    public void searchValue(String value);
    public void showAll(); // wyświetlanie listy
    public void nrOfElements();

}
