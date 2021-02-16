package ia;

import java.util.ArrayList;

public class CurrentGrid{

    private final Grid grid;

    public CurrentGrid(Grid grid) {
        this.grid = grid;
    }

    public Node getCaseVide(){return grid.getCaseVide();}
    public Node[][] getValues() {return grid.getValues();}

    public ArrayList<Node> getNeighbours(){
        int nbLine = this.grid.getNbLine();
        int nbColumn = this.grid.getNbColumn();
        Node[][] values = grid.getValues();
        ArrayList<Node> neighbours = new ArrayList<>();
        int x = getCaseVide().getXposition();
        int y = getCaseVide().getYposition();
        if(x-1>=0){
            neighbours.add(values[x-1][y]);
        }else if(x+1<nbLine){
            neighbours.add(values[x+1][y]);
        }else if(y-1>=0){
            neighbours.add(values[x][y-1]);
        }else if(y+1<nbColumn){
            neighbours.add(values[x][y+1]);
        }
        return neighbours;
    }

}
