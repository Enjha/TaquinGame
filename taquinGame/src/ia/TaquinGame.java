package ia;

import algorithm.Algorithm;
import algorithm.AlgorithmEnumeration;

public class TaquinGame {
    private final GridState initialState;
    private final GridState finalState;
    private final AlgorithmEnumeration enumeration;

    public TaquinGame(GridState initialState, GridState finalState, AlgorithmEnumeration enumeration) {
        this.initialState = initialState;
        this.finalState = finalState;
        this.enumeration = enumeration;
    }

    public GridState getInitialState(){ return initialState; }
    public GridState getFinalState() { return finalState; }
    public AlgorithmEnumeration getEnumeration() {
        return enumeration;
    }

    public void start(){
        Algorithm algo = new Algorithm(this,this.enumeration);
        GridState result = algo.search();
        char[][] values = result.getValues();
        int m = this.getInitialState().getNbLine();
        int n = this.getInitialState().getNbColumn();
        System.out.println(m +""+n);
        for(int i = 0 ; i < m ;i ++){
            for(int j = 0; j < n ; j++){
                System.out.print(values[i][j]);
            }
            System.out.println();
        }
    }

}
