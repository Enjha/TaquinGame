import ia.Initialization;
import ia.TaquinGame;

import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws URISyntaxException {
        Initialization init = new Initialization();
        TaquinGame game = init.initialize();
        char[][] values = game.getInitialState().getValues();
        int m = game.getInitialState().getNbLine();
        int n = game.getInitialState().getNbColumn();
        System.out.println(m +""+n);
        for(int i = 0 ; i < m ;i ++){
            for(int j = 0; j < n ; j++){
                System.out.print(values[i][j]);
            }
            System.out.println();
        }
    }

}
