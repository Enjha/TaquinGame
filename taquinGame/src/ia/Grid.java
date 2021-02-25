package ia;

public class Grid {
    private final int nbLine;
    private final int nbColumn;
    private final char[][] values;
    private final VoidCase caseVide;
    public Grid(int nbLine, int nbColumn, char[][] values, VoidCase caseVide) {
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
    public VoidCase getCaseVide(){ return caseVide;}
}
