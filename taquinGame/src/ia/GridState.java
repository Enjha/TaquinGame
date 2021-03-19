package ia;

import java.util.ArrayList;

public class GridState implements Cloneable {
    private final int nbLine;
    private final int nbColumn;
    private char[][] values;
    private int caseVidePosX;
    private int caseVidePosY;
    private GridState parent;
    private final ArrayList<GridState> neighbors;

    public GridState(char[][] values, int caseVidePosX, int caseVidePosY) {
        this.values = values;
        this.caseVidePosX = caseVidePosX;
        this.caseVidePosY = caseVidePosY;
        nbLine = values.length;
        nbColumn = values[nbLine - 1].length;
        this.neighbors = new ArrayList<>();
        this.setParent(this.getParent());
    }

    public char[][] getValues() {
        return values;
    }

    public void setintoValues(int x, int y, char c) {
        this.values[x][y] = c;
    }

    public void setValues(char[][] values) {
        this.values = values;
    }

    public void setCaseVidePosX(int x) {
        this.caseVidePosX = x;
    }

    public void setCaseVidePosY(int y) {
        this.caseVidePosY = y;
    }

    public GridState getParent() {
        return this.parent;
    }

    public void setParent(GridState parent) {
        this.parent = parent;
    }


    public ArrayList<GridState> generateNeighbors(GridState solution, int heuristiqueType) {
        int x = this.caseVidePosX;
        int y = this.caseVidePosY;
        char voidChar = this.values[x][y];

        if (x > 0) {
            GridState grid1 = this.clone();
            grid1.setintoValues(x, y, grid1.values[x - 1][y]);
            grid1.setintoValues(x - 1, y, voidChar);
            grid1.setCaseVidePosX(x - 1);
            grid1.setCaseVidePosY(y);

            neighbors.add(grid1);
        }

        if (x < nbLine - 1) {
            GridState grid2 = this.clone();
            grid2.setintoValues(x, y, grid2.values[x + 1][y]);
            grid2.setintoValues(x + 1, y, voidChar);
            grid2.setCaseVidePosX(x + 1);
            grid2.setCaseVidePosY(y);

            neighbors.add(grid2);
        }

        if (y > 0) {
            GridState grid3 = this.clone();
            grid3.setintoValues(x, y, grid3.values[x][y - 1]);
            grid3.setintoValues(x, y - 1, voidChar);
            grid3.setCaseVidePosX(x);
            grid3.setCaseVidePosY(y - 1);

            neighbors.add(grid3);
        }

        if (y < nbColumn - 1) {
            GridState grid4 = this.clone();
            grid4.setintoValues(x, y, grid4.values[x][y + 1]);
            grid4.setintoValues(x, y + 1, voidChar);
            grid4.setCaseVidePosX(x);
            grid4.setCaseVidePosY(y + 1);

            neighbors.add(grid4);
        }
        return neighbors;
    }

    private static int calcF(int g, int h) {
        return g + h;
    }

    /**
     * Calculate h (heuristique: number of box incorrectly placed)
     */
    public static int calcH1(GridState currentTaquin, GridState solution) {
        int h = 0;
        // Go through the array to check which box is incorrectly placed
        for (int i = 0; i < currentTaquin.getValues().length; i++) {
            for (int n = 0; n < currentTaquin.getValues()[i].length; n++) {
                // Increment 'h' the number of box incorrectly placed
                if (currentTaquin.getValues()[i][n] != solution.getValues()[i][n]) {
                    h++;
                }
            }
        }

        return h;
    }

    /**
     * Calculate h (heuristique: number of move needed to place all box correctly)
     */
    public static int calcH2(GridState currentTaquin, GridState solution) {
        int h = 0;
        // Go through the array to check which box is incorrectly placed
        for (int i = 0; i < currentTaquin.getValues().length; i++) {
            for (int n = 0; n < currentTaquin.getValues()[i].length; n++) {
                // Checks if the current state box is equals to the current solution box
                if (currentTaquin.getValues()[i][n] != solution.getValues()[i][n]) {
                    for (int j = 0; j < solution.getValues().length; j++) {
                        for (int m = 0; m < solution.getValues()[j].length; m++) {
                            // Checks if the current box is equals to the current solution box
                            if (currentTaquin.getValues()[i][n] == solution.getValues()[j][m]) {
                                // Calculate the vertical move
                                if (i > j) {
                                    h += (i - j);
                                } else {
                                    h += (j - i);
                                }
                                // Calculate the horizontal move
                                if (n > m) {
                                    h += (n - m);
                                } else {
                                    h += (m - n);
                                }
                            }
                        }
                    }
                }
            }
        }
        return h;
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
            return this.caseVidePosX == stateTaquin.caseVidePosX && this.caseVidePosY == stateTaquin.caseVidePosY;
        }
        return false;
    }

    public GridState clone() {
        GridState taquinstate = new GridState(this.values, this.caseVidePosX, this.caseVidePosY);
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
