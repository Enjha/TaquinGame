package ia;

public class StateGrid {
    private final Node caseVide;
    private final Node[][] values;

    public StateGrid(Node[][] values, Node caseVide) {
        this.values = values;
        this.caseVide = caseVide;
    }

    public Node getCaseVide(){return caseVide;}
    public Node[][] getValues() {return values;}
    public void setintoGrid(int x, int y, Node values) {
        this.values[x][y] = values;
    }
}
