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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 *
 * @author ugz
 */
public class PanelFX extends Application {

    Button buttonAlarm = new Button("Alarm");
    Button buttonAnsteht = new Button("Was ansteht");
    Button buttonBaehm = new Button("Bäm");
    Button buttonBallad = new Button("Ballad");
    Button buttonBiddeFragend = new Button("Bitte?");
    Button buttonBiddeVeraengstigt = new Button("bidde?");
    Button buttonBieker = new Button("Bieker");
    Button buttonButch = new Button("Zur Seite");
    Button buttonDankoe = new Button("Danköö");
    Button buttonDasIst = new Button("Das ist das");
    Button buttonDelate = new Button("Delate");
    Button buttonDomaene = new Button("Domäne");
    Button buttonEehm = new Button("Eeehm");
    Button buttonErbaermlich = new Button("Erbärmlich");
    Button buttonEssort = new Button("Essort");
    Button buttonFalsch = new Button("Falsch");
    Button buttonFog = new Button("The Fog");
    Button buttonGeil = new Button("Wie geil");
    Button buttonGescheiterReiner = new Button("Fail");
    Button buttonGescheitertSatan = new Button("Fail satanic");
    Button buttonJeopardy = new Button("Jeopardy");
    Button buttonKaffee = new Button("Kaffee");
    Button buttonKevin = new Button("HorHorHor");
    Button buttonKhan = new Button("Khaan");
    Button buttonKonverter = new Button("Konverter");
    Button buttonKonzept = new Button("Aus dem Konzept");
    Button buttonLauschangriff = new Button("Lauschangriff");
    Button buttonNeinMann = new Button("Nein Mann");
    Button buttonOey = new Button("Öey");
    Button buttonQbitch = new Button("Cubage");
    Button buttonQuiet = new Button("Quiet");
    Button buttonRewert = new Button("Revert");
    Button buttonRemoot = new Button("Remoot");
    Button buttonRewe = new Button("Rewe");
    Button buttonSchafskaese = new Button("Schafskäse");
    Button buttonSnapshoot = new Button("Snapshoot");
    Button buttonSoNicht = new Button("So nicht!");
    Button buttonStandup = new Button("Standup");
    Button buttonWas = new Button("1 mal was");
    Button buttonWasJetzt = new Button("Was jetzt?");
    Button buttonWeisstDus = new Button("Weißt Du's?");


