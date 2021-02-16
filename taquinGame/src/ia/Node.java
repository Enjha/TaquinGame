package ia;

public class Node {
    private final char value;
    private final int Xposition;
    private final int Yposition;

    public Node(int Xposition, int Yposition, char value){
        this.value = value;
        this.Xposition = Xposition;
        this.Yposition = Yposition;
    }
    public char getValue() {
        return value;
    }
    public int getXposition() {return Xposition;}
    public int getYposition(){return Yposition;}
}
