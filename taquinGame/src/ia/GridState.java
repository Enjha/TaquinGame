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

    public ArrayList<GridState> generateNeighbors(){
        ArrayList<GridState> neighbors = new ArrayList<>();
        int x = caseVide.getPosX();
        int y = caseVide.getPosY();
        if (x > 0){
            char[][] valuesTemp1 = getValues().clone();
            valuesTemp1[x][y] = values[x-1][y];
            valuesTemp1[x-1][y] = ' ';
            neighbors.add(new GridState(nbLine,nbColumn,valuesTemp1,new VoidCase(x-1,y)));
        }
        if(x < nbColumn-1){
            char[][] valuesTemp2 = getValues().clone();
            valuesTemp2[x][y] = values[x+1][y];
            valuesTemp2[x+1][y] = ' ';
            neighbors.add(new GridState(nbLine,nbColumn,valuesTemp2,new VoidCase(x+1,y)));
        }
        if(y > 0){
            char[][] valuesTemp3 = getValues().clone();
            valuesTemp3[x][y] = values[x][y-1];
            valuesTemp3[x][y-1] = ' ';
            neighbors.add(new GridState(nbLine,nbColumn,valuesTemp3,new VoidCase(x,y-1)));
        }
        if(y < nbLine-1){
            char[][] valuesTemp4 = getValues().clone();
            valuesTemp4[x][y] = values[x][y+1];
            valuesTemp4[x][y+1] = ' ';
            neighbors.add(new GridState(nbLine,nbColumn,valuesTemp4,new VoidCase(x,y+1)));
        }
        this.printState();
        return neighbors;
    }

    public void printState(){
        int m = this.getNbLine();
        int n = this.getNbColumn();
        for(int i = 0 ; i < m ;i ++){
            for(int j = 0; j < n ; j++){
                System.out.print(values[i][j]);
            }
            System.out.println();
        }
    }
}
