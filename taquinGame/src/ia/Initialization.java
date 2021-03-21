package ia;

import algorithm.AlgorithmEnumeration;
import utils.RandomFile;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.io.*;
import java.net.URISyntaxException;

public class Initialization {

    private final AlgorithmEnumeration enumeration;

    public Initialization(AlgorithmEnumeration enumeration) {
        this.enumeration = enumeration;
    }

    public TaquinGame initialize() throws URISyntaxException {
        RandomFile rf = new RandomFile();
        String nameRandomFile = rf.pikcUpFile();
        try {
            InputStream ips = new FileInputStream("taquinGame/src/ressources/" + nameRandomFile);
            InputStreamReader ipsr = new InputStreamReader(ips);
            System.out.println("Fichier choisi: "+nameRandomFile);
            BufferedReader br = new BufferedReader(ipsr);
            String ligneBuffered;
            int nbline = Integer.parseInt(br.readLine());
            br.mark(0);
            int nbColumns = 0;
            for (int i = 0; i < 2; i++) {
                ligneBuffered = br.readLine();
                for (int j = 0; j < ligneBuffered.length(); j++) {
                    if (j + 1 > nbColumns)
                        nbColumns = j + 1;
                }
            }
            br.reset();
            char[][] values = new char[nbline][nbColumns];
            char[][] valuesResults = new char[nbline][nbColumns];
            VoidCase caseVide = paddingValues(br, nbline, nbColumns, values);
            VoidCase caseVideResult = paddingValues(br, nbline, nbColumns, valuesResults);
            br.close();
            GridState initialState = new GridState(values, caseVide.getPosX(), caseVide.getPosY());
            GridState finalState = new GridState(valuesResults, caseVideResult.getPosX(), caseVideResult.getPosY());
            return new TaquinGame(initialState, finalState, nbline, nbColumns, enumeration);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private VoidCase paddingValues(BufferedReader br, int nbLine, int nbColums, char[][] values) throws IOException {
        String ligneBuffered;
        VoidCase caseVide = null;
        for (int i = 0; i < nbLine; i++) {
            ligneBuffered = br.readLine();
            for (int j = 0; j < nbColums; j++) {
                if (j >= ligneBuffered.length() || ligneBuffered.charAt(j) == ' ') {
                    values[i][j] = ' ';
                    caseVide = new VoidCase(i, j);
                } else {
                    values[i][j] = ligneBuffered.charAt(j);
                }
            }
        }
        return caseVide;
    }
}
