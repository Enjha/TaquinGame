package ia;

import java.util.ArrayList;

public class Node {
    private char value;
    private int position;
    private ArrayList<Node> listVoisins;

    public Node(char value){
        this.value = value;
    }

    public char getValue() {
        return value;
    }
    public int getPosition() {
        return position;
    }
    public ArrayList<Node> getVoisins() {
        return listVoisins;
    }

    public void switchLeft(){

    }
    public void switchRight(){

    }
    public void switchUp(){

    }
    public void switchDown(){

    }
}
