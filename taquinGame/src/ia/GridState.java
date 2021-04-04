package ia;

import java.util.ArrayList;

public class GridState implements Cloneable {

    /**
     * Dimensions de la grille
     */
    private final int nbLine;
    private final int nbColumn;

    /**
     * Valeurs de la grille / Parent de la grille / Listes des états possibles (voisins) de la grille
     */
    private char[][] values;
    private GridState parent;
    private final ArrayList<GridState> neighbors;

    /**
     * Case Vide
     */
    private int caseVidePosX;
    private int caseVidePosY;

    /**
     * Heuristiques
     */
    private int g;
    private int h;
    private int f;

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

    public int getH1() {
        return this.g;
    }

    public void setH1(int g) {
        this.g = g;
    }

    public int getH2() {
        return this.h;
    }

    public void setH2(int h) {
        this.h = h;
    }

    public int getH3() {
        return this.f;
    }

    public void setH3(int f) {
        this.f = f;
    }

    public ArrayList<GridState> generateNeighbors(GridState solution) {
        int x = this.caseVidePosX;
        int y = this.caseVidePosY;
        char voidChar = this.values[x][y];

        if (x > 0) {
            GridState grid1 = this.clone();
            grid1.setintoValues(x, y, grid1.values[x - 1][y]);
            grid1.setintoValues(x - 1, y, voidChar);
            grid1.setCaseVidePosX(x - 1);
            grid1.setCaseVidePosY(y);
            grid1.setParent(this);

            grid1.setH1(calcH1(grid1, solution));
            grid1.setH2(calcH2(grid1, solution));
            grid1.setH3(calcF(grid1.getH1(), grid1.getH2()));
            neighbors.add(grid1);
        }

        if (x < nbLine - 1) {
            GridState grid2 = this.clone();
            grid2.setintoValues(x, y, grid2.values[x + 1][y]);
            grid2.setintoValues(x + 1, y, voidChar);
            grid2.setCaseVidePosX(x + 1);
            grid2.setCaseVidePosY(y);
            grid2.setParent(this);

            grid2.setH1(calcH1(grid2, solution));
            grid2.setH2(calcH2(grid2, solution));
            grid2.setH3(calcF(grid2.getH1(), grid2.getH2()));
            neighbors.add(grid2);
        }

        if (y > 0) {
            GridState grid3 = this.clone();
            grid3.setintoValues(x, y, grid3.values[x][y - 1]);
            grid3.setintoValues(x, y - 1, voidChar);
            grid3.setCaseVidePosX(x);
            grid3.setCaseVidePosY(y - 1);
            grid3.setParent(this);

            grid3.setH1(calcH1(grid3, solution));
            grid3.setH2(calcH2(grid3, solution));
            grid3.setH3(calcF(grid3.getH1(), grid3.getH2()));
            neighbors.add(grid3);
        }

        if (y < nbColumn - 1) {
            GridState grid4 = this.clone();
            grid4.setintoValues(x, y, grid4.values[x][y + 1]);
            grid4.setintoValues(x, y + 1, voidChar);
            grid4.setCaseVidePosX(x);
            grid4.setCaseVidePosY(y + 1);
            grid4.setParent(this);

            grid4.setH1(calcH1(grid4, solution));
            grid4.setH2(calcH2(grid4, solution));
            grid4.setH3(calcF(grid4.getH1(), grid4.getH2()));
            neighbors.add(grid4);
        }
        return neighbors;
    }

    private static int calcF(int g, int h) {
        return g + h;
    }

    /**
     * Calculate h (heuristique: Nombre de case mal placée)
     */
    public static int calcH1(GridState currentTaquin, GridState solution) {
        int h = 0;
        //On parcour la grille pour vérifier si les cases sont bien placées
        for (int i = 0; i < currentTaquin.getValues().length; i++) {
            for (int n = 0; n < currentTaquin.getValues()[i].length; n++) {
                //On incrémente 'h', qui est le nombre de cases mal placées
                if (currentTaquin.getValues()[i][n] != solution.getValues()[i][n]) {
                    h++;
                }
            }
        }

        return h;
    }

    /**
     * Calculate h (heuristique: Nombre de déplacement nécessaire pour arriver a l'état final)
     */
    public static int calcH2(GridState currentTaquin, GridState solution) {
        int h = 0;
        //On parcour la grille pour vérifier si des cases sont mal placées
        for (int i = 0; i < currentTaquin.getValues().length; i++) {
            for (int n = 0; n < currentTaquin.getValues()[i].length; n++) {
                //Verifie si la case de notre état courrant est différente de la case de notre état final
                if (currentTaquin.getValues()[i][n] != solution.getValues()[i][n]) {
                    for (int j = 0; j < solution.getValues().length; j++) {
                        for (int m = 0; m < solution.getValues()[j].length; m++) {
                            //Verifie si la case de l'état courrant es egale à la case de l'état final
                            if (currentTaquin.getValues()[i][n] == solution.getValues()[j][m]) {
                                // On calcule les déplacements verticales
                                if (i > j) {
                                    h += (i - j);
                                } else {
                                    h += (j - i);
                                }
                                // On calcule les déplacements horizonales
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

    /**
     * Fonctions Utiles :
     * - boolean equals(Object object): Verifié si deux objets(grilles) sont égales
     * - GridState clone(): Permet de créer une copie de la grille
     * - void printGrid(): Permet d'afficher une grille
     */

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

    public void printGrid() {
        for (int i = 0; i < this.nbLine; i++) {
            for (int j = 0; j < this.nbColumn; j++) {
                System.out.print(values[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
