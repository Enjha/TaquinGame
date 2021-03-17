package model;

import ia.GridState;

import java.util.ArrayList;

public class OpenQueue extends OpenList {

    public OpenQueue(ArrayList<GridState> queue) {
        super(queue);
    }

    @Override
    public GridState getHead() {
        return this.openlist.get(0);
    }
}
