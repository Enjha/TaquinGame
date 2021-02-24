package ia;

import java.util.ArrayList;

public class TaquinGame {
    private final Grid startingValues;
    private final Grid resultsValues;

    public TaquinGame(Grid startingValues, Grid resultsValues) {
        this.startingValues = startingValues;
        this.resultsValues = resultsValues;
    }
    public Grid getStartingValues(){ return startingValues; }
    public Grid getResultsValues() { return resultsValues; }

    public ArrayList<Grid> getStatesNeighbor(Grid grid) {
        int nbLine = grid.getNbLine();
        int nbColumn = grid.getNbColumn();
        char[][] values = grid.getValues();
        ArrayList<Grid> statesNeighbour = new ArrayList<>();
        int x = grid.getXcaseVide();
        int y = grid.getYcaseVide();

        if (x - 1 >= 0) {
            char[][] values1 = grid.getValues();
            values1[x][y] = values1[x-1][y];
            Grid grid1 = new Grid(nbLine,nbColumn,values,new Node(x-1,y,' '));
            statesNeighbour.add(grid1);
        } else if (x + 1 < nbLine) {
            char[][] values2 = grid.getValues();
            values2[x][y] = values2[x+1][y];
            Grid grid2 = new Grid(nbLine,nbColumn,values,new Node(x+1,y,' '));
            statesNeighbour.add(grid2);
        } else if (y - 1 >= 0) {
            char[][] values3 = grid.getValues();
            values3[x][y] = values3[x][y-1];
            Grid grid3 = new Grid(nbLine,nbColumn,values,new Node(x,y-1,' '));
            statesNeighbour.add(grid3);
        } else if (y + 1 < nbColumn) {
            char[][] values4 = grid.getValues();
            values4[x][y] = values4[x][y+1];
            Grid grid4 = new Grid(nbLine,nbColumn,values,new Node(x,y+1,' '));
            statesNeighbour.add(grid4);
        }
        return statesNeighbour;
    }


    public void start(){

    }
}
