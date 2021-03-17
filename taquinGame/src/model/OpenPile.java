package model;

import ia.GridState;

import java.util.ArrayList;

public class OpenPile extends OpenList {

    public OpenPile(ArrayList<GridState> pile) {
        super(pile);
    }

    @Override
    public GridState getHead() {
        return this.openlist.get(this.openlist.size() - 1);
    }
}
