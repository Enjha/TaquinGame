import algorithm.AlgorithmEnumeration;
import ia.Initialization;
import ia.TaquinGame;

import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws URISyntaxException {
        Initialization initialization = new Initialization(AlgorithmEnumeration.BestOneSearch);
        TaquinGame taquinGame = initialization.initialize();
        System.out.println("lignes:" +taquinGame.getFinalState().getNbLine()+" colonnes:"+taquinGame.getFinalState().getNbColumn() +" XcaseVide:"+taquinGame.getInitialState().getCaseVide().getPosX()+" YcaseVide:"+taquinGame.getInitialState().getCaseVide().getPosY());
        taquinGame.start();
        System.out.println("Finis !");
    }

}
