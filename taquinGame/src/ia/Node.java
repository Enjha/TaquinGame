package ia;

public class Node {
    private char value;
    private int Xposition;
    private int Yposition;

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
