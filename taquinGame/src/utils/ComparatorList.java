package utils;

import ia.GridState;

import java.util.Comparator;

public class ComparatorList implements Comparator<GridState> {

    @Override
    public int compare(GridState o1, GridState o2) {
        return Integer.compare(o1.getF(), o2.getF());
    }

}
