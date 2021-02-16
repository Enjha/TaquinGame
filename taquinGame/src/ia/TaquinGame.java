package ia;

public class TaquinGame {
    private final Grid startingValues;
    private final Grid resultsValues;

    public TaquinGame(Grid startingValues, Grid resultsValues) {
        this.startingValues = startingValues;
        this.resultsValues = resultsValues;
    }
    public Grid getStartingValues(){ return startingValues; }
    public Grid getResultsValues() { return resultsValues; }
}
