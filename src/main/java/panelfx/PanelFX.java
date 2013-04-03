/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panelfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author ugz
 */
public class PanelFX extends Application {

    private final PlayingSounds runningSounds = new PlayingSounds();

    @Override
    public void start(final Stage primaryStage) {

        final FlowPane masterPane = new FlowPane();
        masterPane.setPadding(new Insets(5, 20, 5, 20));
        masterPane.setVgap(5);
        masterPane.setHgap(5);
        final String image = PanelFX.class.getResource("wood.jpg").toExternalForm();
        masterPane.setStyle("-fx-background-image: url('" + image + "')");

        final FlowPane controllingPane = this.createFlowPane(false);
        Image muteImage = new Image(getClass().getResourceAsStream("mute.png"));
        ImageView muteView = new ImageView(muteImage);
        muteView.setId("STOP");
        muteView.setOnMouseClicked(this.createControlButtonListener());
        muteView.setCursor(Cursor.HAND);
        controllingPane.getChildren().add(muteView);
        controllingPane.setAlignment(Pos.CENTER_RIGHT);
        masterPane.getChildren().add(controllingPane);

        final EventHandler<ActionEvent> actionListener = this.createButtonListener();

        final FlowPane panePulpFiction = this.createFlowPane();
        panePulpFiction.getChildren().add(this.createButton("Was jetzt?", "wasjetzt", actionListener));
        panePulpFiction.getChildren().add(this.createButton("1 mal was", "was", actionListener));
        panePulpFiction.getChildren().add(this.createButton("Ich sag dir", "ansteht", actionListener));
        panePulpFiction.getChildren().add(this.createButton("Konzept", "konzept", actionListener));
        panePulpFiction.getChildren().add(this.createButton("Zur Seite", "butch", actionListener));
        panePulpFiction.getChildren().add(this.createButton("Nein Mann", "neinmann", actionListener));
        masterPane.getChildren().add(this.createLabel("Pulp Fiction"));
        masterPane.getChildren().add(panePulpFiction);

        final FlowPane paneBastelecke = this.createFlowPane();
        paneBastelecke.getChildren().add(this.createButton("Stand up", "standup", actionListener));
        paneBastelecke.getChildren().add(this.createButton("Cubage", "qbitch", actionListener));
        paneBastelecke.getChildren().add(this.createButton("Battle 1", "eurobattle1", actionListener));
        paneBastelecke.getChildren().add(this.createButton("Battle 2", "eurobattle2", actionListener));
        paneBastelecke.getChildren().add(this.createButton("Battle 3", "eurobattle3", actionListener));
        paneBastelecke.getChildren().add(this.createButton("Alarm", "alarm", actionListener));
        paneBastelecke.getChildren().add(this.createButton("Push it", "pushit", actionListener));
        paneBastelecke.getChildren().add(this.createButton("Öööey", "oey", actionListener));
        paneBastelecke.getChildren().add(this.createButton("Lauschangriff", "lauschangriff", actionListener));
        paneBastelecke.getChildren().add(this.createButton("The Fog", "fog", actionListener));
        paneBastelecke.getChildren().add(this.createButton("Bäm", "baehm", actionListener));
        paneBastelecke.getChildren().add(this.createButton("Erbärmlich", "erbaermlich", actionListener));
        paneBastelecke.getChildren().add(this.createButton("HorHorHor", "kevin", actionListener));
        paneBastelecke.getChildren().add(this.createButton("Neein", "nein", actionListener));
        paneBastelecke.getChildren().add(this.createButton("Hilfe", "hilfe", actionListener));
        paneBastelecke.getChildren().add(this.createButton("Cool", "cool", actionListener));
        paneBastelecke.getChildren().add(this.createButton("Knarz", "knarz_equalized", actionListener));
        masterPane.getChildren().add(this.createLabel("Bastelecke"));
        masterPane.getChildren().add(paneBastelecke);

        final FlowPane paneFrank = this.createFlowPane();
        paneFrank.getChildren().add(this.createButton("Schafskäse", "schafskaese", actionListener));
        paneFrank.getChildren().add(this.createButton("Neeein", "nein_fmr", actionListener));
        paneFrank.getChildren().add(this.createButton("Aaaaaaah", "stoehner_fmr", actionListener));
        paneFrank.getChildren().add(this.createButton("Falsch", "falsch", actionListener));
        paneFrank.getChildren().add(this.createButton("Danköö", "dankoe", actionListener));
        paneFrank.getChildren().add(this.createButton("Bullshit", "bullshit", actionListener));
        paneFrank.getChildren().add(this.createButton("Kotzen", "kotzen", actionListener));
        paneFrank.getChildren().add(this.createButton("Hust", "hust", actionListener));
        masterPane.getChildren().add(this.createLabel("Frank"));
        masterPane.getChildren().add(paneFrank);

        final FlowPane paneMisc = this.createFlowPane();
        paneMisc.getChildren().add(this.createButton("Bieker", "bieker", actionListener));
        paneMisc.getChildren().add(this.createButton("Ballad", "ballad", actionListener));
        paneMisc.getChildren().add(this.createButton("Jeopardy", "jeopardy", actionListener));
        paneMisc.getChildren().add(this.createButton("Remote", "remoot", actionListener));
        paneMisc.getChildren().add(this.createButton("Delete", "delate", actionListener));
        paneMisc.getChildren().add(this.createButton("Snapshoot", "snapshoot", actionListener));
        paneMisc.getChildren().add(this.createButton("Khan", "khan", actionListener));
        paneMisc.getChildren().add(this.createButton("Essort", "essort", actionListener));
        paneMisc.getChildren().add(this.createButton("Wie geil", "geil", actionListener));
        paneMisc.getChildren().add(this.createButton("Fail", "gesch_reiner", actionListener));
        paneMisc.getChildren().add(this.createButton("Fail Satanic", "gescheitert_satan", actionListener));
        paneMisc.getChildren().add(this.createButton("Quiet!", "quiet", actionListener));
        paneMisc.getChildren().add(this.createButton("Höhöhö", "ddr", actionListener));
        paneMisc.getChildren().add(this.createButton("Ganz klar", "ganzklar", actionListener));
        paneMisc.getChildren().add(this.createButton("Altobelli", "altobelli", actionListener));
        paneMisc.getChildren().add(this.createButton("Tach", "tachzusammen", actionListener));
        paneMisc.getChildren().add(this.createButton("Lokal", "lokal", actionListener));
        paneMisc.getChildren().add(this.createButton("Was denn", "wasdenn", actionListener));
        masterPane.getChildren().add(this.createLabel("Misc"));
        masterPane.getChildren().add(paneMisc);

        final FlowPane paneJoeHanson = this.createFlowPane();
        paneJoeHanson.getChildren().add(this.createButton("BIDDE?", "bidde_fragend", actionListener));
        paneJoeHanson.getChildren().add(this.createButton("bidde?", "bidde_veraengstigt", actionListener));
        paneJoeHanson.getChildren().add(this.createButton("Reewert", "reewert", actionListener));
        paneJoeHanson.getChildren().add(this.createButton("Rewe", "rewe", actionListener));
        paneJoeHanson.getChildren().add(this.createButton("Das ist das", "dasist", actionListener));
        paneJoeHanson.getChildren().add(this.createButton("Eehm", "eehm", actionListener));
        paneJoeHanson.getChildren().add(this.createButton("Domäne", "domaene", actionListener));
        paneJoeHanson.getChildren().add(this.createButton("So nicht!", "sonicht", actionListener));
        paneJoeHanson.getChildren().add(this.createButton("Weißt Du's?", "weisstdus", actionListener));
        paneJoeHanson.getChildren().add(this.createButton("Konverter", "konverter", actionListener));
        paneJoeHanson.getChildren().add(this.createButton("Kaffee", "kaffee", actionListener));
        paneJoeHanson.getChildren().add(this.createButton("Annee-ne", "aneene", actionListener));
        masterPane.getChildren().add(this.createLabel("Joe Hanson"));
        masterPane.getChildren().add(paneJoeHanson);

        final Scene scene = new Scene(masterPane, 750, 520);

        primaryStage.getIcons().add(new Image(PanelFX.class.getResourceAsStream("icon.png")));
        primaryStage.setTitle("The Panel FX");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Label createLabel(final String caption) {
        final Label label = new Label(caption);
        label.setTextFill(Color.web("#EEEEEE"));
        return label;
    }

    private FlowPane createFlowPane() {
        return createFlowPane(true);
    }

    private FlowPane createFlowPane(boolean border) {
        final FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(5, 5, 5, 5));
        pane.setVgap(5);
        pane.setHgap(5);
        pane.setMinWidth(700);
        if (border) {
            pane.setStyle(" -fx-border-color: #777777; -fx-border-radius: 5;");
        }
        return pane;
    }

    private Button createButton(final String label, final String soundFileName, final EventHandler<ActionEvent> actionListener) {
        final Button button = new Button(label);
        button.setId(soundFileName);
        button.setOnAction(actionListener);
        button.setMinWidth(110);
        return button;
    }

    private EventHandler<MouseEvent> createControlButtonListener() {
        return new EventHandler<MouseEvent>() {

            @Override
            public void handle(final MouseEvent event) {
                final String actionSource = ((ImageView) event.getSource()).getId();

                if ("STOP".equals(actionSource)) {
                    runningSounds.stopAll();
                }
            }
        };
    }

    private EventHandler<ActionEvent> createButtonListener() {
        return new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent event) {
                final String actionSource = ((Button) event.getSource()).getId();

                final String url = PanelFX.class.getResource(actionSource + ".mp3").toString();
                final SoundThread sound = new SoundThread(url, PanelFX.this.runningSounds);
                sound.run();
            }
        };
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args
     *            the command line arguments
     */
    public static void main(final String[] args) {
        Application.launch(args);
    }
}
