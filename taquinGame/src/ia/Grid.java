package ia;

public class Grid {
    private final int nbLine;
    private final int nbColumn;
    private final Node caseVide;
    private final Node[][] values;

    public Grid(int nbLine, int nbColumn, Node[][] values, Node caseVide) {
        this.nbLine = nbLine;
        this.nbColumn = nbColumn;
        this.values = values;
        this.caseVide = caseVide;
    }

    public int getNbLine() { return nbLine; }
    public int getNbColumn() {return nbColumn; }
    public Node getCaseVide(){return caseVide;}
    public Node[][] getValues() {return values;}
}
