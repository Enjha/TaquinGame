package utils;

import ia.GridState;

import java.util.Comparator;

public class ComparatorList implements Comparator<GridState> {

    private int heuristique;

    public ComparatorList(int heuristique) {
        this.heuristique = heuristique;
    }

    @Override
    public int compare(GridState o1, GridState o2) {
        switch (heuristique) {
            case 1:
                return Integer.compare(o1.getG(), o2.getG());
            case 2:
                return Integer.compare(o1.getH(), o2.getH());
            case 3:
                return Integer.compare(o1.getF(), o2.getF());
            default:
                return 0;
        }
    }

}
