package ia;

public class GridGame {
    private final int nbLine;
    private final int nbColumn;
    private Grid startingValues;
    private final Grid resultsValues;


    public GridGame(int nbLine, int nbColumn, Grid startingValues, Grid resultsValues){
        this.nbLine = nbLine;
        this.nbColumn = nbColumn;
        this.startingValues = startingValues;
        this.resultsValues = resultsValues;
    }

    public int getNbLine() {return nbLine;}
    public int getNbColumn() {return nbColumn;}
    public Grid getStartingValues(){ return startingValues; }
    public Grid getResultsValues() { return resultsValues; }
}
