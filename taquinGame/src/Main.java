import ia.GridGame;
import ia.Initialization;

import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws URISyntaxException {
        Initialization init = new Initialization();
        GridGame gridGame = init.initialize();
        //gridGame.printValues();
    }

}
