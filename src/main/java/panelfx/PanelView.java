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

	public void registerSoundButtonActionListener(final EventHandler<ActionEvent> pushButtonEvent){

		for (final Button button : this.soundButtons.values()){
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

	private void createButtons(){

		for (final Sound sound : Sound.values()){
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

		addSound(panePulpFiction, Sound.WAS_JETZT);
		addSound(panePulpFiction, Sound.EINMAL_WAS);
		addSound(panePulpFiction, Sound.ANSTEHT);
		addSound(panePulpFiction, Sound.KONZEPT);
		addSound(panePulpFiction, Sound.ZUR_SEITE);
		addSound(panePulpFiction, Sound.NEIN_MANN);

		masterPane.getChildren().add(createLabel("Pulp Fiction"));
		masterPane.getChildren().add(panePulpFiction);

		final FlowPane paneBastelecke = this.createFlowPane();

		addSound(paneBastelecke, Sound.STANDUP);
		addSound(paneBastelecke, Sound.CUBAGE);
		addSound(paneBastelecke, Sound.BATTLE1);
		addSound(paneBastelecke, Sound.BATTLE3);
		addSound(paneBastelecke, Sound.DOORBELL);
		addSound(paneBastelecke, Sound.ALARM);
		addSound(paneBastelecke, Sound.PUSH_IT);
		addSound(paneBastelecke, Sound.OEOEOEEY);
		addSound(paneBastelecke, Sound.LAUSCHANGRIFF);
		addSound(paneBastelecke, Sound.FOG);
		addSound(paneBastelecke, Sound.BAEM);
		addSound(paneBastelecke, Sound.ERBAERMLICH);
		addSound(paneBastelecke, Sound.HORHOR);
		addSound(paneBastelecke, Sound.NEIN_ULTZ);
		addSound(paneBastelecke, Sound.HILFE);
		addSound(paneBastelecke, Sound.COOL);
		addSound(paneBastelecke, Sound.KNARZ);
		addSound(paneBastelecke, Sound.SORRY);

		masterPane.getChildren().add(createLabel("Bastelecke"));
		masterPane.getChildren().add(paneBastelecke);

		final FlowPane paneFrank = this.createFlowPane();

		addSound(paneFrank, Sound.NEIN_FRALLER);
		addSound(paneFrank, Sound.AAAAAAH);
		addSound(paneFrank, Sound.FALSCH);
		addSound(paneFrank, Sound.DANKOEOE);
		addSound(paneFrank, Sound.BULLSHIT);
		addSound(paneFrank, Sound.KOTZEN);
		addSound(paneFrank, Sound.HUST);
		addSound(paneFrank, Sound.FRANK_MUELLER);
		addSound(paneFrank, Sound.ZUR_LIEFERUNG);
		addSound(paneFrank, Sound.SCHAFSKAESE);
		addSound(paneFrank, Sound.STEELE2);

		masterPane.getChildren().add(createLabel("Frank"));
		masterPane.getChildren().add(paneFrank);

		final FlowPane paneMisc = this.createFlowPane();

		addSound(paneMisc, Sound.BIEKER);
		addSound(paneMisc, Sound.BALLAD);
		addSound(paneMisc, Sound.JEOPARDY);
		addSound(paneMisc, Sound.REMOTE);
		addSound(paneMisc, Sound.DELETE);
		addSound(paneMisc, Sound.SNAPHOT);
		addSound(paneMisc, Sound.KHAN);
		addSound(paneMisc, Sound.ASSERT);
		addSound(paneMisc, Sound.WIE_GEIL);
		addSound(paneMisc, Sound.FAIL);
		addSound(paneMisc, Sound.FAIL_SATANIC);
		addSound(paneMisc, Sound.LAUGHING_DIYER);
		addSound(paneMisc, Sound.GANZ_KLAR);
		addSound(paneMisc, Sound.ALTOBELLI);
		addSound(paneMisc, Sound.TACH);
		addSound(paneMisc, Sound.LOKAL);
		addSound(paneMisc, Sound.WAS_DENN);

		masterPane.getChildren().add(createLabel("Misc"));
		masterPane.getChildren().add(paneMisc);

		final FlowPane paneJoeHanson = this.createFlowPane();

		addSound(paneJoeHanson, Sound.BIDDE_QUESTIONING);
		addSound(paneJoeHanson, Sound.BIDDE_IN_TROUBLE);
		addSound(paneJoeHanson, Sound.REVERT);
		addSound(paneJoeHanson, Sound.REWE);
		addSound(paneJoeHanson, Sound.WAS_DU_GLAUBST);
		addSound(paneJoeHanson, Sound.EEHM);
		addSound(paneJoeHanson, Sound.DOMAIN);
		addSound(paneJoeHanson, Sound.SO_NICHT);
		addSound(paneJoeHanson, Sound.WEISST_DUS);
		addSound(paneJoeHanson, Sound.CONVERTER);
		addSound(paneJoeHanson, Sound.COFFEE);
		addSound(paneJoeHanson, Sound.ANNEE_NE);

		masterPane.getChildren().add(createLabel("Joe Hanson"));
		masterPane.getChildren().add(paneJoeHanson);

		//		this.scene = new Scene(masterPane, 750, 520);
		this.scene = new Scene(masterPane);
	}
	private void addSound(final FlowPane flowPane, final Sound sound){
		flowPane.getChildren().add(this.soundButtons.get(sound));
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

}
