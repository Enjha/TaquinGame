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

    public GridState search() {
        final long startTime = System.currentTimeMillis();
        final long endTime;
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
            System.out.println("Taille de la list ouverte: " + openState.size());
        }
        if (openState.isEmpty())
            return null;
        else {
            endTime = System.currentTimeMillis();
            System.out.println("Solution trouvée en " + (endTime - startTime) + "ms");
            return openState.getHead();
        }
    }

}
