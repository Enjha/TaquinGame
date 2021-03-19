package model;

import ia.GridState;

import java.util.ArrayList;

public abstract class OpenList {

    public final ArrayList<GridState> openlist;

    public OpenList(ArrayList<GridState> openlist) {
        this.openlist = openlist;
    }

    public abstract GridState getHead();

    public void add(GridState grid) {
        this.openlist.add(grid);
    }

    public void remove(GridState grid) {
        this.openlist.remove(grid);
    }

    public boolean contains(GridState grid) {
        for (GridState gridState : this.openlist) {
            if (grid.equals(gridState))
                return true;
        }
        return false;
    }

    public int size() {
        return this.openlist.size();
    }

    public boolean isEmpty() {
        return this.openlist.size() == 0;
    }

}
