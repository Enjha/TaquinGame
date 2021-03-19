package utils;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class RandomFile {

    private ArrayList<String> listFiles;

    public RandomFile() throws URISyntaxException {
        this.listFiles = recupFiles();
    }

    public ArrayList<String> recupFiles() throws URISyntaxException {
        listFiles = new ArrayList<>();
        ClassLoader contextClassLoader =
                Thread.currentThread().getContextClassLoader();
        URL resource = contextClassLoader.getResource("ressources");
        assert resource != null;
        File file = new File(resource.toURI());
        File[] files = file.listFiles();
        assert files != null;
        for (File f : files)
            listFiles.add(f.getName());
        return listFiles;
    }

    public String pikcUpFile() {
        Random r = new Random();
        if (listFiles.size() != 0)
            return listFiles.get(r.nextInt(listFiles.size() - 1));
        else return null;
    }


}
