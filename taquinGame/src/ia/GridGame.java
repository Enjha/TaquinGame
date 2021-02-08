package ia;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

public class GridGame {
    private int n;
    private int m;
    private Node[][] values;

    public GridGame(int n, int m) {
        this.n = n;
        this.m = m;
        this.values = new Node[n][m];
    }

    public int getN() {return n;}
    public int getM() {return m;}

    public Node[][] getValues() {return values;}

    public void setintoGrid(int x, int y, Node values) {
        this.values[x][y] = values;
    }

    public void printValues(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(values[i][j]);
            }
            System.out.println();
        }
    }
}
