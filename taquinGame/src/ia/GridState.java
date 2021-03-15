package ia;

import java.util.ArrayList;

public class GridState implements Cloneable{
    private final int nbLine;
    private final int nbColumn;
    private char[][] values;
    private final VoidCase caseVide;

    public GridState(char[][] values, VoidCase caseVide) {
        this.values = values;
        this.caseVide = caseVide;
        nbLine = values.length;
        nbColumn = values[nbLine-1].length;
    }

    public char[][] getValues() {
        return values;
    }

    public VoidCase getCaseVide(){
        return this.caseVide;
    }

    public void setintoValues(int x,int y, char c){
        this.values[x][y] = c;
    }
    public void setValues(char[][] values){
        this.values = values;
    }

    public ArrayList<GridState> generateNeighbors() {
        ArrayList<GridState> neighbors = new ArrayList<>();
        int x = caseVide.getPosX();
        int y = caseVide.getPosY();
        char temp;


        if (x > 0){
            GridState grid1 = (GridState) this.clone();
            temp = grid1.values[x][y];
            grid1.setintoValues(x,y, grid1.values[x-1][y]);
            grid1.setintoValues(x-1,y,temp);
            this.caseVide.setPos(x-1,y);
            neighbors.add(grid1);
        }

        if(x < nbLine-1){
            GridState grid2 = (GridState) this.clone();
            temp = grid2.values[x][y];
            grid2.setintoValues(x,y, grid2.values[x+1][y]);
            grid2.setintoValues(x+1,y,temp);
            this.caseVide.setPos(x+1,y);
            neighbors.add(grid2);
        }

        if(y > 0){
            GridState grid3 = (GridState) this.clone();
            temp = grid3.values[x][y];
            grid3.setintoValues(x,y, grid3.values[x][y-1]);
            grid3.setintoValues(x,y-1,temp);
            this.caseVide.setPos(x,y-1);
            neighbors.add(grid3);
        }

        if(y < nbColumn-1){
            GridState grid4 = (GridState) this.clone();
            temp = grid4.values[x][y];
            grid4.setintoValues(x,y, grid4.values[x][y+1]);
            grid4.setintoValues(x,y+1,temp);
            this.caseVide.setPos(x,y+1);
            neighbors.add(grid4);
        }
        return neighbors;
    }

    public void printState(){
        int m = this.nbLine;
        int n = this.nbColumn;
        for(int i = 0 ; i < m ;i ++){
            for(int j = 0; j < n ; j++){
                System.out.print(this.values[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof GridState) {
            GridState stateTaquin = (GridState) object;

            // Compare 2 états

            for (int i = 0; i < this.nbLine; i++) {
                for (int n = 0; n < this.nbColumn; n++) {
                    if (this.values[i][n] != stateTaquin.values[i][n]) {
                        return false;
                    }
                }
            }

            return true;
        }

        return false;
    }

    @Override
    public Object clone() {
        GridState taquinstate = new GridState(this.values,this.caseVide);

        char[][] values = new char[this.nbLine][this.nbColumn];

        // Copie manuellement le tableau de char
        for (int i = 0; i < this.nbLine; i++) {
            for (int n = 0; n < this.nbColumn; n++) {
                values[i][n] = this.getValues()[i][n];
            }
        }
        taquinstate.setValues(values);
        return taquinstate;
    }
}
