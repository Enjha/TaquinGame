package ia;

public class GridGame {
    private final int n;
    private final int m;
    private final Node[][] values;

    public GridGame(int n, int m) {
        this.n = n;
        this.m = m;
        this.values = new Node[n][m];
    }

    public int getN() {return n;}
    public int getM() {return m;}
    public Node[][] getValues() {return values; }

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
