package Iterators;

import com.company.Student;

/**
 * Created by matik on 13.03.2017.
 */
public class Predicate {

    public boolean accept(Object ob) {
        return ((Student) ob).getSrednia() > 3.5;
    }
}
