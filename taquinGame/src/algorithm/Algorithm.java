package algorithm;

import ia.GridState;
import ia.TaquinGame;

import java.util.ArrayList;

public class Algorithm {

    private final TaquinGame taquinGame;
    private final AlgorithmEnumeration enumeration;

    public Algorithm(TaquinGame taquinGame, AlgorithmEnumeration enumeration){
        this.taquinGame = taquinGame;
        this.enumeration = enumeration;
    }

    public TaquinGame getTaquinGame(){
        return taquinGame;
    }
    public AlgorithmEnumeration getEnumeration(){return enumeration;}

    public GridState search() {
        GridState initialState = taquinGame.getInitialState();
        GridState finalState = taquinGame.getFinalState();
        GridState currentState;

        ArrayList<GridState> openState = new ArrayList<>();
        openState.add(initialState);
        ArrayList<GridState> closedState = new ArrayList<>();
        while(!openState.isEmpty() && !openState.get(openState.size()-1).equals(finalState)){
            currentState = openState.get(openState.size()-1);
            openState.remove(currentState);
            closedState.add(currentState);

            ArrayList<GridState> neighbors = currentState.generateNeighbors();
            for(GridState grid : neighbors){
                if(!openState.contains(grid) && !closedState.contains(grid)){
                    openState.add(grid);
                }
            }
        }
        if(openState.isEmpty())
            return null;
        else{
            openState.get(openState.size()-1).printState();
            return openState.get(openState.size()-1);
        }
    }

    public GridState getHeadGrid(ArrayList<GridState> opened){
        GridState head;
        if(this.enumeration == AlgorithmEnumeration.DeepSearch) { //file
            head = opened.get(opened.size() - 1);
            return head;
        }
        else if (this.enumeration == AlgorithmEnumeration.WidthSearch) { //pile
            head = opened.get(0);
            return head;
        }
        else{
            System.out.println("error on enumeration returned");
            return null;
        }
    }
    public GridState algorithm(){
        GridState initialState = taquinGame.getInitialState();
        GridState finalState = taquinGame.getFinalState();

        ArrayList<GridState> opened = new ArrayList<>();
        opened.add(initialState);
        ArrayList<GridState> closed = new ArrayList<>();

        GridState current;

        while(!opened.isEmpty() && !getHeadGrid(opened).equals(finalState)) {
            current = getHeadGrid(opened);
            opened.remove(current);
            closed.add(current);

            ArrayList<GridState> neighbors = current.generateNeighbors();
            for (GridState grid : neighbors) {
                if (!opened.contains(grid) && !closed.contains(grid))
                    opened.add(grid);
            }
        }
        if(opened.isEmpty())
            return null;
        else
            return getHeadGrid(opened);
    }
}
