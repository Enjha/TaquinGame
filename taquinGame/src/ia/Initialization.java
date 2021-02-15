package ia;

import java.io.*;
import java.net.URISyntaxException;

public class Initialization {

    public GridGame initialize() throws URISyntaxException {
        RandomFile rf = new RandomFile();
        String nameRandomFile = rf.pikcUpFile();
        try{
            InputStream ips = new FileInputStream("taquinGame/src/ressources/"+nameRandomFile);
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br= new BufferedReader(ipsr);
            String ligneBuffered;
            int nbline = Integer.parseInt(br.readLine());
            br.mark(0);
            int nbColumns = 0;
            for(int i = 0; i<2;i++){
                ligneBuffered = br.readLine();
                if(ligneBuffered.length() > nbColumns)
                    nbColumns = ligneBuffered.length();
            }
            br.reset();
            Node[][] nodesValue = new Node[nbline][nbColumns];
            Node[][] valuesResults = new Node[nbline][nbColumns];
            Node caseVide = paddingValues(br, nbline, nbColumns, nodesValue);
            Node caseVideResult = paddingValues(br, nbline, nbColumns, valuesResults);
            br.close();
            StateGrid startingGrid = new StateGrid(nodesValue,caseVide);
            StateGrid resultGrid = new StateGrid(valuesResults,caseVide);
            return new GridGame(nbline,nbColumns,startingGrid,resultGrid);
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return null;
    }

    private Node paddingValues(BufferedReader br, int nbline, int nbColumns, Node[][] nodesValue) throws IOException {
        String ligneBuffered;
        Node caseVide = null;
        for(int i = 0; i<nbline; i++){
            ligneBuffered = br.readLine();
            for(int j=0;j<nbColumns;j++){
                if(ligneBuffered.charAt(j) == ' ') {
                    nodesValue[i][j] = new Node(i, j, ' ');
                    caseVide = nodesValue[i][j];
                }else {
                    nodesValue[i][j] = new Node(i, j, ligneBuffered.charAt(j));
                }
            }
            System.out.println();
        }
        return caseVide;
    }
}
