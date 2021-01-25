package ia;

public class Grid {
    private int n;
    private int m;
    private final char[][] values;

    public Grid(int n, int m) {
        this.n = n;
        this.m = m;
        this.values = new char[n-1][m-1];
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public char[][] getValues() {
        return values;
    }

    public void setintoValues(int i,int j, char values) {
        this.values[i][j] = values;
    }
}
