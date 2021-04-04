package utils;

import ia.GridState;

import java.util.Comparator;

public class ComparatorList implements Comparator<GridState> {

    private final int heuristique;

    public ComparatorList(int heuristique) {
        this.heuristique = heuristique;
    }

    @Override
    public int compare(GridState o1, GridState o2) {
        switch (heuristique) {
            case 1:
                return Integer.compare(o1.getH1(), o2.getH1());
            case 2:
                return Integer.compare(o1.getH2(), o2.getH2());
            case 3:
                return Integer.compare(o1.getH3(), o2.getH3());
        }
        return Integer.compare(o1.getH3(), o2.getH3());
    }

}
