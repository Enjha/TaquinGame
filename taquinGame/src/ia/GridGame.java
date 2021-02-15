package ia;

public class GridGame {
    private final int nbLine;
    private final int nbColumn;
    private StateGrid startingValues;
    private final StateGrid resultsValues;


    public GridGame(int nbLine, int nbColumn, StateGrid startingValues, StateGrid resultsValues){
        this.nbLine = nbLine;
        this.nbColumn = nbColumn;
        this.startingValues = startingValues;
        this.resultsValues = resultsValues;
    }

    public int getNbLine() {return nbLine;}
    public int getNbColumn() {return nbColumn;}
    public StateGrid getStartingValues(){ return startingValues; }
    public StateGrid getResultsValues() { return resultsValues; }
}
