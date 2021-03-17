package algorithm;

import ia.GridState;
import ia.TaquinGame;
import model.OpenList;
import model.OpenPile;
import model.OpenQueue;
import model.OpenSortedList;

import java.util.ArrayList;

public class Algorithm {

    private final TaquinGame taquinGame;
    private final AlgorithmEnumeration enumeration;

    public Algorithm(TaquinGame taquinGame, AlgorithmEnumeration enumeration) {
        this.taquinGame = taquinGame;
        this.enumeration = enumeration;
    }

    public TaquinGame getTaquinGame() {
        return taquinGame;
    }

    public AlgorithmEnumeration getEnumeration() {
        return enumeration;
    }

    public GridState search() {
        GridState initialState = taquinGame.getInitialState();
        GridState finalState = taquinGame.getFinalState();
        GridState currentState;
        ArrayList<GridState> closedState = new ArrayList<>();
        OpenList openState = null;
        switch (this.enumeration) {
            case DeepSearch:
                openState = new OpenPile(new ArrayList<>());
                break;
            case WidthSearch:
                openState = new OpenQueue(new ArrayList<>());
                break;
            case BestOneSearch:
                openState = new OpenSortedList(new ArrayList<>());
                break;
            default:
                break;
        }

        openState.add(initialState);

        while (!openState.isEmpty() && !openState.getHead().equals(finalState)) {
            currentState = openState.getHead();
            openState.remove(currentState);
            closedState.add(currentState);

            ArrayList<GridState> neighbors = currentState.generateNeighbors();
            for (GridState grid : neighbors) {
                if (!openState.contains(grid) && !closedState.contains(grid)) {
                    openState.add(grid);
                }
            }
        }
        if (openState.isEmpty())
            return null;
        else {
            openState.getHead().printState();
            return openState.getHead();
        }
    }


    /*
    public GridState algorithm() {
        GridState initialState = taquinGame.getInitialState();
        GridState finalState = taquinGame.getFinalState();

        ArrayList<GridState> opened = new ArrayList<>();
        opened.add(initialState);
        ArrayList<GridState> closed = new ArrayList<>();

        GridState current;

        while (!opened.isEmpty() && !getHeadGrid(opened).equals(finalState)) {

            current = getHeadGrid(opened);
            opened.remove(current);
            closed.add(current);
            //for()
            /*
            element courant prend pour valeur la tete de la pile ou file
            on retire element courant de ouvert
            on ajoute element courant à fermé
            for(int i =0 ; i<nombre de voisins de l'element courant; i++)
                si ce voisins n'est pas deja dans ouvert OU fermé
                    ajouter le voisin à ouvert
        }
        si ouvert est vide  alors il n'y a pas de solution
        sinon element courant est la solution
            return getHeadGrid(opened);
        }
        return null;
    */
}
