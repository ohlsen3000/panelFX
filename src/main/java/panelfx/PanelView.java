package panelfx;

import java.util.HashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.annotation.PostConstruct;

public class PanelView {

	private Scene scene;
	private final Map<Sound, Button> soundButtons = new HashMap<>();
	private ImageView muteView;
	private TabPane tabPane;
	private Tab primaryTab;
	private Tab movieTab;
	private Tab newbiesTab;

	public void registerSoundButtonActionListener(final EventHandler<ActionEvent> pushButtonEvent) {

		for (final Button button : this.soundButtons.values()) {
			button.setOnAction(pushButtonEvent);
		}
	}

	public void registerControlActionListener(final EventHandler<MouseEvent> controlEvent) {
		this.muteView.setOnMouseClicked(controlEvent);
	}

	public void show(final Stage stage) {
		stage.getIcons().add(new Image(PanelFX.class.getResourceAsStream("icon.png")));

		stage.setTitle("The Panel FX");
		stage.setScene(this.scene);
		stage.setResizable(false);
		stage.show();
	}

	private void createButtons() {

		for (final Sound sound : Sound.values()) {
			final Button button = new Button(sound.getLabel());
			button.setId(sound.getFilename());
			button.setMinWidth(110);

			this.soundButtons.put(sound, button);
		}
	}

	@PostConstruct
	public void build() {

		createButtons();

		final FlowPane masterPane = new FlowPane();
		masterPane.setPadding(new Insets(5, 20, 30, 20));
		masterPane.setVgap(5);
		masterPane.setHgap(5);

		final FlowPane controllingPane = this.createFlowPane(false);
		final Image muteImage = new Image(this.getClass().getResourceAsStream("mute.png"));
		this.muteView = new ImageView(muteImage);
		this.muteView.setId("STOP");
		this.muteView.setCursor(Cursor.HAND);
		controllingPane.getChildren().add(this.muteView);
		controllingPane.setAlignment(Pos.CENTER_RIGHT);
		masterPane.getChildren().add(controllingPane);

		this.tabPane = new TabPane();

		masterPane.getChildren().add(this.tabPane);

		createPrimaryTab();
		createMovieTab();
		createClassicsTab();

		this.scene = new Scene(masterPane);
		this.scene.getStylesheets().addAll(PanelFX.class.getResource("stylesheet.css").toExternalForm());
	}

	private void createPrimaryTab() {

		this.primaryTab = new Tab("Hits");
		this.primaryTab.setClosable(false);
		this.tabPane.getTabs().add(this.primaryTab);

		final FlowPane primaryTabContent = new FlowPane();
		primaryTabContent.setPadding(new Insets(10, 0, 0, 0));
		primaryTabContent.getStyleClass().add("wood-shifted");
		this.primaryTab.setContent(primaryTabContent);

		final FlowPane paneBastelecke = this.createFlowPane(Sound.STANDUP, Sound.CUBAGE, Sound.BATTLE1, Sound.BATTLE3, Sound.DOORBELL, Sound.ALARM,
				Sound.PUSH_IT, Sound.OEOEOEEY, Sound.LAUSCHANGRIFF, Sound.FOG, Sound.BAEM, Sound.ERBAERMLICH, Sound.HORHOR, Sound.NEIN_ULTZ, Sound.HILFE,
				Sound.COOL, Sound.KNARZ, Sound.SORRY);

		primaryTabContent.getChildren().add(createLabel("Bastelecke"));
		primaryTabContent.getChildren().add(paneBastelecke);

		final FlowPane paneFrank = this.createFlowPane(Sound.NEIN_FRALLER, Sound.AAAAAAH, Sound.FALSCH, Sound.DANKOEOE, Sound.BULLSHIT, Sound.KOTZEN,
				Sound.HUST, Sound.FRANK_MUELLER, Sound.ZUR_LIEFERUNG, Sound.SCHAFSKAESE, Sound.STEELE2);

		primaryTabContent.getChildren().add(createLabel("Frank"));
		primaryTabContent.getChildren().add(paneFrank);

		final FlowPane paneMisc = this.createFlowPane(Sound.WAS_DU_GLAUBST_MAROHDE, Sound.JEOPARDY, Sound.REMOTE, Sound.DELETE, Sound.SNAPHOT, Sound.KHAN,
				Sound.ASSERT, Sound.WIE_GEIL, Sound.FAIL, Sound.FAIL_SATANIC, Sound.LAUGHING_DIYER, Sound.GANZ_KLAR, Sound.ALTOBELLI, Sound.TACH, Sound.LOKAL,
				Sound.WAS_DENN, Sound.NJAEH);

		primaryTabContent.getChildren().add(createLabel("Misc"));
		primaryTabContent.getChildren().add(paneMisc);

		final FlowPane paneJoeHanson = this.createFlowPane(Sound.BIDDE_QUESTIONING, Sound.BIDDE_IN_TROUBLE, Sound.REVERT, Sound.REWE,
				Sound.EEHM, Sound.DOMAIN, Sound.SO_NICHT, Sound.WEISST_DUS, Sound.CONVERTER, Sound.COFFEE, Sound.ANNEE_NE);

		primaryTabContent.getChildren().add(createLabel("Jother"));
		primaryTabContent.getChildren().add(paneJoeHanson);
	}

