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
import javafx.scene.control.Label;
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
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.annotation.PostConstruct;

import panelfx.PanelFX;
import panelfx.sound.Sound;
import panelfx.timer.TeaTimer;

public class PanelView {

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

        this.createButtons();

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

        this.createPrimaryTab();
        this.createMovieTab();
        this.createClassicsTab();
        this.createSoundsTab();
        this.createTimerTab();

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

        primaryTabContent.getChildren().add(this.createLabel("Bastelecke"));
        primaryTabContent.getChildren().add(paneBastelecke);

        final FlowPane paneFrank = this.createFlowPane(Sound.NEIN_FRALLER, Sound.AAAAAAH, Sound.FALSCH, Sound.DANKOEOE, Sound.BULLSHIT, Sound.KOTZEN,
                Sound.HUST, Sound.FRANK_MUELLER, Sound.ZUR_LIEFERUNG, Sound.SCHAFSKAESE, Sound.STEELE2);

        primaryTabContent.getChildren().add(this.createLabel("Fraller"));
        primaryTabContent.getChildren().add(paneFrank);

        final FlowPane paneMisc = this.createFlowPane(Sound.WAS_DU_GLAUBST_MAROHDE, Sound.JEOPARDY, Sound.REMOTE, Sound.DELETE, Sound.SNAPHOT, Sound.KHAN,
                Sound.ASSERT, Sound.WIE_GEIL, Sound.FAIL, Sound.FAIL_SATANIC, Sound.LAUGHING_DIYER, Sound.GANZ_KLAR, Sound.ALTOBELLI, Sound.TACH, Sound.LOKAL,
                Sound.WAS_DENN, Sound.NJAEH, Sound.QUIET);

        primaryTabContent.getChildren().add(this.createLabel("Misc"));
        primaryTabContent.getChildren().add(paneMisc);

        final FlowPane paneJoeHanson = this.createFlowPane(Sound.BIDDE_QUESTIONING, Sound.BIDDE_IN_TROUBLE, Sound.REVERT, Sound.REWE, Sound.EEHM, Sound.DOMAIN,
                Sound.SO_NICHT, Sound.WEISST_DUS, Sound.CONVERTER, Sound.COFFEE, Sound.ANNEE_NE);

        primaryTabContent.getChildren().add(this.createLabel("Jother"));
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

        tabContent.getChildren().add(this.createLabel("Pulp Fiction"));
        tabContent.getChildren().add(panePulpFiction);

        final FlowPane pokerPane = this.createFlowPane(Sound.NICHT_GESCHOBEN, Sound.LASS_SEIN, Sound.DU_BEISST, Sound.RICHTIG_GEPOKERT, Sound.QUEEN_TEN,
                Sound.REAL, Sound.FREAKING_IDIOTS, Sound.SO_SICK);

        tabContent.getChildren().add(this.createLabel("Poker-Filme"));
        tabContent.getChildren().add(pokerPane);

        final FlowPane callOnToDancePane = this.createFlowPane(Sound.NASSER_SACK, Sound.TANGO, Sound.GEBUNKERT, Sound.RASIERT, Sound.VORLETZTES_SPIEL,
                Sound.SPIEL_LERNEN, Sound.GAR_NICHT, Sound.VERABSCHIEDEN, Sound.SEPPL, Sound.FEIERABEND, Sound.SCHNAUZE_VOLL, Sound.SENSE);

        tabContent.getChildren().add(this.createLabel("Aufforderung zum Tanz"));
        tabContent.getChildren().add(callOnToDancePane);

        final FlowPane bangBoomBangPane = this.createFlowPane(Sound.ABSTECHEN, Sound.SCHEISS_LAUNE);

        tabContent.getChildren().add(this.createLabel("Bang Boom Bang"));
        tabContent.getChildren().add(bangBoomBangPane);

        final FlowPane lifeOfBrianPane = this.createFlowPane(Sound.WIDERPORST, Sound.PURCHE, Sound.JA_NATUERLICH, Sound.WEIBSVOLK, Sound.ER_SIE);

        tabContent.getChildren().add(this.createLabel("Das Leben des Brian"));
        tabContent.getChildren().add(lifeOfBrianPane);

