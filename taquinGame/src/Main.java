import ia.GridGame;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        int line, column;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez le nombre de ligne entre 2 et 5:");
        line = scanner.nextInt();
        System.out.println("Choisissez le nombre de colonnes entre 2 et 5:");
        column = scanner.nextInt();
        GridGame grid = new GridGame(line,column);
        grid.affiche();
    }

}
