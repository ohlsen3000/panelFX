package panelfx.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
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
    private Tab mediaTab;
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
        createMediaTab();
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

        createButtonGroup(tabContent, "Bastelecke",//
                Sound.STANDUP, //
                Sound.CUBAGE, //
                Sound.BATTLE1, //
                Sound.BATTLE3, //
                Sound.DOORBELL_2ND_FLOOR, //
                Sound.ALARM, //
                Sound.PUSH_IT, //
                Sound.OEOEOEEY, //
                Sound.LAUSCHANGRIFF, //
                Sound.BAEM, //
                Sound.ERBAERMLICH, //
                Sound.NEIN_ULTZ, //
                Sound.HILFE, //
                Sound.COOL, //
                Sound.KNARZ, //
                Sound.SORRY  //
        );

        final FlowPane paneFrank = new ButtonGroup("Fraller", this.soundButtons,
                Sound.NEIN_FRALLER, //
                Sound.AAAAAAH, //
                Sound.FALSCH,//
                Sound.FRALLER_HALLO, //
                Sound.DANKOEOE, //
                Sound.BULLSHIT, //
                Sound.KOTZEN, //
                Sound.HUST, //
                Sound.FRANK_MUELLER, //
                Sound.ZUR_LIEFERUNG,//
                Sound.SCHAFSKAESE,//
                Sound.FRALLER_JA_BESTAETIGUNG,//
                Sound.FRALLER_JA_GENAU,//
                Sound.STEELE2, //
                Sound.FRALLER_BIS_GLEICH, //
                Sound.FRALLER_AUGENBLICK //
        );

        tabContent.getChildren().add(paneFrank);

        createButtonGroup(tabContent, "Misc",//
                Sound.COFFEE_MAKER_BASTELECKE, //
                Sound.COFFEE, //
                Sound.FRALLER_TEE, //
                Sound.REMOTE, //
                Sound.WIE_GEIL, //
                Sound.LAUGHING_DIYER, //
                Sound.ALERG_LACHEN, //
                Sound.ALERG_GROSSARTIG, //
                Sound.GANZ_KLAR, //
                Sound.ALTOBELLI, //
                Sound.FUNKTIONAL_KAPUTT,//
                Sound.GROSSEN_GEIST, //
                Sound.WAS_DENN, //
                Sound.NJAEH, //
                Sound.QUIET,  //
                Sound.DENKE_HUST, //
                Sound.DENKE_KNISTER, //
                Sound.TACH //
        );

        final FlowPane paneJoeHanson = new ButtonGroup("Jother",
                this.soundButtons, Sound.BIDDE_QUESTIONING,
                Sound.BIDDE_IN_TROUBLE, Sound.REVERT, Sound.REWE, Sound.EEHM,
                Sound.DOMAIN, Sound.SO_NICHT, Sound.WEISST_DUS,
                Sound.CONVERTER, Sound.LOKAL, Sound.WAS_DU_GLAUBST_JOTHER, Sound.ANNEE_NE, Sound.ICH_WOISS_NICH);

        tabContent.getChildren().add(paneJoeHanson);
    }

    private void createMovieTab1() {

        this.movieTab1 = new Tab("Film #1");
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
                Sound.REAL, Sound.FREAKING_IDIOTS,//
                Sound.SO_SICK,//
                Sound.POKERBRAT_MISTAKE,//
                Sound.THATS_BAD, //
                Sound.ASS_BESCHWOERUNG, Sound.JUBEL_ELTON, Sound.JETZT_PARTY_ELTON);

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


    }

    private void createMovieTab2() {
        this.movieTab2 = new Tab("Film #2");
        this.movieTab2.setClosable(false);
        this.tabPane.getTabs().add(this.movieTab2);

        final FlowPane tabContent = new FlowPane();
        tabContent.setPadding(new Insets(10, 0, 0, 0));
        tabContent.setVgap(5);
        tabContent.setHgap(5);
        tabContent.getStyleClass().add("wood-shifted");
        this.movieTab2.setContent(tabContent);

        final FlowPane revengeOfTheDispossessedPane = new ButtonGroup(
                "Didi und die Rache der Enterbten", this.soundButtons,
                Sound.WEITERMACHEN, Sound.RUEDIGER, Sound.OMINOES,
                Sound.KEINE_TRICKS, Sound.VERSAGER, Sound.MUELLTONNE,
                Sound.PFEIFENWICHS, Sound.FRAGE, Sound.HUUST, Sound.PAUSE, Sound.MEERRETTICH, Sound.FEHLER_FINDEN);

        tabContent.getChildren().add(revengeOfTheDispossessedPane);


        final FlowPane paneBillAndTed = new ButtonGroup("Bill & Ted",
                this.soundButtons, Sound.VOLLE_KANNE, Sound.GRANATENSTARK,
                Sound.ABSOLUT_UNCOOL, Sound.ABSOLUT_INKOMMENSURABEL);

        tabContent.getChildren().add(paneBillAndTed);

        final FlowPane paneGhostbusters = new ButtonGroup("Ghostbusters",
                this.soundButtons, Sound.STROEME_KREUZEN, Sound.FALLE, Sound.PROTONENUMKEHR, Sound.SICHERHEITSTIP, Sound.PLAN, Sound.TALENT, Sound.SCHLUESSELMEISTER, Sound.ZUUL);

        tabContent.getChildren().add(paneGhostbusters);
        final FlowPane paneFullMetalJacket = new ButtonGroup("Full Metal Jacket",
                this.soundButtons, Sound.SIR_JAWOHL_SIR, //
                Sound.BULLSHIT_HARTMAN, //
                Sound.JESUS_MARIA, //
                Sound.DAS_REICHT, //
                Sound.NICHT_GELACHT, //
                Sound.VERSTANDEN_HARTMAN, //
                Sound.WER, //
                Sound.WER_ZUM_TEUFEL,//
                Sound.NAME_HARTMAN, //
                Sound.LISTE, //
                Sound.VORMERKEN_HARTMAN, //
                Sound.WAS_ZUM_TEUFEL, //
                Sound.WAS_SAGEN, //
                Sound.WACHBEFEHL_HARTMAN);
        tabContent.getChildren().add(paneFullMetalJacket);

        final FlowPane paneNoMercy = new ButtonGroup("Kein Pardon",
                this.soundButtons, Sound.NED_ARBEIDE, Sound.RAUS);

        tabContent.getChildren().add(paneNoMercy);

        final FlowPane paneMadame = new ButtonGroup("Scharfe Kurven für Madame",
                this.soundButtons, Sound.MUSKATNUSS, Sound.HERR_MUELLER);

        tabContent.getChildren().add(paneMadame);

        final FlowPane paneLost = new ButtonGroup("Lost",
                this.soundButtons,//
                Sound.LOST_SYSTEM_FAILURE);

        tabContent.getChildren().add(paneLost);

    }

    private void createMediaTab() {
        this.mediaTab = new Tab("Medien");
        this.mediaTab.setClosable(false);
        this.tabPane.getTabs().add(this.mediaTab);

        final FlowPane tabContent = new FlowPane();
        tabContent.setPadding(new Insets(10, 0, 0, 0));
        tabContent.setVgap(5);
        tabContent.setHgap(5);
        tabContent.getStyleClass().add("wood-shifted");
        this.mediaTab.setContent(tabContent);

        final FlowPane shrinePanel = new ButtonGroup("The Shrine",
                this.soundButtons, Sound.LAUNE, Sound.GUDE_LAUNE, Sound.SCHLAEGEREI,
                Sound.MESSAGE_LONG, Sound.FEIEREI, Sound.JAJAJAJAJAJA, Sound.FEIERGEMEINDE, Sound.OBERGEIL, Sound.SUPERGEIL, Sound.SUPER, Sound.EINFACH, Sound.KOTZE);
        tabContent.getChildren().add(shrinePanel);

        final FlowPane mediamarktPanel = new ButtonGroup("Mediamarkt",
                this.soundButtons, Sound.ZWEIHUNDERT_PULS, Sound.BILDSCHIRM,
                Sound.SCHEISE);
        tabContent.getChildren().add(mediamarktPanel);

        final FlowPane commercialPanel = new ButtonGroup("Reklame",
                this.soundButtons,//
                Sound.OVOMALTINE,//
                Sound.NESQUICK,//
                Sound.SUPER_INGO,//
                Sound.WHAZZUP);
        tabContent.getChildren().add(commercialPanel);

        final FlowPane realityPanel = new ButtonGroup("Reality-TV",
                this.soundButtons, //
                Sound.HALT_STOP, //
                Sound.JETZT_RED_ICH, //
                Sound.KAFFEE_GETRUNKEN,//
                Sound.SCHNAUZE, //
                Sound.NACKTBADEN, //
                Sound.BOAH_GEIL, //
                Sound.UNNORMAL, //
                Sound.ARBEIT,//
                Sound.KEINE_LUST,//
                Sound.JETZT_REICHTS,//
                Sound.NICHTSKOENNER,//
                Sound.BANDMASS//
                );
        tabContent.getChildren().add(realityPanel);

        createButtonGroup(tabContent, "Sport",//
                Sound.FREUNDE_DER_SONNE,//
                Sound.RUDI_SO_EINEN_SCHEISS, //
                Sound.RUDI_DAS_ALLERLETZTE);

        final FlowPane comedyPanel = new ButtonGroup("Comedy",
                this.soundButtons,
                Sound.COMPUTER_SAGT_NEIN,//
                Sound.GEWITTER, //
                Sound.NIX_VERSTEHEN,//
                Sound.NEUSS,//
                Sound.GEWITTER_FRAGE, //
                Sound.SEIHRING_IRRE,//
                Sound.SEIHRING_ULTRAFLACH,//
                Sound.SEIHRING_ABO,//
                Sound.SEIHRING_WIE_GEIL, //
                Sound.DENNIS_DUEP
        );
        tabContent.getChildren().add(comedyPanel);

        final FlowPane emtPanel = new ButtonGroup("Epic Mealtime",
                this.soundButtons,//
                Sound.EMT_MEOW,//
                Sound.EMT_BACON,//
                Sound.EMT_BLAST);
        tabContent.getChildren().add(emtPanel);

    }

    private void createClassicsTab() {

        this.newbiesTab = new Tab("TC Klassiker");
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
                Sound.PARDON, Sound.PAS_COMME_CA,
                Sound.KHAN, //
                Sound.WAS_DU_GLAUBST_MAROHDE,
                Sound.FAHRRADKETTE,
                Sound.BBBB_BENCH, //
                Sound.HORHOR, //
                Sound.SCHROTTKERL,//
                Sound.ASSERT //
        );
        tabContent.getChildren().add(cubageTeamSounds);

        createButtonGroup(tabContent, "Bastelecke Team (2012 - present)",
                Sound.BIEKER,//
                Sound.BALLAD,//
                Sound.JEOPARDY,//
                Sound.DOORBELL //
        );


        final FlowPane katanaSounds = new ButtonGroup(
                "Katana Team (2012 - present)", this.soundButtons,//
                Sound.BEYER_ICH_SO,//
                Sound.BEYER_DU_SO,//
                Sound.BEYER_ER_SO,//
                Sound.BEYER_SIE_SO,//
                Sound.BEYER_WIR_SO,//
                Sound.BEYER_IHR_SO,//
                Sound.BEYER_SCHMECKT, //
                Sound.BEYER_PIROLETA);
        tabContent.getChildren().add(katanaSounds);

        createButtonGroup(tabContent, "Gescheitert", //
                Sound.DELETE, //
                Sound.SNAPHOT, //
                Sound.DATENWUST,//
                Sound.MUTIGE_ENTSCHEIDUNG,//
                Sound.FAIL, //
                Sound.FAIL_SATANIC, //
                Sound.DU_WILLST_WAS,//
                Sound.CALS_ANFORDERUNG,//
                Sound.DATHER_DAS_IST_RICHTIG, //
                Sound.GUTIS_AHH,//
                Sound.GUTIS_JA,//
                Sound.GUTIS_DATENMODELL,//
                Sound.GUTIS_DEMENTSPRECHEND,//
                Sound.GUTIS_KLAR_GESAGT,//
                Sound.GUTIS_WASUACHIMMER,//
                Sound.GUTIS_JETZT_BLEIBT,//
                Sound.GUTIS_SCHOENABEND,//
                Sound.GUTIS_DATENBANK,//
                Sound.GUTIS_FEHLER,//
                Sound.GUTIS_BETA,//
                Sound.GUTIS_NICHTNURMIR,//
                Sound.GUTIS_SUBOPTIMAL,//
                Sound.GUTIS_IDE);
    }

    private void createSoundsTab() {

        this.newbiesTab = new Tab("Geräusche");
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
                Sound.LACHEN_PEANUTS,
                Sound.MURMEL_LACHEN, //
                Sound.JABBA_LACHEN, //
                Sound.BEYER_LACHEN //
        );
        tabContent.getChildren().add(laughing);

        final FlowPane comic = new ButtonGroup("Zeichentrick",
                this.soundButtons, Sound.BOING_SINGLE, Sound.BOING,
                Sound.SWOOSH, Sound.SLIDE, Sound.SCHUSS_PEANUTS,
                Sound.BLAH_BLAH, Sound.HIGH_PITCH, Sound.AAH, Sound.HAEMMERN, Sound.OINK, Sound.SAD_TROMBONE, Sound.KLIMPER_MAUS, Sound.SCHNUEFF_MAUS, Sound.TROET_ELEFANT);
        tabContent.getChildren().add(comic);

        final FlowPane tension = new ButtonGroup("Spannung",
                this.soundButtons, Sound.DRAMA_BUTTON, Sound.DRAMATIC, Sound.BLUTORGEL, Sound.WWM, Sound.TROMMELWIRBEL);
        tabContent.getChildren().add(tension);

        final FlowPane misc = new ButtonGroup("Sonstiges", this.soundButtons,
                Sound.MIKROWELLE_FERTIG, //
                Sound.LEAF_BLOWER_MAXI_SINGLE, //
                Sound.LEAF_BLOWER_SINGLE_EDIT, //
                Sound.SAMETIME,//
                Sound.TIMES_UP, //
                Sound.DOD,//
                Sound.KIHON_SPIEL_GOLF, //
                Sound.GRAUEN,//
                Sound.BEEP,//
                Sound.HUST_SCOTCH, //
                Sound.KITT);
        tabContent.getChildren().add(misc);


        final FlowPane nature = new ButtonGroup("Natur", this.soundButtons,//
                Sound.COW_MOO,//
                Sound.ANIMAL_HORSE,//
                Sound.ANIMAL_GIBBON,//
                Sound.ANIMAL_MONKEY,//
                Sound.ANIMAL_BUDGIE_SINGLE,//
                Sound.ANIMAL_BUDGIE_MAXI,//
                Sound.ANIMAL_WOODPECKER_FOREST,//
                Sound.ANIMAL_BLACKBIRD,//
                Sound.ANIMAL_MAGPIE,
                Sound.ANIMAL_DYING_DUCK);//

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


        createButtonGroup(tabContent, "Film",
                Sound.FIVE_WEEKS, //
                Sound.VERTIGO, //
                Sound.ASSAULT, //
                Sound.LALALALALALA,  //
                Sound.FOG, //
                Sound.LETZTER_TANGO, //
                Sound.HALLOWEEN, //
                Sound.EXORCIST  //
        );

        final FlowPane paneTelevision = new ButtonGroup("Fernsehen",
                this.soundButtons,//
                Sound.BENNY_HILL,//
                Sound.LOST,//
                Sound.MAUS, //
                Sound.PAULCHEN_PANTHER,//
                Sound.WESTERN, //
                Sound.WICKIE, //
                Sound.JOLODA_SCHIENEN);

        tabContent.getChildren().add(paneTelevision);


        final FlowPane c64Pane = new ButtonGroup("Computer-Spiele",
                this.soundButtons,//
                Sound.C64_ELITE,//
                Sound.C64_UPNDOWN_INTRO,//
                Sound.C64_UPNDOWN_GAMING,//
                Sound.C64_UPNDOWN_GAMEOVER,//
                Sound.C64_UPNDOWN_HISCORES, //
                Sound.C64_SUMMER_GAMES_HISCORES //
                );

        tabContent.getChildren().add(c64Pane);


        final FlowPane paneStandUp = new ButtonGroup("Stand-up",
                this.soundButtons, Sound.STANDUP_METAL, Sound.BUGBUSTERS_THEME, Sound.ROTES_PFERD);

        tabContent.getChildren().add(paneStandUp);


        createButtonGroup(tabContent, "Company Jingles",
                Sound.COMPANY_LYNCH_FROST_PRODUCTIONS,
                Sound.LOST_BAD_ROBOT);


        createButtonGroup(tabContent, "Musikschnippsel kurz",
                Sound.JEDU_V_MAGADAN, //
                Sound.MAGADAN_REFRAIN,//
                Sound.PENN_IN_DER_BAHN, //
                Sound.CHIMO_BAYO_ASI_ME_GUSTA, //
                Sound.MUSE_UNSUSTAINABLE, //
                Sound.GUILD_OF_AGES_INTO_THE_NIGHT_RIFF //
                );

        createButtonGroup(tabContent, "Musikschnippsel lang",
                Sound.PIRATAS_CON_EVA //
        );


    }

    private void createFantasyTab() {
        this.fantasyTab = new Tab("Fantasy");
        this.fantasyTab.setClosable(true);
        if (this.accessDecisionManager.hasFantasyNameAcceess()) {

            this.tabPane.getTabs().add(this.fantasyTab);

            final FlowPane tabContent = new FlowPane();
            tabContent.setVgap(5);
            tabContent.setHgap(5);
            tabContent.getStyleClass().add("wood-shifted");
            this.fantasyTab.setContent(tabContent);

            final Accordion accordion = new Accordion ();

            FlowPane firstFloorContent = new FlowPane();
            firstFloorContent.getStyleClass().add("wood-shifted");
            TitledPane firstFloor = new TitledPane("1. Etage", firstFloorContent);
            accordion.getPanes().add(firstFloor);

            tabContent.getChildren().add(accordion);

            createButtonGroup(firstFloorContent, "Bug Busters (Name'em/ Call'em)",
                    Sound.FANTASY_NAME_SASCHER,//
                    Sound.FANTASY_CALL_SASCHER, //
                    Sound.FANTASY_NAME_GAIVO, //
                    Sound.FANTASY_CALL_GAIVO,//
                    Sound.FANTASY_NAME_MAUTH,//
                    Sound.FANTASY_CALL_MAUTH,//
                    Sound.FANTASY_NAME_TOTZ,//
                    Sound.FANTASY_CALL_TOTZ //
            );

            createButtonGroup(firstFloorContent, "Déjà Vu (Name'em)",
                    Sound.FANTASY_NAME_PUETT,//
                    Sound.FANTASY_CALL_PUETT, //
                    Sound.FANTASY_NAME_SEIER,//
                    Sound.FANTASY_CALL_SEIER, //
                    Sound.FANTASY_NAME_MALTERS,//
                    Sound.FANTASY_CALL_MALTERS, //
                    Sound.FANTASY_NAME_UDITZ,//
                    Sound.FANTASY_NAME_FRANN,//
                    Sound.FANTASY_NAME_MATTI //
            );

            createButtonGroup(firstFloorContent, "Katana (Name'em/ Call'em)",
                    Sound.FANTASY_NAME_ALERG,  //
                    Sound.FANTASY_CALL_ALERG,//
                    Sound.FANTASY_NAME_CHRILLNER, //
                    Sound.FANTASY_CALL_CHRILLNER,//
                    Sound.FANTASY_NAME_BEYER,//
                    Sound.FANTASY_CALL_BEYER //
            );

            createButtonGroup(firstFloorContent, "Kihon (Name'em)",
                    Sound.FANTASY_NAME_MARGA, //
                    Sound.FANTASY_NAME_TIANN, //
                    Sound.FANTASY_NAME_ANANN, //
                    Sound.FANTASY_NAME_SESKE, //
                    Sound.FANTASY_CALL_SESKE, //
                    Sound.FANTASY_NAME_MARING //
            );

            createButtonGroup(firstFloorContent, "UX", //
                    Sound.FANTASY_NAME_ALEIP, //
                    Sound.FANTASY_CALL_ALEIP,//
                    Sound.FANTASY_NAME_DAGENS, //
                    Sound.FANTASY_CALL_DAGENS,//
                    Sound.FANTASY_NAME_JUANN, //
                    Sound.FANTASY_NAME_SANDER //
            );
            createButtonGroup(firstFloorContent, "TCO (Name'em)", //
                    Sound.FANTASY_NAME_DATHER, //
                    Sound.FANTASY_CALL_DATHER, //
                    Sound.FANTASY_NAME_SVANN, //
                    Sound.FANTASY_NAME_ACHOMM, //
                    Sound.FANTASY_NAME_MARRES //
            );

            FlowPane secondFloorContent = new FlowPane();
            secondFloorContent.getStyleClass().add("wood-shifted");
            TitledPane secondFloor = new TitledPane("2. Etage", secondFloorContent);
            accordion.getPanes().add(secondFloor);

            createButtonGroup(secondFloorContent, "Bastelecke (Name'em/ Call'em)", //
                    Sound.FANTASY_NAME_FRALLER,//
                    Sound.FANTASY_CALL_FRALLER,//
                    Sound.FANTASY_NAME_ULTZ, //
                    Sound.FANTASY_CALL_ULTZ, //
                    Sound.FANTASY_NAME_JOTHER, //
                    Sound.FANTASY_CALL_JOTHER,//
                    Sound.FANTASY_NAME_JUEDA,//
                    Sound.FANTASY_CALL_JUEDA, //
                    Sound.FANTASY_NAME_DENKE, //
                    Sound.FANTASY_CALL_DENKE//
            );

            createButtonGroup(secondFloorContent, "BIT", //
                    Sound.FANTASY_NAME_TORKE,//
                    Sound.FANTASY_NAME_PATANN, //
                    Sound.FANTASY_CALL_PATANN//
            );
            createButtonGroup(secondFloorContent, "DBA", //
                    Sound.FANTASY_NAME_ERANN,//
                    Sound.FANTASY_NAME_MAHANN //
            );

            createButtonGroup(secondFloorContent, "All In (Name'em)", //
                    Sound.FANTASY_NAME_KEANN, //
                    Sound.FANTASY_CALL_KEANN, //
                    Sound.FANTASY_NAME_DAMPS,  //
                    Sound.FANTASY_NAME_GUIDOLF, //
                    Sound.FANTASY_CALL_GUIDOLF,//
                    Sound.FANTASY_NAME_DANG, //
                    Sound.FANTASY_NAME_MICHNY, //
                    Sound.FANTASY_CALL_MICHNY //
            );
            createButtonGroup(secondFloorContent, "Quastan (Name'em)", //
                    Sound.FANTASY_NAME_CHRIKA, //
                    Sound.FANTASY_NAME_DIGER //
            );
            createButtonGroup(secondFloorContent, "Solitarios", //
                    Sound.FANTASY_NAME_MARTES //
            );
            createButtonGroup(secondFloorContent, "Artichekten & Koord", //
                    Sound.FANTASY_NAME_TOSCH,//
                    Sound.FANTASY_CALL_TOSCH,//
                    Sound.FANTASY_NAME_CALS,//
                    Sound.FANTASY_CALL_CALS,//
                    Sound.FANTASY_NAME_DIYER,//
                    Sound.FANTASY_CALL_DIYER,//
                    Sound.FANTASY_NAME_JOENDER,//
                    Sound.FANTASY_CALL_JOENDER //
            );
            createButtonGroup(secondFloorContent, "PMs", //
                    Sound.FANTASY_NAME_TOSCH,//
                    Sound.FANTASY_CALL_TOSCH,//
                    Sound.FANTASY_NAME_THOCKER, //
                    Sound.FANTASY_NAME_CHRIANN,//
                    Sound.FANTASY_CALL_CHRIANN,//
                    Sound.FANTASY_NAME_RALERR//
            );

            FlowPane thirdFloorContent = new FlowPane();
            thirdFloorContent.getStyleClass().add("wood-shifted");
            TitledPane thirdFloor = new TitledPane("Diverse", thirdFloorContent);
            accordion.getPanes().add(thirdFloor);

            createButtonGroup(thirdFloorContent, "Hades (Name\'em)", //
                    Sound.FANTASY_NAME_DAMME,//
                    Sound.FANTASY_NAME_MAROHDE,//
                    Sound.FANTASY_NAME_GUTIS, //
                    Sound.FANTASY_NAME_CHRISCHKA, //
                    Sound.FANTASY_NAME_DADIN //
            );

            createButtonGroup(thirdFloorContent, "Die Anderen", //
                    Sound.FANTASY_NAME_CHRILEN,//
                    Sound.FANTASY_NAME_SVENGEL //
            );
        }

    }


    private void createButtonGroup(FlowPane parentTabContent, String text, Sound... sounds) {

        List<Sound> authorisedSounds = new ArrayList<>();
        for (Sound sound : sounds) {

            if (!sound.isCritical() || this.accessDecisionManager.hasCriticalSoundAcceess()) {
                authorisedSounds.add(sound);
            }
        }

        if (!authorisedSounds.isEmpty()) {
            final FlowPane buttonGroupPane = new ButtonGroup(text,
                    this.soundButtons,
                    authorisedSounds.toArray(new Sound[]{}));
            parentTabContent.getChildren().add(buttonGroupPane);
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