        final FlowPane revengeOfTheDispossessedPane = this.createFlowPane(Sound.WEITERMACHEN, Sound.RUEDIGER, Sound.OMINOES, Sound.KEINE_TRICKS,
                Sound.VERSAGER, Sound.MUELLTONNE, Sound.PFEIFENWICHS, Sound.FRAGE);

        tabContent.getChildren().add(this.createLabel("Didi und die Rache der Enterbten"));
        tabContent.getChildren().add(revengeOfTheDispossessedPane);

        final FlowPane ottoPane = this.createFlowPane(Sound.ZWEI_DINGE);

        tabContent.getChildren().add(this.createLabel("Otto - Der Film"));
        tabContent.getChildren().add(ottoPane);
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
        tabContent.getChildren().add(this.createLabel("Cubage Team (2010 - 2012)"));
        tabContent.getChildren().add(cubageTeamSounds);

        final FlowPane basteleckeSounds = this.createFlowPane(Sound.BIEKER, Sound.BALLAD);
        tabContent.getChildren().add(this.createLabel("Bastelecke Team (2012 - present)"));
        tabContent.getChildren().add(basteleckeSounds);

        final FlowPane shrinePanel = this.createFlowPane(Sound.GUDE_LAUNE, Sound.SCHLAEGEREI, Sound.FEIERGEMEINDE);
        tabContent.getChildren().add(this.createLabel("The Shrine"));
        tabContent.getChildren().add(shrinePanel);

        final FlowPane mediamarktPanel = this.createFlowPane(Sound.ZWEIHUNDERT_PULS, Sound.BILDSCHIRM, Sound.SCHEISE);
        tabContent.getChildren().add(this.createLabel("Mediamarkt"));
        tabContent.getChildren().add(mediamarktPanel);
    }

    private void createSoundsTab() {

        this.newbiesTab = new Tab("Diverse");
        this.newbiesTab.setClosable(false);
        this.tabPane.getTabs().add(this.newbiesTab);

        final FlowPane tabContent = new FlowPane();
        tabContent.setPadding(new Insets(10, 0, 0, 0));
        tabContent.getStyleClass().add("wood-shifted");
        this.newbiesTab.setContent(tabContent);

        final FlowPane laughing = this.createFlowPane(Sound.ERNIE_LACHEN, Sound.HOEHOEHOEHOEHOE);
        tabContent.getChildren().add(this.createLabel("Lachen"));
        tabContent.getChildren().add(laughing);

        final FlowPane comic = this.createFlowPane(Sound.BOING);
        tabContent.getChildren().add(this.createLabel("Zeichentrick"));
        tabContent.getChildren().add(comic);

        final FlowPane misc = this.createFlowPane(Sound.SAMETIME, Sound.DOD, Sound.GRAUEN, Sound.BEEP, Sound.FUNKTIONAL_KAPUTT);
        tabContent.getChildren().add(this.createLabel("Sonstiges"));
        tabContent.getChildren().add(misc);

    }

    private void createTimerTab() {

        this.timerTab = new Tab("Tea Timer");
        this.timerTab.setClosable(false);
        this.tabPane.getTabs().add(this.timerTab);

        final VBox tabContent = new VBox();
        tabContent.getStyleClass().add("wood-shifted");
        tabContent.setSpacing(20);
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
        start.setOnAction(this.createStartButtonListener());

        final Pane clockView = new Pane();
        this.teaTimer = new TeaTimer(clockView);

        tabContent.getChildren().add(timeInputPane);
        tabContent.getChildren().add(clockView);
    }

    private EventHandler<ActionEvent> createStartButtonListener() {
        return new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent event) {
                int minutes = 0;
                try {
                    minutes = Integer.valueOf(PanelView.this.minutes.getText());
                } catch (final Exception exc) {
                    //silently
                }
                int seconds = 0;
                try {
                    seconds = Integer.valueOf(PanelView.this.seconds.getText());
                } catch (final Exception exc) {
                    //silently
                }
                final int totalSeconds = (minutes * 60) + seconds;
                PanelView.this.teaTimer.start(totalSeconds);
            }
        };
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
            this.addSound(pane, sound);
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
