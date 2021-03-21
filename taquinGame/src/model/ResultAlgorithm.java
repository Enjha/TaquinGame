package model;

import ia.GridState;

public class ResultAlgorithm {

    private GridState resultGrid;
    private float timeNeeded;

    public ResultAlgorithm(GridState resultGrid, float timeNeeded) {
        this.resultGrid = resultGrid;
        this.timeNeeded = timeNeeded;
    }

    public GridState getResultGrid() {
        return resultGrid;
    }

    public float getTimeNeeded() {
        return timeNeeded;
    }
}
