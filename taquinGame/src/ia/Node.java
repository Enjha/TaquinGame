package ia;

import java.util.HashMap;

public class Node {
    private char value;
    private int position;
    private HashMap<String,Node> listVoisins;

    public Node(char value){
        this.value = value;
    }

    public char getValue() {
        return value;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int position){this.position = position;}
    public HashMap<String,Node> getVoisins() {
        return listVoisins;
    }

    public void switchCase(String direction){
        int i = listVoisins.get(direction).getPosition();
        listVoisins.get(direction).setPosition(this.getPosition());
        this.setPosition(i);
    }

}
