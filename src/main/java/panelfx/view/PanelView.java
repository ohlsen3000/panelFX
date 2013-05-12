package panelfx.view;

import java.util.HashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.annotation.PostConstruct;

import panelfx.PanelFX;
import panelfx.sound.Sound;
import panelfx.timer.TeaTimer;
import panelfx.timer.views.AnalogClockView;
import panelfx.timer.views.DigitalClockView;
import panelfx.timer.views.ProgressBarView;

public class PanelView {

	public static final int WIDTH = 740;
	public static final int PADDING_LEFT_RIGHT = 20;

	private Scene scene;
	private final Map<Sound, Button> soundButtons = new HashMap<>();
	private ImageView muteView;
	private TabPane tabPane;
	private Tab primaryTab;
	private Tab movieTab;
	private Tab newbiesTab;
	private Tab timerTab;
	private TeaTimer teaTimer;
	private TextField minutes;
	private TextField seconds;

	public void registerSoundButtonActionListener(
			final EventHandler<ActionEvent> pushButtonEvent) {

		for (final Button button : this.soundButtons.values()) {
			button.setOnAction(pushButtonEvent);
		}
	}

	public void registerControlActionListener(
			final EventHandler<MouseEvent> controlEvent) {
		this.muteView.setOnMouseClicked(controlEvent);
	}

	public void show(final Stage stage) {
		stage.getIcons().add(
				new Image(PanelFX.class.getResourceAsStream("icon.png")));

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
		masterPane.setPadding(new Insets(5, PanelView.PADDING_LEFT_RIGHT, 30,
				PanelView.PADDING_LEFT_RIGHT));
		masterPane.setVgap(5);
		masterPane.setHgap(5);

		final FlowPane controllingPane = new FlowPane();
		controllingPane.setMaxWidth(PanelView.WIDTH - 2
				* PanelView.PADDING_LEFT_RIGHT);
		controllingPane.setMinWidth(PanelView.WIDTH - 2
				* PanelView.PADDING_LEFT_RIGHT);
		final Image muteImage = new Image(this.getClass().getResourceAsStream(
				"mute.png"));
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
		createSoundsTab();
		createTimerTab();

		this.scene = new Scene(masterPane);
		this.scene.getStylesheets().addAll(
				PanelFX.class.getResource("stylesheet.css").toExternalForm());
	}

	private void createPrimaryTab() {

		this.primaryTab = new Tab("Hits");
		this.primaryTab.setClosable(false);
		this.tabPane.getTabs().add(this.primaryTab);

		final FlowPane tabContent = new FlowPane();
		tabContent.setVgap(5);
		tabContent.setHgap(5);
		tabContent.setPadding(new Insets(10, 0, 0, 0));
		tabContent.getStyleClass().add("wood-shifted");
		this.primaryTab.setContent(tabContent);

		final FlowPane paneBastelecke = new ButtonGroup("Bastelecke",
				this.soundButtons, Sound.STANDUP, Sound.CUBAGE, Sound.BATTLE1,
				Sound.BATTLE3, Sound.DOORBELL, Sound.ALARM, Sound.PUSH_IT,
				Sound.OEOEOEEY, Sound.LAUSCHANGRIFF, Sound.FOG, Sound.BAEM,
				Sound.ERBAERMLICH, Sound.HORHOR, Sound.NEIN_ULTZ, Sound.HILFE,
				Sound.COOL, Sound.KNARZ, Sound.SORRY);

		tabContent.getChildren().add(paneBastelecke);

		final FlowPane paneFrank = new ButtonGroup("Frank", this.soundButtons,
				Sound.NEIN_FRALLER, Sound.AAAAAAH, Sound.FALSCH,
				Sound.DANKOEOE, Sound.BULLSHIT, Sound.KOTZEN, Sound.HUST,
				Sound.FRANK_MUELLER, Sound.ZUR_LIEFERUNG, Sound.SCHAFSKAESE,
				Sound.STEELE2);

		tabContent.getChildren().add(paneFrank);

		final FlowPane bSides = new ButtonGroup("Misc", this.soundButtons,
				Sound.WAS_DU_GLAUBST_MAROHDE, Sound.COFFEE_MAKER_BASTELECKE,
				Sound.REMOTE, Sound.DELETE, Sound.SNAPHOT, Sound.KHAN,
				Sound.ASSERT, Sound.WIE_GEIL, Sound.FAIL, Sound.FAIL_SATANIC,
				Sound.LAUGHING_DIYER, Sound.GANZ_KLAR, Sound.ALTOBELLI,
				Sound.TACH, Sound.LOKAL, Sound.WAS_DENN, Sound.NJAEH,
				Sound.QUIET);

		tabContent.getChildren().add(bSides);

		final FlowPane paneJoeHanson = new ButtonGroup("Jother",
				this.soundButtons, Sound.BIDDE_QUESTIONING,
				Sound.BIDDE_IN_TROUBLE, Sound.REVERT, Sound.REWE, Sound.EEHM,
				Sound.DOMAIN, Sound.SO_NICHT, Sound.WEISST_DUS,
				Sound.CONVERTER, Sound.COFFEE, Sound.ANNEE_NE);

		tabContent.getChildren().add(paneJoeHanson);
	}

