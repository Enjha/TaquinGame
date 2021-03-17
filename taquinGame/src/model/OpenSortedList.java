package model;

import ia.GridState;

import java.util.ArrayList;

public class OpenSortedList extends OpenList {

    public OpenSortedList(ArrayList<GridState> sortedList) {
        super(sortedList);
    }

    @Override
    public GridState getHead() {
        return this.openlist.get(0);
    }
}
