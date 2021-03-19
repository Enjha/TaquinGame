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

  /*  public GridState search(int heuristiqueType) {
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
            ArrayList<GridState> neighbors = currentState.generateNeighbors(finalState,heuristiqueType);
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
            return openState.getHead();
        }
    } */

    public void search(int hType) {
        // Contains possible solution not explored
        ArrayList<GridState> open = new ArrayList<>();
        // Contains solution explored
        ArrayList<GridState> close = new ArrayList<>();
        // Contains alternatives of taquin state
        ArrayList<GridState> alternatives;
        final long startTime = System.currentTimeMillis();
        final long endTime;

        // Init `open` Collection with initial state of a taquin
        open.add(taquinGame.getInitialState());
        // A* algorithm
        while (!open.isEmpty()) {
            for (int i = 0; i < open.size(); i++) {
                GridState state = new GridState(open.get(i).getValues(),open.get(i).getCaseVidePosX(),open.get(i).getCaseVidePosY());

                alternatives = state.generateNeighbors(taquinGame.getFinalState(), hType);


                // Checks all alternatives found
                for (GridState alternative : alternatives) {
                    // Checks if the current alternative is the solution
                    if (alternative.getH() == 0) {
                        endTime = System.currentTimeMillis();
                        System.out.println("Solution found in " + (endTime - startTime) + "ms with hType : " + hType);
                        System.out.println(alternative.toString());
                        return;
                    } else {
                        if (!open.contains(alternative)) {
                            open.add(alternative);
                        } else if ((open.contains(alternative)) && (open.get(open.indexOf(alternative)).getF() < alternative.getF())) {
                            open.remove(alternative);
                            open.add(alternative);
                        }
                    }
                }
            }
        }
    }
}