    @Override
    public void start(Stage primaryStage) {

        initButtons();
        StackPane root = new StackPane();
        FlowPane flow = new FlowPane();


        flow.setPadding(new Insets(5, 0, 5, 0));
        flow.setVgap(4);
        flow.setHgap(4);
        flow.setStyle("-fx-background-color: AAAAAA;");

        flow.getChildren().add(buttonAlarm);
        flow.getChildren().add(buttonAnsteht);
        flow.getChildren().add(buttonBaehm);
        flow.getChildren().add(buttonBallad);
        flow.getChildren().add(buttonBiddeFragend);
        flow.getChildren().add(buttonBiddeVeraengstigt);
        flow.getChildren().add(buttonBieker);

        flow.getChildren().add(buttonButch);
        flow.getChildren().add(buttonDankoe);
        flow.getChildren().add(buttonDasIst);
        flow.getChildren().add(buttonDelate);
        flow.getChildren().add(buttonDomaene);
        flow.getChildren().add(buttonEehm);
        flow.getChildren().add(buttonErbaermlich);
        flow.getChildren().add(buttonEssort);
        flow.getChildren().add(buttonFalsch);
        flow.getChildren().add(buttonFog);
        flow.getChildren().add(buttonGeil);
        flow.getChildren().add(buttonGescheiterReiner);
        flow.getChildren().add(buttonGescheitertSatan);
        flow.getChildren().add(buttonJeopardy);
        flow.getChildren().add(buttonKaffee);
        flow.getChildren().add(buttonKevin);
        flow.getChildren().add(buttonKhan);
        flow.getChildren().add(buttonKonverter);
        flow.getChildren().add(buttonKonzept);
        flow.getChildren().add(buttonLauschangriff);
        flow.getChildren().add(buttonNeinMann);
        flow.getChildren().add(buttonOey);
        flow.getChildren().add(buttonQbitch);
        flow.getChildren().add(buttonQuiet);
        flow.getChildren().add(buttonRewert);
        flow.getChildren().add(buttonRemoot);
        flow.getChildren().add(buttonRewe);
        flow.getChildren().add(buttonSchafskaese);
        flow.getChildren().add(buttonSoNicht);
        flow.getChildren().add(buttonStandup);
        flow.getChildren().add(buttonWas);
        flow.getChildren().add(buttonWasJetzt);
        flow.getChildren().add(buttonWeisstDus);


        Scene scene = new Scene(flow, 600, 400);
        primaryStage.setTitle("The Panel");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initButtons() {
        EventHandler actionListener = createButtonListener();

        buttonAlarm.setId("alarm");
        buttonAlarm.setOnAction(actionListener);

        buttonAnsteht.setId("ansteht");
        buttonAnsteht.setOnAction(actionListener);

        buttonBaehm.setId("baehm");
        buttonBaehm.setOnAction(actionListener);

        buttonBallad.setId("ballad");
        buttonBallad.setOnAction(actionListener);

        buttonBiddeFragend.setId("bidde_fragend");
        buttonBiddeFragend.setOnAction(actionListener);

        buttonBiddeVeraengstigt.setId("bidde_veraengstigt");
        buttonBiddeVeraengstigt.setOnAction(actionListener);

        buttonBieker.setId("bieker");
        buttonBieker.setOnAction(actionListener);

        buttonButch.setId("butch");
        buttonButch.setOnAction(actionListener);

        buttonDankoe.setId("dankoe");
        buttonDankoe.setOnAction(actionListener);

        buttonDasIst.setId("dasist");
        buttonDasIst.setOnAction(actionListener);

        buttonDelate.setId("delate");
        buttonDelate.setOnAction(actionListener);

        buttonDomaene.setId("domaene");
        buttonDomaene.setOnAction(actionListener);

        buttonEehm.setId("eehm");
        buttonEehm.setOnAction(actionListener);

        buttonErbaermlich.setId("erbaermlich");
        buttonErbaermlich.setOnAction(actionListener);

        buttonEssort.setId("essort");
        buttonEssort.setOnAction(actionListener);

        buttonFalsch.setId("falsch");
        buttonFalsch.setOnAction(actionListener);

        buttonFog.setId("fog");
        buttonFog.setOnAction(actionListener);

        buttonGeil.setId("geil");
        buttonGeil.setOnAction(actionListener);

        buttonGescheiterReiner.setId("gesch_reiner");
        buttonGescheiterReiner.setOnAction(actionListener);

        buttonGescheitertSatan.setId("gescheitert_satan");
        buttonGescheitertSatan.setOnAction(actionListener);

        buttonJeopardy.setId("jeopardy");
        buttonJeopardy.setOnAction(actionListener);

        buttonKaffee.setId("kaffee");
        buttonKaffee.setOnAction(actionListener);

        buttonKevin.setId("kevin");
        buttonKevin.setOnAction(actionListener);

        buttonKhan.setId("khan");
        buttonKhan.setOnAction(actionListener);

        buttonKonverter.setId("konverter");
        buttonKonverter.setOnAction(actionListener);

        buttonKonzept.setId("konzept");
        buttonKonzept.setOnAction(actionListener);

        buttonLauschangriff.setId("lauschangriff");
        buttonLauschangriff.setOnAction(actionListener);

        buttonNeinMann.setId("neinmann");
        buttonNeinMann.setOnAction(actionListener);

        buttonOey.setId("oey");
        buttonOey.setOnAction(actionListener);

        buttonQbitch.setId("qbitch");
        buttonQbitch.setOnAction(actionListener);

        buttonQuiet.setId("quiet");
        buttonQuiet.setOnAction(actionListener);

        buttonRewert.setId("reewert");
        buttonRewert.setOnAction(actionListener);

        buttonRemoot.setId("remoot");
        buttonRemoot.setOnAction(actionListener);

        buttonRewe.setId("rewe");
        buttonRewe.setOnAction(actionListener);

        buttonSchafskaese.setId("schafskaese");
        buttonSchafskaese.setOnAction(actionListener);

        buttonSnapshoot.setId("snapshoot");
        buttonSnapshoot.setOnAction(actionListener);

        buttonSoNicht.setId("sonicht");
        buttonSoNicht.setOnAction(actionListener);

        buttonStandup.setId("standup");
        buttonStandup.setOnAction(actionListener);

        buttonWas.setId("was");
        buttonWas.setOnAction(actionListener);

        buttonWasJetzt.setId("wasjetzt");
        buttonWasJetzt.setOnAction(actionListener);

        buttonWeisstDus.setId("weisstdus");
        buttonWeisstDus.setOnAction(actionListener);
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
