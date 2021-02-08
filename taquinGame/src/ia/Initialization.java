package ia;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

public class Initialization {

    public Initialization(){}

    public GridGame initialize() throws URISyntaxException {
        RandomFile rf = new RandomFile();
        String nameRandomFile = rf.pikcUpFile();
        try{
            InputStream ips=new FileInputStream("taquinGame/src/ressources/"+nameRandomFile);
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            String ligne;
            int nbline = Integer.parseInt(br.readLine());
            int nbColumn = 0;
            int line = 0;
            while ((ligne=br.readLine())!=null){
                if(ligne.length() > nbColumn){
                    nbColumn = ligne.length();
                }
            }
            GridGame gridGame = new GridGame(nbline,nbColumn);
            br.reset();
            while ((ligne=br.readLine())!=null){
                for(int j=0;j<nbColumn;j++){
                    gridGame.setintoGrid(line,j, new Node(ligne.charAt(j)));
                }
                line++;
            }
            br.close();
            return gridGame;
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return null;
    }
}
