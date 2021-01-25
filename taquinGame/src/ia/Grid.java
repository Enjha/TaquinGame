package ia;

public class Grid {
    private int n;
    private int m;
    private final int[] values;

    public Grid(int n, int m) {
        this.n = n;
        this.m = m;
        int sizeValues = n * m;
        this.values = new int[sizeValues-1];
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

    public int[] getValues() {
        return values;
    }

    public void setintoValues(int i, int values) {
        this.values[i] = values;
    }
}
