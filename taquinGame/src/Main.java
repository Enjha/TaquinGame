import algorithm.AlgorithmEnumeration;
import ia.Initialization;
import ia.TaquinGame;

import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws URISyntaxException {
        Initialization initialization = new Initialization(AlgorithmEnumeration.DeepSearch);
        TaquinGame taquinGame = initialization.initialize();
        taquinGame.start();
        System.out.println("Finis !");
    }

}
