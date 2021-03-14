package ia;

import java.util.ArrayList;

public class GridState implements Cloneable{
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

        System.out.println("Avant");
        this.printState();
        System.out.println();

        if (x > 0){
            char[][] temp1 = this.values.clone();
            temp1[x][y] = temp1[x-1][y];
            temp1[x-1][y] = ' ';
            GridState grid1 = new GridState(nbLine,nbColumn,temp1,new VoidCase(x-1,y));
            neighbors.add(grid1);

            System.out.println("grid1");
            grid1.printState();
            System.out.println();
        }

        if(x < nbColumn-1){
            char[][] temp2 = this.values.clone();
            this.printState();
            temp2[x][y] = temp2[x+1][y];
            this.printState();
            temp2[x+1][y] = ' ';
            this.printState();
            GridState grid2 = new GridState(nbLine,nbColumn,temp2,new VoidCase(x+1,y));
            neighbors.add(grid2);

            System.out.println("grid2");
            grid2.printState();
            System.out.println();
        }

        if(y > 0){
            char[][] temp3 = this.values.clone();
            temp3[x][y] = temp3[x][y-1];
            temp3[x][y-1] = ' ';
            GridState grid3 = new GridState(nbLine,nbColumn,temp3,new VoidCase(x,y-1));
            neighbors.add(grid3);

            System.out.println("grid3");
            grid3.printState();
            System.out.println();
        }

        if(y < nbLine-1){
            char[][] temp4 = this.values.clone();
            temp4[x][y] = temp4[x][y+1];
            temp4[x][y+1] = ' ';
            GridState grid4 = new GridState(nbLine,nbColumn,temp4,new VoidCase(x,y+1));
            neighbors.add(grid4);

            System.out.println("grid4");
            grid4.printState();
            System.out.println();
        }

        return neighbors;
    }

    public void printState(){
        int m = this.getNbLine();
        int n = this.getNbColumn();
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

            // Compare 2 states

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
}
