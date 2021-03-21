package ia;

import algorithm.Algorithm;
import algorithm.AlgorithmEnumeration;
import model.ResultAlgorithm;

import java.util.ArrayList;

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

    public GridState getInitialState() {
        return initialState;
    }

    public GridState getFinalState() {
        return finalState;
    }

    public int getNbLine() {
        return this.nbLine;
    }

    public int getNbColumn() {
        return nbColumn;
    }

    public void start() {
        Algorithm algo = new Algorithm(this, this.enumeration);
        ResultAlgorithm result = algo.search();
        ArrayList<GridState> resultParcour = new ArrayList<>();

        try {
            GridState parent = result.getResultGrid();
            while (parent != null) {
                resultParcour.add(parent);
                parent = parent.getParent();
            }

            for (int i = resultParcour.size() - 1; i >= 0; i--) {
                int numero = ((resultParcour.size() - 1) - i) + 1;
                if (numero == resultParcour.size())
                    System.out.println("************** Grille Finale **************");
                else
                    System.out.println("Mouvement numero " + numero + " :");
                resultParcour.get(i).printGrid();
                if (numero == resultParcour.size())
                    System.out.println("Solution trouvée en " + result.getTimeNeeded() + " ms.");
            }

        } catch (Exception e) {
            System.out.println("Aucune solution Trouvée !");
        }
    }


}
