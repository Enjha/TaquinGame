package ia;

import algorithm.Algorithm;
import algorithm.AlgorithmEnumeration;

public class TaquinGame {
    private final GridState initialState;
    private final GridState finalState;
    private final AlgorithmEnumeration enumeration;
    private final int nbLine;
    private final int nbColumn;

    public TaquinGame(GridState initialState, GridState finalState, int nbLine, int nbColumn, AlgorithmEnumeration enumeration) {
        this.initialState = initialState;
        this.finalState = finalState;
        this.enumeration = enumeration;
        this.nbLine = nbLine;
        this.nbColumn = nbColumn;
    }

    public GridState getInitialState(){ return initialState; }
    public GridState getFinalState() { return finalState; }
    public AlgorithmEnumeration getEnumeration() {
        return enumeration;
    }
    public int getNbLine() {
        return nbLine;
    }
    public int getNbColumn() {
        return nbColumn;
    }

    public void start() {
        Algorithm algo = new Algorithm(this,this.enumeration);
        GridState result = algo.algorithm();
        char[][] values = result.getValues();

        for(int i = 0 ; i < this.nbLine ;i ++){
            for(int j = 0; j < this.nbColumn ; j++){
                System.out.print(values[i][j]);
            }
            System.out.println();
        }
    }

}
