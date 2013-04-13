package panelfx;

import java.util.ArrayList;
import java.util.List;

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

import javax.annotation.PostConstruct;

public class PanelView {
	private Scene scene;

	private final List<Button> soundButtons = new ArrayList<>();
	private ImageView muteView;

	public void registerSoundButtonActionListener(final EventHandler<ActionEvent> pushButtonEvent){

		for (final Button button : this.soundButtons){
			button.setOnAction(pushButtonEvent);
		}
	}

	public void registerControlActionListener(final EventHandler<MouseEvent> controlEvent){
		this.muteView.setOnMouseClicked(controlEvent);
	}

	public void show(final Stage stage) {
		stage.getIcons().add(new Image(PanelFX.class.getResourceAsStream("icon.png")));

		stage.setTitle("The Panel FX");
		stage.setScene(this.scene);
		stage.setResizable(false);
		stage.show();
	}

	@PostConstruct
	public void build() {

		final FlowPane masterPane = new FlowPane();
		masterPane.setPadding(new Insets(5, 20, 5, 20));
		masterPane.setVgap(5);
		masterPane.setHgap(5);
		final String image = PanelFX.class.getResource("wood.jpg").toExternalForm();
		masterPane.setStyle("-fx-background-image: url('" + image + "')");

		final FlowPane controllingPane = this.createFlowPane(false);
		final Image muteImage = new Image(getClass().getResourceAsStream("mute.png"));
		this.muteView = new ImageView(muteImage);
		this.muteView.setId("STOP");
		this.muteView.setCursor(Cursor.HAND);
		controllingPane.getChildren().add(this.muteView);
		controllingPane.setAlignment(Pos.CENTER_RIGHT);
		masterPane.getChildren().add(controllingPane);

		final FlowPane panePulpFiction = this.createFlowPane();
		panePulpFiction.getChildren().add(createButton("Was jetzt?", "wasjetzt"));
		panePulpFiction.getChildren().add(createButton("1 mal was", "was"));
		panePulpFiction.getChildren().add(createButton("Ich sag dir", "ansteht"));
		panePulpFiction.getChildren().add(createButton("Konzept", "konzept"));
		panePulpFiction.getChildren().add(createButton("Zur Seite", "butch"));
		panePulpFiction.getChildren().add(createButton("Nein Mann", "neinmann"));
		masterPane.getChildren().add(createLabel("Pulp Fiction"));
		masterPane.getChildren().add(panePulpFiction);

		final FlowPane paneBastelecke = this.createFlowPane();
		paneBastelecke.getChildren().add(createButton("Stand up", "standup"));
		paneBastelecke.getChildren().add(createButton("Cubage", "qbitch"));
		paneBastelecke.getChildren().add(createButton("Battle 1", "eurobattle1"));
		paneBastelecke.getChildren().add(createButton("Battle 3", "eurobattle3"));
		paneBastelecke.getChildren().add(createButton("Klingel 1. OG", "klingel"));
		paneBastelecke.getChildren().add(createButton("Alarm", "alarm"));
		paneBastelecke.getChildren().add(createButton("Push it", "pushit"));
		paneBastelecke.getChildren().add(createButton("Öööey", "oey"));
		paneBastelecke.getChildren().add(createButton("Lauschangriff", "lauschangriff"));
		paneBastelecke.getChildren().add(createButton("The Fog", "fog"));
		paneBastelecke.getChildren().add(createButton("Bäm", "baehm"));
		paneBastelecke.getChildren().add(createButton("Erbärmlich", "erbaermlich"));
		paneBastelecke.getChildren().add(createButton("HorHorHor", "kevin"));
		paneBastelecke.getChildren().add(createButton("Neein", "nein"));
		paneBastelecke.getChildren().add(createButton("Hilfe", "hilfe"));
		paneBastelecke.getChildren().add(createButton("Cool", "cool"));
		paneBastelecke.getChildren().add(createButton("Knarz", "knarz_equalized"));
		paneBastelecke.getChildren().add(createButton("Sorry", "sorry"));
		masterPane.getChildren().add(createLabel("Bastelecke"));
		masterPane.getChildren().add(paneBastelecke);

		final FlowPane paneFrank = this.createFlowPane();
		paneFrank.getChildren().add(createButton("Schafskäse", "schafskaese"));
		paneFrank.getChildren().add(createButton("Neeein", "nein_fmr"));
		paneFrank.getChildren().add(createButton("Aaaaaaah", "stoehner_fmr"));
		paneFrank.getChildren().add(createButton("Falsch", "falsch"));
		paneFrank.getChildren().add(createButton("Danköö", "dankoe"));
		paneFrank.getChildren().add(createButton("Bullshit", "bullshit"));
		paneFrank.getChildren().add(createButton("Kotzen", "kotzen"));
		paneFrank.getChildren().add(createButton("Hust", "hust"));
		paneFrank.getChildren().add(createButton("Frank Müller", "fmueller"));
		paneFrank.getChildren().add(createButton("Zur Lieferung", "lieferung"));
		paneFrank.getChildren().add(createButton("Steele 2", "steele2"));
		masterPane.getChildren().add(createLabel("Frank"));
		masterPane.getChildren().add(paneFrank);

		final FlowPane paneMisc = this.createFlowPane();
		paneMisc.getChildren().add(createButton("Bieker", "bieker"));
		paneMisc.getChildren().add(createButton("Ballad", "ballad"));
		paneMisc.getChildren().add(createButton("Jeopardy", "jeopardy"));
		paneMisc.getChildren().add(createButton("Remote", "remoot"));
		paneMisc.getChildren().add(createButton("Delete", "delate"));
		paneMisc.getChildren().add(createButton("Snapshoot", "snapshoot"));
		paneMisc.getChildren().add(createButton("Khan", "khan"));
		paneMisc.getChildren().add(createButton("Essort", "essort"));
		paneMisc.getChildren().add(createButton("Wie geil", "geil"));
		paneMisc.getChildren().add(createButton("Fail", "gesch_reiner"));
		paneMisc.getChildren().add(createButton("Fail Satanic", "gescheitert_satan"));
		paneMisc.getChildren().add(createButton("Quiet!", "quiet"));
		paneMisc.getChildren().add(createButton("Höhöhö", "ddr"));
		paneMisc.getChildren().add(createButton("Ganz klar", "ganzklar"));
		paneMisc.getChildren().add(createButton("Altobelli", "altobelli"));
		paneMisc.getChildren().add(createButton("Tach", "tachzusammen"));
		paneMisc.getChildren().add(createButton("Lokal", "lokal"));
		paneMisc.getChildren().add(createButton("Was denn", "wasdenn"));
		masterPane.getChildren().add(createLabel("Misc"));
		masterPane.getChildren().add(paneMisc);

		final FlowPane paneJoeHanson = this.createFlowPane();
		paneJoeHanson.getChildren().add(createButton("BIDDE?", "bidde_fragend"));
		paneJoeHanson.getChildren().add(createButton("bidde?", "bidde_veraengstigt"));
		paneJoeHanson.getChildren().add(createButton("Reewert", "reewert"));
		paneJoeHanson.getChildren().add(createButton("Rewe", "rewe"));
		paneJoeHanson.getChildren().add(createButton("Das ist das", "dasist"));
		paneJoeHanson.getChildren().add(createButton("Eehm", "eehm"));
		paneJoeHanson.getChildren().add(createButton("Domäne", "domaene"));
		paneJoeHanson.getChildren().add(createButton("So nicht!", "sonicht"));
		paneJoeHanson.getChildren().add(createButton("Weißt Du's?", "weisstdus"));
		paneJoeHanson.getChildren().add(createButton("Konverter", "konverter"));
		paneJoeHanson.getChildren().add(createButton("Kaffee", "kaffee"));
		paneJoeHanson.getChildren().add(createButton("Annee-ne", "aneene"));
		masterPane.getChildren().add(createLabel("Joe Hanson"));
		masterPane.getChildren().add(paneJoeHanson);

		//		this.scene = new Scene(masterPane, 750, 520);
		this.scene = new Scene(masterPane);
	}

	private Label createLabel(final String caption) {
		final Label label = new Label(caption);
		label.setTextFill(Color.web("#EEEEEE"));
		return label;
	}

	private FlowPane createFlowPane() {
		return createFlowPane(true);
	}

	private FlowPane createFlowPane(final boolean border) {
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

	private Button createButton(final String label, final String soundFileName) {
		final Button button = new Button(label);
		button.setId(soundFileName);
		button.setMinWidth(110);

		this.soundButtons.add(button);

		return button;
	}
}
