package ia;

import algorithm.AlgorithmEnumeration;
import utils.RandomFile;

import java.io.*;
import java.net.URISyntaxException;

public class Initialization {

    private final AlgorithmEnumeration enumeration;
    public Initialization(AlgorithmEnumeration enumeration){
        this.enumeration = enumeration;
    }

    public TaquinGame initialize() throws URISyntaxException {
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
            char[][] values = new char[nbline][nbColumns];
            char[][] valuesResults = new char[nbline][nbColumns];
            VoidCase caseVide = paddingValues(br, nbline, nbColumns, values);
            VoidCase caseVideResult = paddingValues(br, nbline, nbColumns, valuesResults);
            br.close();
            GridState initialState = new GridState(values,caseVide);
            GridState finalState = new GridState(valuesResults,caseVideResult);
            return new TaquinGame(initialState,finalState,nbline,nbColumns,enumeration);
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return null;
    }

    private VoidCase paddingValues(BufferedReader br, int nbline, int nbColumns, char[][] values) throws IOException {
        String ligneBuffered;
        VoidCase caseVide = null;
        for(int i = 0; i<nbline; i++){
            ligneBuffered = br.readLine();
            for(int j=0;j<nbColumns;j++){
                if(ligneBuffered.charAt(j) == ' ') {
                    values[i][j] = ' ';
                    caseVide = new VoidCase(i,j);
                }else {
                    values[i][j] = ligneBuffered.charAt(j);
                }
            }
        }
        return caseVide;
    }
}
