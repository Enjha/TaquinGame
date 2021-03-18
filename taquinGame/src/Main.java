import algorithm.AlgorithmEnumeration;
import ia.Initialization;
import ia.TaquinGame;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws URISyntaxException {
     /*    int algo;
        Scanner sc = new Scanner(System.in);
        System.out.println("1 : DeepSearch \n 2: WidthSearch \n 3: BestOneSearch");
        algo = sc.nextInt();
       AlgorithmEnumeration enumeration = null;
        switch (algo){
            case 1:
                enumeration = AlgorithmEnumeration.DeepSearch;
            break;
            case 2 :
                enumeration =AlgorithmEnumeration.WidthSearch;
            break;
            case 3:
                enumeration =AlgorithmEnumeration.BestOneSearch;
            break;
        } */

        Initialization initialization = new Initialization(AlgorithmEnumeration.DeepSearch);
        TaquinGame taquinGame = initialization.initialize();
        taquinGame.start();
    }

}
