package fx;

import algorithm.AlgorithmEnumeration;
import ia.Initialization;
import ia.TaquinGame;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.RandomFile;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class ApplicationFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws URISyntaxException {
        primaryStage.setTitle("Résolveur Taquin");
        VBox root = new VBox();

        /* Choice Box */
        ChoiceBox<String> choiceFile = new ChoiceBox<>();
        RandomFile rf = new RandomFile();
        ArrayList<String> listFiles = rf.recupFiles();
        listFiles.add(0, "Aléatoire");
        choiceFile.setItems(FXCollections.observableArrayList(listFiles));
        choiceFile.setTooltip(new Tooltip("Choisissez une grille"));

        ChoiceBox<String> choiceAlgo = new ChoiceBox<>();
        ArrayList<String> listAlgo = new ArrayList<>();
        listAlgo.add("Recherche en profondeur");
        listAlgo.add("Recherche en largeur");
        listAlgo.add("Recherche du meilleur d'abord");
        choiceAlgo.setItems(FXCollections.observableArrayList(listAlgo));

        ChoiceBox<String> choiceHeur = new ChoiceBox<>();
        ArrayList<String> listHeur = new ArrayList<>();
        listHeur.add("Nombres de cases mal placées");
        listHeur.add("Nombres de déplacements nécéssaire pour arriver a l'état final");
        listHeur.add("Somme des deux heuristiques");
        choiceHeur.setItems(FXCollections.observableArrayList(listHeur));
        choiceHeur.setVisible(false);

        /* Text */
        Text information = new Text("Choisissez l'algorithme avec lequel vous voulez effectuer la recherche");
        Text heuristiques = new Text("Choisissez avec quel heuristique vous voulez utilisez l'algorithme");
        heuristiques.setVisible(false);

        /* CheckBox */
        CheckBox heur = new CheckBox("Affichage des détails des heuristiques");

        /* Button */
        Button btn = new Button("valider");
        Button search = new Button("rechercher");

        /* Action */

        AtomicReference<String> choosenFiles = new AtomicReference<>(null);

        btn.setOnAction(e -> {
            if (choiceFile.getValue().equals("Aléatoire")) {
                choosenFiles.set(rf.pikcUpFile());
            } else {
                choosenFiles.set(choiceFile.getValue());
            }
            root.getChildren().removeAll(root.getChildren());
            root.getChildren().addAll(information, choiceAlgo, heuristiques, choiceHeur, heur, search);
        });

        search.setOnAction(e -> {
            Initialization init = new Initialization();
            TaquinGame taquinGame = null;
            primaryStage.close();
            switch (choiceAlgo.getValue()) {
                case "Recherche en profondeur":
                    try {
                        taquinGame = init.initialize(choosenFiles.get());
                        taquinGame.start(AlgorithmEnumeration.DeepSearch, 0, heur.isSelected());
                    } catch (URISyntaxException uriSyntaxException) {
                        uriSyntaxException.printStackTrace();
                    }
                    break;
                case "Recherche en largeur":
                    try {
                        taquinGame = init.initialize(choosenFiles.get());
                        taquinGame.start(AlgorithmEnumeration.WidthSearch, 0, heur.isSelected());
                    } catch (URISyntaxException uriSyntaxException) {
                        uriSyntaxException.printStackTrace();
                    }
                    break;
                case "Recherche du meilleur d'abord":
                    try {
                        taquinGame = init.initialize(choosenFiles.get());
                    } catch (URISyntaxException uriSyntaxException) {
                        uriSyntaxException.printStackTrace();
                    }
                    switch (choiceHeur.getValue()) {
                        case "Nombres de cases mal placées":
                            assert taquinGame != null;
                            taquinGame.start(AlgorithmEnumeration.BestOneSearch, 1, heur.isSelected());
                            break;
                        case "Nombres de déplacements nécéssaire pour arriver a l'état final":
                            assert taquinGame != null;
                            taquinGame.start(AlgorithmEnumeration.BestOneSearch, 2, heur.isSelected());
                            break;
                        case "Somme des deux heuristiques":
                            assert taquinGame != null;
                            taquinGame.start(AlgorithmEnumeration.BestOneSearch, 3, heur.isSelected());
                            break;
                    }
            }
        });

        choiceAlgo.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            choiceHeur.setVisible(newValue.equals("Recherche du meilleur d'abord"));
            heuristiques.setVisible(newValue.equals("Recherche du meilleur d'abord"));
        });

        root.getChildren().addAll(choiceFile, btn);
        root.setPrefSize(640, 480);
        root.setAlignment(Pos.CENTER);
        root.setFillWidth(true);
        root.setSpacing(20);

        primaryStage.setScene(new Scene(root, 940, 780));
        primaryStage.setResizable(false);
        primaryStage.show();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Bonjour et bienvenue sur notre résolveur de grille de taquin.\n" +
                "Pour commencer veuillez choisir la grille que vous voulez résoudre !");
        alert.show();
    }
}
