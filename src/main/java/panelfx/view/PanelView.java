package panelfx.view;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;

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
import panelfx.PanelFX;
import panelfx.SimpleAccessDecisionManager;
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
    private Tab movieTab1;
    private Tab movieTab2;
    private Tab newbiesTab;
    private Tab timerTab;
    private Tab soundtrackTab;
    private Tab fantasyTab;
    private TeaTimer teaTimer;
    private TextField minutes;
    private TextField seconds;

    private SimpleAccessDecisionManager accessDecisionManager = new SimpleAccessDecisionManager();

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
        createMovieTab1();
        createMovieTab2();
        createClassicsTab();
        createSoundsTab();
        createSoundtrackTab();
        createFantasyTab();
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
                Sound.ERBAERMLICH, Sound.NEIN_ULTZ, Sound.HILFE,
                Sound.COOL, Sound.KNARZ, Sound.SORRY);

        tabContent.getChildren().add(paneBastelecke);

        final FlowPane paneFrank = new ButtonGroup("Frank", this.soundButtons,
                Sound.NEIN_FRALLER, Sound.AAAAAAH, Sound.FALSCH,
                Sound.DANKOEOE, Sound.BULLSHIT, Sound.KOTZEN, Sound.HUST,
                Sound.FRANK_MUELLER, Sound.ZUR_LIEFERUNG, Sound.SCHAFSKAESE,
                Sound.STEELE2);

        tabContent.getChildren().add(paneFrank);

        final FlowPane bSides = new ButtonGroup("Misc", this.soundButtons,
                Sound.COFFEE_MAKER_BASTELECKE,
                Sound.COFFEE, Sound.REMOTE, Sound.DELETE, Sound.SNAPHOT,
                Sound.KHAN, Sound.ASSERT, Sound.WIE_GEIL, Sound.LAUGHING_DIYER, Sound.GANZ_KLAR,
                Sound.ALTOBELLI, Sound.TACH, Sound.WAS_DENN, Sound.NJAEH,
                Sound.QUIET);

        tabContent.getChildren().add(bSides);

        final FlowPane paneJoeHanson = new ButtonGroup("Jother",
                this.soundButtons, Sound.BIDDE_QUESTIONING,
                Sound.BIDDE_IN_TROUBLE, Sound.REVERT, Sound.REWE, Sound.EEHM,
                Sound.DOMAIN, Sound.SO_NICHT, Sound.WEISST_DUS,
                Sound.CONVERTER, Sound.LOKAL, Sound.WAS_DU_GLAUBST_JOTHER, Sound.ANNEE_NE);

        tabContent.getChildren().add(paneJoeHanson);
    }

    private void createMovieTab1() {

        this.movieTab1 = new Tab("Filmzitate #1");
        this.movieTab1.setClosable(false);
        this.tabPane.getTabs().add(this.movieTab1);

        final FlowPane tabContent = new FlowPane();
        tabContent.setPadding(new Insets(10, 0, 0, 0));
        tabContent.setVgap(5);
        tabContent.setHgap(5);
        tabContent.getStyleClass().add("wood-shifted");
        this.movieTab1.setContent(tabContent);

        final FlowPane panePulpFiction = new ButtonGroup("Pulp Fiction",
                this.soundButtons, Sound.WAS_JETZT, Sound.EINMAL_WAS,
                Sound.ANSTEHT, Sound.KONZEPT, Sound.ZUR_SEITE, Sound.NEIN_MANN);

        tabContent.getChildren().add(panePulpFiction);

        final FlowPane pokerPane = new ButtonGroup("Poker-Filme",
                this.soundButtons, Sound.NICHT_GESCHOBEN, Sound.LASS_SEIN,
                Sound.DU_BEISST, Sound.RICHTIG_GEPOKERT, Sound.QUEEN_TEN,
                Sound.REAL, Sound.FREAKING_IDIOTS, Sound.SO_SICK,
                Sound.THATS_BAD, Sound.ASS_BESCHWOERUNG, Sound.JUBEL_ELTON, Sound.JETZT_PARTY_ELTON);

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
                Sound.PFEIFENWICHS, Sound.FRAGE, Sound.HUUST, Sound.PAUSE, Sound.MEERRETTICH, Sound.FEHLER_FINDEN);

        tabContent.getChildren().add(revengeOfTheDispossessedPane);

    }

    private void createMovieTab2() {
        this.movieTab2 = new Tab("Filmzitate #2");
        this.movieTab2.setClosable(false);
        this.tabPane.getTabs().add(this.movieTab2);

        final FlowPane tabContent = new FlowPane();
        tabContent.setPadding(new Insets(10, 0, 0, 0));
        tabContent.setVgap(5);
        tabContent.setHgap(5);
        tabContent.getStyleClass().add("wood-shifted");
        this.movieTab2.setContent(tabContent);

        final FlowPane paneBillAndTed = new ButtonGroup("Bill & Ted",
                this.soundButtons, Sound.VOLLE_KANNE, Sound.GRANATENSTARK,
                Sound.ABSOLUT_UNCOOL, Sound.ABSOLUT_INKOMMENSURABEL);

        tabContent.getChildren().add(paneBillAndTed);

        final FlowPane paneGhostbusters = new ButtonGroup("Ghostbusters",
                this.soundButtons, Sound.STROEME_KREUZEN, Sound.FALLE, Sound.PROTONENUMKEHR, Sound.SICHERHEITSTIP, Sound.PLAN, Sound.TALENT, Sound.SCHLUESSELMEISTER, Sound.ZUUL);

        tabContent.getChildren().add(paneGhostbusters);

        final FlowPane paneNoMercy = new ButtonGroup("Kein Pardon",
                this.soundButtons, Sound.NED_ARBEIDE, Sound.RAUS);

        tabContent.getChildren().add(paneNoMercy);

        final FlowPane paneMadame = new ButtonGroup("Scharfe Kurven für Madame",
                this.soundButtons, Sound.MUSKATNUSS, Sound.HERR_MUELLER);

        tabContent.getChildren().add(paneMadame);
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
                "Cubage Team (2010 - 2012)", this.soundButtons, //
                Sound.SO_NICHT_KEANN, Sound.NICH, Sound.KANTINE,
                Sound.HALT_SCHWIERIG, Sound.IDEFIX_IT,
                Sound.PREFERRED_LANGUAGE, Sound.SLAPSTICK, Sound.RICHTIG,
                Sound.ZU_BLOED, Sound.TRIBBLE, Sound.RED_ALERT,
                Sound.PARDON, Sound.PAS_COMME_CA, Sound.WAS_DU_GLAUBST_MAROHDE,
                Sound.FAHRRADKETTE,
                Sound.BBBB_BENCH, Sound.HORHOR, Sound.SCHROTTKERL);
        tabContent.getChildren().add(cubageTeamSounds);

        final FlowPane basteleckeSounds = new ButtonGroup(
                "Bastelecke Team (2012 - present)", this.soundButtons,
                Sound.BIEKER, Sound.BALLAD, Sound.JEOPARDY);
        tabContent.getChildren().add(basteleckeSounds);

        final FlowPane shrinePanel = new ButtonGroup("The Shrine",
                this.soundButtons, Sound.LAUNE, Sound.GUDE_LAUNE, Sound.SCHLAEGEREI,
                Sound.MESSAGE_LONG, Sound.FEIEREI, Sound.JAJAJAJAJAJA, Sound.FEIERGEMEINDE, Sound.OBERGEIL, Sound.SUPERGEIL, Sound.SUPER, Sound.EINFACH, Sound.KOTZE);
        tabContent.getChildren().add(shrinePanel);

        final FlowPane mediamarktPanel = new ButtonGroup("Mediamarkt",
                this.soundButtons, Sound.ZWEIHUNDERT_PULS, Sound.BILDSCHIRM,
                Sound.SCHEISE);
        tabContent.getChildren().add(mediamarktPanel);

        final FlowPane gescheitertPane = new ButtonGroup("Gescheitert",
                this.soundButtons, Sound.DU_WILLST_WAS, Sound.DATENWUST,
                Sound.FAIL, Sound.FAIL_SATANIC);
        tabContent.getChildren().add(gescheitertPane);
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
                Sound.LACHEN_PEANUTS, Sound.MURMEL_LACHEN, Sound.JABBA_LACHEN);
        tabContent.getChildren().add(laughing);

        final FlowPane comic = new ButtonGroup("Zeichentrick",
                this.soundButtons, Sound.BOING_SINGLE, Sound.BOING,
                Sound.SWOOSH, Sound.SLIDE, Sound.SCHUSS_PEANUTS,
                Sound.BLAH_BLAH, Sound.HIGH_PITCH, Sound.AAH, Sound.HAEMMERN, Sound.OINK, Sound.SAD_TROMBONE, Sound.KLIMPER_MAUS, Sound.SCHNUEFF_MAUS, Sound.TROET_ELEFANT);
        tabContent.getChildren().add(comic);

        final FlowPane tension = new ButtonGroup("Spannung",
                this.soundButtons, Sound.DRAMA_BUTTON, Sound.DRAMATIC, Sound.WWM, Sound.TROMMELWIRBEL);
        tabContent.getChildren().add(tension);

        final FlowPane misc = new ButtonGroup("Sonstiges", this.soundButtons,
                Sound.MIKROWELLE_FERTIG, Sound.LEAF_BLOWER_MAXI_SINGLE, Sound.LEAF_BLOWER_SINGLE_EDIT, Sound.SAMETIME, Sound.DOD,
                Sound.GRAUEN, Sound.BEEP, Sound.FUNKTIONAL_KAPUTT, Sound.GROSSEN_GEIST, Sound.SUPER_INGO, Sound.WHAZZUP);
        tabContent.getChildren().add(misc);


        final FlowPane nature = new ButtonGroup("Natur", this.soundButtons,//
                Sound.COW_MOO,//
                Sound.ANIMAL_HORSE,//
                Sound.ANIMAL_GIBBON,//
                Sound.ANIMAL_BUDGIE_SINGLE,//
                Sound.ANIMAL_BUDGIE_MAXI,//
                Sound.ANIMAL_WOODPECKER_FOREST,//
                Sound.ANIMAL_BLACKBIRD);//
        tabContent.getChildren().add(nature);

    }

    private void createSoundtrackTab() {
        this.soundtrackTab = new Tab("Soundtrack");
        this.soundtrackTab.setClosable(false);
        this.tabPane.getTabs().add(this.soundtrackTab);

        final FlowPane tabContent = new FlowPane();
        tabContent.setPadding(new Insets(10, 0, 0, 0));
        tabContent.setVgap(5);
        tabContent.setHgap(5);
        tabContent.getStyleClass().add("wood-shifted");
        this.soundtrackTab.setContent(tabContent);

        final FlowPane paneFilm = new ButtonGroup("Film",
                this.soundButtons, Sound.FIVE_WEEKS, Sound.LALALALALALA, Sound.LETZTER_TANGO, Sound.ASSAULT);

        tabContent.getChildren().add(paneFilm);

        final FlowPane paneTelevision = new ButtonGroup("Fernsehen",
                this.soundButtons, Sound.BENNY_HILL, Sound.LOST, Sound.MAUS, Sound.PAULCHEN_PANTHER, Sound.WESTERN, Sound.WICKIE);

        tabContent.getChildren().add(paneTelevision);

        final FlowPane paneStandUp = new ButtonGroup("Stand-up",
                this.soundButtons, Sound.STANDUP_METAL, Sound.BUGBUSTERS_THEME);

        tabContent.getChildren().add(paneStandUp);


        final FlowPane companyJingles = new ButtonGroup("Company Jingles",
                this.soundButtons, //
                Sound.COMPANY_LYNCH_FROST_PRODUCTIONS);

        tabContent.getChildren().add(companyJingles);
    }

    private void createFantasyTab() {
        this.fantasyTab = new Tab("Fantasy");
        this.fantasyTab.setClosable(true);
        if (this.accessDecisionManager.hasFantasyNameAcceess()) {

            this.tabPane.getTabs().add(this.fantasyTab);

            final FlowPane tabContent = new FlowPane();
            tabContent.setPadding(new Insets(10, 0, 0, 0));
            tabContent.setVgap(5);
            tabContent.setHgap(5);
            tabContent.getStyleClass().add("wood-shifted");
            this.fantasyTab.setContent(tabContent);

            final FlowPane productFraggle = new ButtonGroup("PM & Artichekten & Koord (Call'em)",
                    this.soundButtons, //
                    Sound.FANTASY_CALL_TOSCH,//
                    Sound.FANTASY_CALL_CALS,//
                    Sound.FANTASY_CALL_DIYER,//
                    Sound.FANTASY_CALL_JOENDER //
            );

            tabContent.getChildren().add(productFraggle);

            final FlowPane paneBugBusters = new ButtonGroup("Bug Busters (Name'em/ Call'em)",
                    this.soundButtons,
                    Sound.FANTASY_NAME_SASCHER,//
                    Sound.FANTASY_CALL_SASCHER, //
                    Sound.FANTASY_NAME_GAIVO, //
                    Sound.FANTASY_CALL_GAIVO,//
                    Sound.FANTASY_NAME_MAUTH,//
                    Sound.FANTASY_CALL_MAUTH,//
                    Sound.FANTASY_NAME_TOTZ,//
                    Sound.FANTASY_CALL_TOTZ);

            tabContent.getChildren().add(paneBugBusters);

            final FlowPane paneDelphinarium = new ButtonGroup("Déjà Vu (Name'em)",
                    this.soundButtons,
                    Sound.FANTASY_NAME_PUETT,//
                    Sound.FANTASY_NAME_SEIER,//
                    Sound.FANTASY_NAME_MALTERS,//
                    Sound.FANTASY_NAME_UDITZ,//
                    Sound.FANTASY_NAME_FRANN,//
                    Sound.FANTASY_CALL_MATTI);

            tabContent.getChildren().add(paneDelphinarium);

            final FlowPane paneBastelecke = new ButtonGroup("Bastelecke (Name'em/ Call'em)",
                    this.soundButtons, //
                    Sound.FANTASY_NAME_FRALLER,//
                    Sound.FANTASY_CALL_FRALLER,//
                    Sound.FANTASY_NAME_ULTZ, //
                    Sound.FANTASY_NAME_JOTHER, //
                    Sound.FANTASY_CALL_JOTHER,//
                    Sound.FANTASY_NAME_JUEDA,//
                    Sound.FANTASY_CALL_JUEDA //
            );

            tabContent.getChildren().add(paneBastelecke);


            final FlowPane paneKatana = new ButtonGroup("Katana (Name'em/ Call'em)",
                    this.soundButtons, //
                    Sound.FANTASY_NAME_ALERG,  //
                    Sound.FANTASY_CALL_ALERG,//
                    Sound.FANTASY_NAME_CHRILLNER, //
                    Sound.FANTASY_CALL_CHRILLNER,//
                    Sound.FANTASY_NAME_BEYER,//
                    Sound.FANTASY_CALL_BEYER //
                );

            tabContent.getChildren().add(paneKatana);


            final FlowPane paneKihon = new ButtonGroup("Kihon (Name'em)",
                    this.soundButtons, Sound.FANTASY_NAME_MARGA, Sound.FANTASY_NAME_TIANN, Sound.FANTASY_NAME_ANANN, Sound.FANTASY_NAME_SESKE, Sound.FANTASY_NAME_MARING);

            tabContent.getChildren().add(paneKihon);


            final FlowPane paneAllIn = new ButtonGroup("All In (Name'em)",
                    this.soundButtons, Sound.FANTASY_NAME_KEANN, Sound.FANTASY_NAME_DAMPS, Sound.FANTASY_NAME_GUIDOLF, Sound.FANTASY_NAME_DANG);

            tabContent.getChildren().add(paneAllIn);
        }

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
