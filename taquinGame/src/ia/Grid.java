package ia;

public class Grid {
    private final int nbLine;
    private final int nbColumn;
    private final char[][] values;
    private final int XcaseVide;
    private final int YcaseVide;


    public Grid(int nbLine, int nbColumn, char[][] values, int XcaseVide, int YcaseVide) {
        this.nbLine = nbLine;
        this.nbColumn = nbColumn;
        this.values = values;
        this.XcaseVide = XcaseVide;
        this.YcaseVide = YcaseVide;
        values[XcaseVide][YcaseVide] = ' ';
    }

    public int getNbLine() { return nbLine; }
    public int getNbColumn() {return nbColumn; }
    public char[][] getValues() {return values;}
    public int getXcaseVide(){return this.XcaseVide;}
    public int getYcaseVide(){return this.YcaseVide;}

}
