package algorithm;

import ia.GridState;
import ia.TaquinGame;

import java.util.ArrayList;

public class DeepRouteAlgo {

    private final TaquinGame taquinGame;

    public DeepRouteAlgo(TaquinGame taquinGame){
        this.taquinGame = taquinGame;
    }

    public TaquinGame getTaquinGame(){
        return taquinGame;
    }

    public boolean algorithmeDeep(){
        GridState initialState = taquinGame.getInitialState();
        GridState finalState = taquinGame.getFinalState();
        GridState currentState;
        ArrayList<GridState> closedState = new ArrayList<>();
        ArrayList<GridState> openState = new ArrayList<>();
        openState.add(initialState);

        while(openState.size() > 0 && openState.get(openState.size()-1) != finalState){
            currentState = openState.get(openState.size()-1);
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

        }
        if(openState.size() == 0)
            return false;
        else{
            return false;
        }
    }

}
