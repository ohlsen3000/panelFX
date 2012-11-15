/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panelfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author ugz
 */
public class PanelFX extends Application {
    

    @Override
    public void start(Stage primaryStage) {

        FlowPane masterPane = new FlowPane();
        masterPane.setPadding(new Insets(5, 5, 5, 5));
        masterPane.setVgap(5);
        masterPane.setHgap(5);
        masterPane.setStyle("-fx-background-color: #414141;");

        EventHandler actionListener = createButtonListener();
        
        FlowPane panePulpFiction = createFlowPane();
        panePulpFiction.getChildren().add(createButton("Was jetzt?", "wasjetzt", actionListener));
        panePulpFiction.getChildren().add(createButton("1 mal was", "was", actionListener));
        panePulpFiction.getChildren().add(createButton("Ich sag dir", "ansteht", actionListener));
        panePulpFiction.getChildren().add(createButton("Konzept", "konzept", actionListener));
        panePulpFiction.getChildren().add(createButton("Zur Seite", "butch", actionListener));
        panePulpFiction.getChildren().add(createButton("Nein Mann", "neinmann", actionListener));
        masterPane.getChildren().add(createLabel("Pulp Fiction"));
        masterPane.getChildren().add(panePulpFiction);
        
        FlowPane paneBastelecke = createFlowPane();
        paneBastelecke.getChildren().add(createButton("Standup", "standup", actionListener));
        paneBastelecke.getChildren().add(createButton("Cubage", "qbitch", actionListener));
        paneBastelecke.getChildren().add(createButton("Alarm", "alarm", actionListener));
        paneBastelecke.getChildren().add(createButton("Öey", "oey", actionListener));
        paneBastelecke.getChildren().add(createButton("Lauschangriff", "lauschangriff", actionListener));
        paneBastelecke.getChildren().add(createButton("The Fog", "fog", actionListener));
        paneBastelecke.getChildren().add(createButton("Falsch", "falsch", actionListener));
        paneBastelecke.getChildren().add(createButton("Danköö", "dankoe", actionListener));
        paneBastelecke.getChildren().add(createButton("Schafskäse", "schafskaese", actionListener));
        paneBastelecke.getChildren().add(createButton("Bäm", "baehm", actionListener));
        paneBastelecke.getChildren().add(createButton("Erbärmlich", "erbaermlich", actionListener));
        paneBastelecke.getChildren().add(createButton("HorHorHor", "kevin", actionListener));
        masterPane.getChildren().add(createLabel("Bastelecke"));
        masterPane.getChildren().add(paneBastelecke);
        
        FlowPane paneMisc = createFlowPane();
        paneMisc.getChildren().add(createButton("Bieker", "bieker", actionListener));
        paneMisc.getChildren().add(createButton("Ballad", "ballad", actionListener));
        paneMisc.getChildren().add(createButton("Jeopardy", "jeopardy", actionListener));
        paneMisc.getChildren().add(createButton("Remoot", "remoot", actionListener));
        paneMisc.getChildren().add(createButton("Delate", "delate", actionListener));
        paneMisc.getChildren().add(createButton("Snapshoot", "snapshoot", actionListener));
        paneMisc.getChildren().add(createButton("Khaan", "khan", actionListener));
        paneMisc.getChildren().add(createButton("Essort", "essort", actionListener));
        paneMisc.getChildren().add(createButton("Wie geil", "geil", actionListener));
        paneMisc.getChildren().add(createButton("Fail", "gesch_reiner", actionListener));
        paneMisc.getChildren().add(createButton("Fail satanic", "gescheitert_satan", actionListener));
        paneMisc.getChildren().add(createButton("Quiet", "quiet", actionListener));
        masterPane.getChildren().add(createLabel("Misc"));
        masterPane.getChildren().add(paneMisc);
        
        FlowPane paneJoeHanson = createFlowPane();
        paneJoeHanson.getChildren().add(createButton("Bitte?", "bidde_fragend", actionListener));
        paneJoeHanson.getChildren().add(createButton("bidde?", "bidde_veraengstigt", actionListener));
        paneJoeHanson.getChildren().add(createButton("Revert", "reewert", actionListener));
        paneJoeHanson.getChildren().add(createButton("Rewe", "rewe", actionListener));
        paneJoeHanson.getChildren().add(createButton("Das ist das", "dasist", actionListener));
        paneJoeHanson.getChildren().add(createButton("Eeehm", "eehm", actionListener));
        paneJoeHanson.getChildren().add(createButton("Domäne", "domaene", actionListener));
        paneJoeHanson.getChildren().add(createButton("So nicht!", "sonicht", actionListener));
        paneJoeHanson.getChildren().add(createButton("Weißt Du's?", "weisstdus", actionListener));
        paneJoeHanson.getChildren().add(createButton("Konverter", "konverter", actionListener));
        paneJoeHanson.getChildren().add(createButton("Kaffee", "kaffee", actionListener));
        paneJoeHanson.getChildren().add(createButton("Annee", "aneene", actionListener));
        masterPane.getChildren().add(createLabel("Joe Hanson"));
        masterPane.getChildren().add(paneJoeHanson);


        Scene scene = new Scene(masterPane, 660, 350);
        
        primaryStage.getIcons().add(new Image(PanelFX.class.getResourceAsStream("icon.png")));
        primaryStage.setTitle("The Panel");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private Label createLabel(String caption) {
        Label label = new Label(caption);
        label.setTextFill(Color.web("#EEEEEE"));
        return label;
    }
    
    private FlowPane createFlowPane() {
        FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(5, 5, 5, 5));
        pane.setVgap(5);
        pane.setHgap(5);
        pane.setMinWidth(640);
        pane.setStyle(" -fx-border-color: #777777; -fx-border-radius: 5;");
        return pane;
    }

    private Button createButton(String label, String soundFileName, EventHandler actionListener) {
        Button button = new Button(label);
        button.setId(soundFileName);
        button.setOnAction(actionListener);
        button.setMinWidth(100);
        return button;
    }

    private EventHandler createButtonListener() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String actionSource = ((Button)event.getSource()).getId();
                String url = PanelFX.class.getResource(actionSource + ".mp3").toString();
                Media sound = new Media(url);
                MediaPlayer player = new MediaPlayer(sound);
                player.play();
            }
        };
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
