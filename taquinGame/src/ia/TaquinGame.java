package ia;

import algorithm.Algorithm;
import algorithm.AlgorithmEnumeration;
import model.ResultAlgorithm;

import java.util.ArrayList;

public class TaquinGame {
    private final GridState initialState;
    private final GridState finalState;
    private final int nbLine;
    private final int nbColumn;

    public TaquinGame(GridState initialState, GridState finalState, int nbLine, int nbColumn) {
        this.initialState = initialState;
        this.finalState = finalState;
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

    public void start(AlgorithmEnumeration enumAlgo, int heuristique, boolean printHeuristique) {
        Algorithm algo = new Algorithm(this);
        ResultAlgorithm result = algo.search(enumAlgo, heuristique);
        ArrayList<GridState> resultParcour = new ArrayList<>();

        try {
            GridState parent = result.getResultGrid();
            while (parent != null) {
                resultParcour.add(parent);
                parent = parent.getParent();
            }

            for (int i = resultParcour.size() - 1; i >= 0; i--) {
                int numero = ((resultParcour.size() - 1) - i);
                if (numero == resultParcour.size() - 1)
                    System.out.println("************** Grille Finale **************");
                else {
                    if (i == resultParcour.size() - 1)
                        System.out.println("Grille initiale:");
                    else {
                        if (printHeuristique)
                            System.out.println("Mouvement numero " + numero + ", nombre de case mal placées: " + resultParcour.get(i).getG() + ", nombre de déplacement(s) nécessaire(s) pour atteindre l'état final: " + resultParcour.get(i).getH());
                        else
                            System.out.println("Mouvement numero " + numero);
                    }
                }
                resultParcour.get(i).printGrid();
                if (numero == resultParcour.size() - 1)
                    System.out.println("Solution trouvée en " + result.getTimeNeeded() + " ms.");
            }

        } catch (Exception e) {
            System.out.println("Aucune solution Trouvée !");
        }
    }


}