	private void createMovieTab() {

		this.movieTab = new Tab("Filmzitate");
		this.movieTab.setClosable(false);
		this.tabPane.getTabs().add(this.movieTab);

		final FlowPane tabContent = new FlowPane();
		tabContent.setPadding(new Insets(10, 0, 0, 0));
		tabContent.getStyleClass().add("wood-shifted");
		this.movieTab.setContent(tabContent);

		final FlowPane panePulpFiction = this.createFlowPane(Sound.WAS_JETZT, Sound.EINMAL_WAS, Sound.ANSTEHT, Sound.KONZEPT, Sound.ZUR_SEITE, Sound.NEIN_MANN);

		tabContent.getChildren().add(createLabel("Pulp Fiction"));
		tabContent.getChildren().add(panePulpFiction);

		final FlowPane pokerPane = this.createFlowPane(Sound.SPIEL_LERNEN, Sound.NICHT_GESCHOBEN);

		tabContent.getChildren().add(createLabel("Poker-Filme"));
		tabContent.getChildren().add(pokerPane);

		final FlowPane bangBoomBangPane = this.createFlowPane(Sound.ABSTECHEN, Sound.SCHEISS_LAUNE);

		tabContent.getChildren().add(createLabel("Bang Boom Bang"));
		tabContent.getChildren().add(bangBoomBangPane);
		
		final FlowPane lifeOfBrianPane = this.createFlowPane(Sound.WIDERPORST, Sound.PURCHE, Sound.JA_NATUERLICH, Sound.WEIBSVOLK);

		tabContent.getChildren().add(createLabel("Das Leben des Brian"));
		tabContent.getChildren().add(lifeOfBrianPane);
	}

	private void createClassicsTab() {

		this.newbiesTab = new Tab("Klassiker");
		this.newbiesTab.setClosable(false);
		this.tabPane.getTabs().add(this.newbiesTab);

		final FlowPane tabContent = new FlowPane();
		tabContent.setPadding(new Insets(10, 0, 0, 0));
		tabContent.getStyleClass().add("wood-shifted");
		this.newbiesTab.setContent(tabContent);

		final FlowPane cubageTeamSounds = this.createFlowPane(Sound.SLAPSTICK, Sound.WAS_DU_GLAUBST_JOTHER, Sound.FAHRRADKETTE);
		tabContent.getChildren().add(createLabel("Cubage Team (2010 - 2012)"));
		tabContent.getChildren().add(cubageTeamSounds);

		final FlowPane basteleckeSounds = this.createFlowPane(Sound.BIEKER, Sound.BALLAD);
		tabContent.getChildren().add(createLabel("Bastelecke Team (2012 - present)"));
		tabContent.getChildren().add(basteleckeSounds);

		final FlowPane shrinePanel = this.createFlowPane(Sound.GUDE_LAUNE, Sound.SCHLAEGEREI, Sound.FEIERGEMEINDE);
		tabContent.getChildren().add(createLabel("The Shrine"));
		tabContent.getChildren().add(shrinePanel);

		final FlowPane mediamarktPanel = this.createFlowPane(Sound.ZWEIHUNDERT_PULS, Sound.BILDSCHIRM, Sound.SCHEISE);
		tabContent.getChildren().add(createLabel("Mediamarkt"));
		tabContent.getChildren().add(mediamarktPanel);
	}

	private void addSound(final FlowPane flowPane, final Sound sound) {
		flowPane.getChildren().add(this.soundButtons.get(sound));
	}

	private Label createLabel(final String caption) {
		final Label label = new Label(caption);
		label.setTextFill(Color.web("#EEEEEE"));
		return label;
	}

	private FlowPane createFlowPane(final Sound... sounds) {
		final FlowPane pane = this.createFlowPane(true);

		for (final Sound sound : sounds) {
			addSound(pane, sound);
		}
		return pane;
	}

	private FlowPane createFlowPane(final boolean border) {
		final FlowPane pane = new FlowPane();
		pane.setPadding(new Insets(5, 5, 5, 5));
		pane.setVgap(5);
		pane.setHgap(5);
		pane.setMinWidth(700);
		if (border) {
			pane.getStyleClass().add("button-group");
		}
		return pane;
	}
}
