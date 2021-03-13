package ia;

import java.util.ArrayList;

public class GridState {
    private final int nbLine;
    private final int nbColumn;
    private final char[][] values;
    private final VoidCase caseVide;

    public GridState(int nbLine, int nbColumn, char[][] values, VoidCase caseVide) {
        this.nbLine = nbLine;
        this.nbColumn = nbColumn;
        this.values = values;
        this.caseVide = caseVide;
    }

    public int getNbLine() {
        return nbLine;
    }
    public int getNbColumn() {
        return nbColumn;
    }
    public char[][] getValues() {
        return values;
    }
    public VoidCase getCaseVide(){
        return caseVide;
    }

    public ArrayList<GridState> generateNeighbors(){
        ArrayList<GridState> neighbors = new ArrayList<>();
        int x = caseVide.getPosX();
        int y = caseVide.getPosY();
        if ((x-1) >= 0){
            char[][] valuesTemp1 = values;
            valuesTemp1[x][y] = values[x-1][y];
            neighbors.add(new GridState(nbLine,nbColumn,valuesTemp1,new VoidCase(x-1,y)));
        }
        if((x+1) <= (nbColumn-1)){
            char[][] valuesTemp2 = values;
            valuesTemp2[x][y] = values[x+1][y];
            neighbors.add(new GridState(nbLine,nbColumn,valuesTemp2,new VoidCase(x+1,y)));
        }
        if((y-1) >= 0){
            char[][] valuesTemp3 = values;
            valuesTemp3[x][y] = values[x][y-1];
            neighbors.add(new GridState(nbLine,nbColumn,valuesTemp3,new VoidCase(x,y-1)));
        }
        if((y+1) <= (nbLine-1)){
            char[][] valuesTemp4 = values;
            System.out.println(y +" "+x);
            valuesTemp4[x][y] = values[x][y+1];
            neighbors.add(new GridState(nbLine,nbColumn,valuesTemp4,new VoidCase(x,y+1)));
        }
        return neighbors;
    }
}
