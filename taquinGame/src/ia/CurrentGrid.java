package ia;

import java.util.ArrayList;

public class CurrentGrid{

    private final Grid grid;

    public CurrentGrid(Grid grid) {
        this.grid = grid;
    }

    public Node getCaseVide(){return grid.getCaseVide();}
    public Node[][] getValues(){return grid.getValues();}

    public ArrayList<Grid> getStatesNeighbor() {
        int nbLine = this.grid.getNbLine();
        int nbColumn = this.grid.getNbColumn();
        Node[][] values = grid.getValues();
        ArrayList<Grid> statesNeighbour = new ArrayList<>();
        int x = getCaseVide().getXposition();
        int y = getCaseVide().getYposition();

        if (x - 1 >= 0) {
            Node[][] values1 = this.getValues();
            values1[x][y] = values1[x-1][y];
            Grid grid1 = new Grid(nbLine,nbColumn,values,new Node(x-1,y,' '));
            statesNeighbour.add(grid1);
        } else if (x + 1 < nbLine) {
            Node[][] values2 = this.getValues();
            values2[x][y] = values2[x+1][y];
            Grid grid2 = new Grid(nbLine,nbColumn,values,new Node(x+1,y,' '));
            statesNeighbour.add(grid2);
        } else if (y - 1 >= 0) {
            Node[][] values3 = this.getValues();
            values3[x][y] = values3[x][y-1];
            Grid grid3 = new Grid(nbLine,nbColumn,values,new Node(x,y-1,' '));
            statesNeighbour.add(grid3);
        } else if (y + 1 < nbColumn) {
            Node[][] values4 = this.getValues();
            values4[x][y] = values4[x][y+1];
            Grid grid4 = new Grid(nbLine,nbColumn,values,new Node(x,y+1,' '));
            statesNeighbour.add(grid4);
        }
        return statesNeighbour;
    }

}
