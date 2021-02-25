package ia;

public class TaquinGame {
    private final GridState initialState;
    private final GridState finalState;

    public TaquinGame(GridState initialState, GridState finalState) {
        this.initialState = initialState;
        this.finalState = finalState;
    }
    public GridState getInitialState(){ return initialState; }
    public GridState getFinalState() { return finalState; }

    public void start(){

    }
}