	private void createMovieTab() {

		this.movieTab = new Tab("Filmzitate");
		this.movieTab.setClosable(false);
		this.tabPane.getTabs().add(this.movieTab);

		final FlowPane tabContent = new FlowPane();
		tabContent.setPadding(new Insets(10, 0, 0, 0));
		tabContent.setVgap(5);
		tabContent.setHgap(5);
		tabContent.getStyleClass().add("wood-shifted");
		this.movieTab.setContent(tabContent);

		final FlowPane panePulpFiction = new ButtonGroup("Pulp Fiction",
				this.soundButtons, Sound.WAS_JETZT, Sound.EINMAL_WAS,
				Sound.ANSTEHT, Sound.KONZEPT, Sound.ZUR_SEITE, Sound.NEIN_MANN);

		tabContent.getChildren().add(panePulpFiction);

		final FlowPane pokerPane = new ButtonGroup("Poker-Filme",
				this.soundButtons, Sound.NICHT_GESCHOBEN, Sound.LASS_SEIN,
				Sound.DU_BEISST, Sound.RICHTIG_GEPOKERT, Sound.QUEEN_TEN,
				Sound.REAL, Sound.FREAKING_IDIOTS, Sound.SO_SICK);

		tabContent.getChildren().add(pokerPane);

		final FlowPane callOnToDancePane = new ButtonGroup(
				"Aufforderung zum Tanz", this.soundButtons, Sound.NASSER_SACK,
				Sound.TANGO, Sound.GEBUNKERT, Sound.RASIERT,
				Sound.VORLETZTES_SPIEL, Sound.SPIEL_LERNEN, Sound.GAR_NICHT,
				Sound.VERABSCHIEDEN, Sound.SEPPL, Sound.FEIERABEND,
				Sound.SCHNAUZE_VOLL, Sound.SENSE);

		tabContent.getChildren().add(callOnToDancePane);

		final FlowPane bangBoomBangPane = new ButtonGroup("Bang Boom Bang",
				this.soundButtons, Sound.ABSTECHEN, Sound.SCHEISS_LAUNE);
		tabContent.getChildren().add(bangBoomBangPane);

		final FlowPane ottoPane = new ButtonGroup("Otto - Der Film",
				this.soundButtons, Sound.ZWEI_DINGE);
		tabContent.getChildren().add(ottoPane);

		final FlowPane lifeOfBrianPane = new ButtonGroup("Das Leben des Brian",
				this.soundButtons, Sound.WIDERPORST, Sound.PURCHE,
				Sound.JA_NATUERLICH, Sound.WEIBSVOLK, Sound.ER_SIE);

		tabContent.getChildren().add(lifeOfBrianPane);

		final FlowPane revengeOfTheDispossessedPane = new ButtonGroup(
				"Didi und die Rache der Enterbten", this.soundButtons,
				Sound.WEITERMACHEN, Sound.RUEDIGER, Sound.OMINOES,
				Sound.KEINE_TRICKS, Sound.VERSAGER, Sound.MUELLTONNE,
				Sound.PFEIFENWICHS, Sound.FRAGE);

		tabContent.getChildren().add(revengeOfTheDispossessedPane);

	}

	private void createClassicsTab() {

		this.newbiesTab = new Tab("Klassiker");
		this.newbiesTab.setClosable(false);
		this.tabPane.getTabs().add(this.newbiesTab);

		final FlowPane tabContent = new FlowPane();
		tabContent.setVgap(5);
		tabContent.setHgap(5);
		tabContent.setPadding(new Insets(10, 0, 0, 0));
		tabContent.getStyleClass().add("wood-shifted");
		this.newbiesTab.setContent(tabContent);

		final FlowPane cubageTeamSounds = new ButtonGroup(
				"Cubage Team (2010 - 2012)", this.soundButtons,
				Sound.SLAPSTICK, Sound.WAS_DU_GLAUBST_JOTHER,
				Sound.FAHRRADKETTE, Sound.SCHROTTKERL);
		tabContent.getChildren().add(cubageTeamSounds);

		final FlowPane basteleckeSounds = new ButtonGroup(
				"Bastelecke Team (2012 - present)", this.soundButtons,
				Sound.BIEKER, Sound.BALLAD, Sound.JEOPARDY);
		tabContent.getChildren().add(basteleckeSounds);

		final FlowPane shrinePanel = new ButtonGroup("The Shrine",
				this.soundButtons, Sound.GUDE_LAUNE, Sound.SCHLAEGEREI,
				Sound.FEIERGEMEINDE);
		tabContent.getChildren().add(shrinePanel);

		final FlowPane mediamarktPanel = new ButtonGroup("Mediamarkt",
				this.soundButtons, Sound.ZWEIHUNDERT_PULS, Sound.BILDSCHIRM,
				Sound.SCHEISE);
		tabContent.getChildren().add(mediamarktPanel);
	}

