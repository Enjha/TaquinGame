package algorithm;

import ia.GridState;
import ia.TaquinGame;
import model.*;

import java.util.ArrayList;

public class Algorithm {

    private final TaquinGame taquinGame;

    public Algorithm(TaquinGame taquinGame) {
        this.taquinGame = taquinGame;
    }

    public ResultAlgorithm search(AlgorithmEnumeration enumAlgo, int heuristique) {
        System.out.println("Notre algorithme est en train de résoudre la grille. Si il y a une solution," +
                " elle s'affichera dans la console ainsi que tous les détails (parcours/heuristiques).");
        final long startTime = System.currentTimeMillis();
        final long endTime;
        GridState initialState = taquinGame.getInitialState();
        GridState finalState = taquinGame.getFinalState();
        GridState currentState;
        ArrayList<GridState> closedState = new ArrayList<>();
        OpenList openState = null;
        switch (enumAlgo) {
            case DeepSearch:
                openState = new OpenPile(new ArrayList<>());
                break;
            case WidthSearch:
                openState = new OpenQueue(new ArrayList<>());
                break;
            case BestOneSearch:
                openState = new OpenSortedList(new ArrayList<>(), heuristique);
                break;
            default:
                break;
        }
        openState.add(initialState);
        while (!openState.isEmpty() && !openState.getHead().equals(finalState)) {
            currentState = openState.getHead();
            openState.remove(currentState);
            closedState.add(currentState);
            ArrayList<GridState> neighbors = currentState.generateNeighbors(finalState);
            for (GridState grid : neighbors) {
                if (!openState.contains(grid) && !closedState.contains(grid)) {
                    openState.add(grid);
                }
            }
        }
        if (openState.isEmpty())
            return null;
        else {
            endTime = System.currentTimeMillis();
            return new ResultAlgorithm(openState.getHead(), endTime - startTime);
        }
    }

}
