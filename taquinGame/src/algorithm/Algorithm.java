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

    public GridState search(){
        int i = 0;
        GridState initialState = taquinGame.getInitialState();
        GridState finalState = taquinGame.getFinalState();
        GridState currentState;

        initialState.printState();
        System.out.println();

        ArrayList<GridState> closedState = new ArrayList<>();
        ArrayList<GridState> openState = new ArrayList<>();

        openState.add(initialState);
        int head = 0;
        if(enumeration == AlgorithmEnumeration.DeepSearch)
            head = openState.size()-1;
        while(!openState.isEmpty() && openState.get(head).getValues() != finalState.getValues()){
            currentState = openState.get(head);
            openState.remove(currentState);
            closedState.add(currentState);
            /* - générer tous les voisins possibles de e et les insérer dans Ouvert
                    s'ils ne sont pas déjà dans Ouvert [ni dans Ferme´] - */
            ArrayList<GridState> negihbors = currentState.generateNeighbors();
            for(GridState grid : negihbors){
                if(!openState.contains(grid) && !closedState.contains(grid)){
                    openState.add(grid);
                }
            }
            System.out.println("tour numero "+i+": ");
            currentState.printState();
            i ++;
        }
        System.out.println("Algo finis !");
        if(openState.isEmpty())
            return null;
        else{
            return openState.get(head);
        }
    }

}
