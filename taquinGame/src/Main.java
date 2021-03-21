import algorithm.AlgorithmEnumeration;
import fx.InterfaceSwing;
import ia.Initialization;
import ia.TaquinGame;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws URISyntaxException {

        new InterfaceSwing().setVisible(true);
        Initialization initialization = new Initialization(AlgorithmEnumeration.BestOneSearch);
        TaquinGame taquinGame = initialization.initialize();
        taquinGame.start();
    }

}
