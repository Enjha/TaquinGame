package model;

import ia.GridState;
import utils.ComparatorList;

import java.util.ArrayList;

public class OpenSortedList extends OpenList {

    private int heuristique;

    public OpenSortedList(ArrayList<GridState> sortedList, int heuristique) {
        super(sortedList);
        this.heuristique = heuristique;
    }

    @Override
    public GridState getHead() {
        return this.openlist.get(0);
    }

    @Override
    public void add(GridState grid) {
        this.openlist.add(grid);
        this.openlist.sort(new ComparatorList(this.heuristique));
    }

    @Override
    public void remove(GridState grid) {
        this.openlist.remove(grid);
        this.openlist.sort(new ComparatorList(this.heuristique));
    }
}