	private void createSoundsTab() {

		this.newbiesTab = new Tab("B-Seiten");
		this.newbiesTab.setClosable(false);
		this.tabPane.getTabs().add(this.newbiesTab);

		final FlowPane tabContent = new FlowPane();
		tabContent.setVgap(5);
		tabContent.setHgap(5);
		tabContent.setPadding(new Insets(10, 0, 0, 0));
		tabContent.getStyleClass().add("wood-shifted");
		this.newbiesTab.setContent(tabContent);

		final FlowPane laughing = new ButtonGroup("Lachen", this.soundButtons,
				Sound.ERNIE_LACHEN, Sound.HOEHOEHOEHOEHOE, Sound.SNOOPY_LACHEN,
				Sound.LACHEN_PEANUTS, Sound.MURMEL_LACHEN);
		tabContent.getChildren().add(laughing);

		final FlowPane comic = new ButtonGroup("Zeichentrick",
				this.soundButtons, Sound.BOING_SINGLE, Sound.BOING,
				Sound.SWOOSH, Sound.SLIDE, Sound.SCHUSS_PEANUTS,
				Sound.BLAH_BLAH, Sound.HIGH_PITCH, Sound.AAH, Sound.HAEMMERN);
		tabContent.getChildren().add(comic);

		final FlowPane misc = new ButtonGroup("Sonstiges", this.soundButtons,
				Sound.SAMETIME, Sound.DOD, Sound.GRAUEN, Sound.BEEP,
				Sound.FUNKTIONAL_KAPUTT);
		tabContent.getChildren().add(misc);

	}

	private void createTimerTab() {

		this.timerTab = new Tab("Tea Timer");
		this.timerTab.setClosable(false);
		this.tabPane.getTabs().add(this.timerTab);

		final VBox tabContent = new VBox();
		tabContent.getStyleClass().add("wood-shifted");
		tabContent.setSpacing(30);
		tabContent.setPadding(new Insets(20));
		this.timerTab.setContent(tabContent);

		final GridPane timeInputPane = new GridPane();
		timeInputPane.setPadding(new Insets(10, 10, 10, 0));
		timeInputPane.setVgap(5);
		timeInputPane.setHgap(5);

		this.minutes = new TextField();
		this.minutes.setPromptText("min");
		this.minutes.setPrefColumnCount(3);
		GridPane.setConstraints(this.minutes, 0, 0);
		timeInputPane.getChildren().add(this.minutes);

		this.seconds = new TextField();
		this.seconds.setPromptText("sec");
		this.seconds.setPrefColumnCount(3);
		GridPane.setConstraints(this.seconds, 1, 0);
		timeInputPane.getChildren().add(this.seconds);

		final Button start = new Button("Start");
		GridPane.setConstraints(start, 2, 0);
		timeInputPane.getChildren().add(start);
		start.setOnAction(createStartButtonListener());

		final Pane clockView = new Pane();
		clockView.setMinHeight(200);
		this.teaTimer = new TeaTimer(clockView);

		tabContent.getChildren().add(timeInputPane);
		tabContent.getChildren().add(clockView);

		final FlowPane controlButtons = new FlowPane();
		tabContent.getChildren().add(controlButtons);

		final Button digital = new Button("Digital View");
		digital.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(final ActionEvent t) {
				PanelView.this.teaTimer.setView(new DigitalClockView());
			}
		});
		controlButtons.getChildren().add(digital);

		final Button bar = new Button("Progressbar View");
		bar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(final ActionEvent t) {
				PanelView.this.teaTimer.setView(new ProgressBarView());
			}
		});
		controlButtons.getChildren().add(bar);

		final Button clock = new Button("Clock View");
		clock.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(final ActionEvent t) {
				PanelView.this.teaTimer.setView(new AnalogClockView());
			}
		});
		controlButtons.getChildren().add(clock);
	}

	private EventHandler<ActionEvent> createStartButtonListener() {
		return new EventHandler<ActionEvent>() {

			@Override
			public void handle(final ActionEvent event) {
				int minutes = 0;
				try {
					minutes = Integer.valueOf(PanelView.this.minutes.getText());
				} catch (final Exception exc) {
					// silently
				}
				int seconds = 0;
				try {
					seconds = Integer.valueOf(PanelView.this.seconds.getText());
				} catch (final Exception exc) {
					// silently
				}
				final int totalSeconds = minutes * 60 + seconds;
				PanelView.this.teaTimer.start(totalSeconds);
			}
		};
	}

}
