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

            ArrayList<GridState> negihbors = currentState.generateNeighbors();
            for(GridState grid : negihbors){
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
    /*public GridState WidthSearch(){
        GridState initialState = taquinGame.getInitialState();
        GridState finalState = taquinGame.getFinalState();

        ArrayList<GridState> openState = new ArrayList<>();
        openState.add(initialState);
        ArrayList<GridState> closedState = new ArrayList<>();

        GridState head = openState.tete(pile ou file)
        faire en sorte que openstate agisse comme un pile ou comme un file selon l'algo voulu


        partager les taches entre la fonction algo qui apellera
        celle qui determine les actions selon si c'est pile ou si c'est file
        while(!openState.isEmpty() && !openState.get(openState.size()-1).equals(finalState)){
            element courant prend pour valeur la tete de la pile ou file
            on retire element courant de ouvert
            on ajoute element courant à fermé
            for(int i =0 ; i<nombre de voisins de l'element courant; i++)
                si ce voisins n'est pas deja dans ouvert OU fermé
                    ajouter le voisin à ouvert
        }
        si ouvert est vide  alors il n'y a pas de solution
        sinon element courant est la solution

    }*/
}
