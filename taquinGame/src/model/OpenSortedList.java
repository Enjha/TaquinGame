package model;

import ia.GridState;
import utils.ComparatorList;

import java.util.ArrayList;

public class OpenSortedList extends OpenList {

    public OpenSortedList(ArrayList<GridState> sortedList) {
        super(sortedList);
    }

    @Override
    public GridState getHead() {
        return this.openlist.get(0);
    }

    @Override
    public void add(GridState grid){
        this.openlist.add(grid);
        this.openlist.sort(new ComparatorList());
    }

    @Override
    public void remove(GridState grid) {
        this.openlist.remove(grid);
        this.openlist.sort(new ComparatorList());
    }
}
