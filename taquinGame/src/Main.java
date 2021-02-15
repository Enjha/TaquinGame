import ia.Grid;
import ia.GridGame;
import ia.Initialization;
import ia.Node;

import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws URISyntaxException {
        Initialization init = new Initialization();
        GridGame gridGame = init.initialize();
        System.out.println(gridGame.getNbColumn()+" "+gridGame.getNbLine());
        Grid grid = gridGame.getStartingValues();
        Node caseVide = grid.getCaseVide();
        System.out.println(caseVide.getXposition()+" "+caseVide.getYposition());
    }

}
