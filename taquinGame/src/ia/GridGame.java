package ia;

import java.io.*;

public class GridGame {
    private final int n;
    private final int m;
    private char[][] values;

    public GridGame(int n, int m) {
        this.n = n;
        this.m = m;
        this.values = paddingGrid();
    }

    public int getN() {return n;}
    public int getM() {return m;}
    public char[][] getValues() {return values; }

    public void setintoGrid(int x, int y, char values) {
        this.values[x][y] = values;
    }

    public char[][] paddingGrid(){
        this.values = new char[n][m];
        try {
            File f = new File("C:\\Users\\proxz\\Desktop\\TaquinGame\\taquinGame\\src\\ressources\\taquin_"+this.n+"x"+this.m+".grid");
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine;
            int ligne = 0;
            while ((readLine = b.readLine()) != null) {
                    for (int i = 0; i <= m - 1; i++) {
                        if(i<=readLine.length()-1)
                            values[ligne][i] = readLine.charAt(i);
                        else
                            values[ligne][i] = ' ';
                    }
                if(ligne == n-1) break;
                ligne++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return values;
    }

    public void affiche(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.println(values[i][j]);
            }
            System.out.println("\n");
        }
    }

}
