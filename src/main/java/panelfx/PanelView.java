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
		masterPane.setPadding(new Insets(5, 20, 5, 20));
		masterPane.setVgap(5);
		masterPane.setHgap(5);
		final String image = PanelFX.class.getResource("wood.jpg")
				.toExternalForm();
		masterPane.setStyle("-fx-background-image: url('" + image + "')");

		final FlowPane controllingPane = this.createFlowPane(false);
		final Image muteImage = new Image(getClass().getResourceAsStream(
				"mute.png"));
		this.muteView = new ImageView(muteImage);
		this.muteView.setId("STOP");
		this.muteView.setCursor(Cursor.HAND);
		controllingPane.getChildren().add(this.muteView);
		controllingPane.setAlignment(Pos.CENTER_RIGHT);
		masterPane.getChildren().add(controllingPane);

		final FlowPane panePulpFiction = this.createFlowPane(
				//
				Sound.WAS_JETZT, Sound.EINMAL_WAS, Sound.ANSTEHT,
				Sound.KONZEPT, Sound.ZUR_SEITE, Sound.NEIN_MANN);

		masterPane.getChildren().add(createLabel("Pulp Fiction"));
		masterPane.getChildren().add(panePulpFiction);

		final FlowPane paneBastelecke = this.createFlowPane(Sound.STANDUP,
				Sound.CUBAGE, Sound.BATTLE1, Sound.BATTLE3, Sound.DOORBELL,
				Sound.ALARM, Sound.PUSH_IT, Sound.OEOEOEEY,
				Sound.LAUSCHANGRIFF, Sound.FOG, Sound.BAEM, Sound.ERBAERMLICH,
				Sound.HORHOR, Sound.NEIN_ULTZ, Sound.HILFE, Sound.COOL,
				Sound.KNARZ, Sound.SORRY);

		masterPane.getChildren().add(createLabel("Bastelecke"));
		masterPane.getChildren().add(paneBastelecke);

		final FlowPane paneFrank = this.createFlowPane(Sound.NEIN_FRALLER,
				Sound.AAAAAAH, Sound.FALSCH, Sound.DANKOEOE, Sound.BULLSHIT,
				Sound.KOTZEN, Sound.HUST, Sound.FRANK_MUELLER,
				Sound.ZUR_LIEFERUNG, Sound.SCHAFSKAESE, Sound.STEELE2);

		masterPane.getChildren().add(createLabel("Frank"));
		masterPane.getChildren().add(paneFrank);

		final FlowPane paneMisc = this.createFlowPane(Sound.BIEKER,
				Sound.BALLAD, Sound.JEOPARDY, Sound.REMOTE, Sound.DELETE,
				Sound.SNAPHOT, Sound.KHAN, Sound.ASSERT, Sound.WIE_GEIL,
				Sound.FAIL, Sound.FAIL_SATANIC, Sound.LAUGHING_DIYER,
				Sound.GANZ_KLAR, Sound.ALTOBELLI, Sound.TACH, Sound.LOKAL,
				Sound.WAS_DENN);

		masterPane.getChildren().add(createLabel("Misc"));
		masterPane.getChildren().add(paneMisc);

		final FlowPane paneJoeHanson = this.createFlowPane(

				Sound.BIDDE_QUESTIONING, Sound.BIDDE_IN_TROUBLE, Sound.REVERT,
				Sound.REWE, Sound.WAS_DU_GLAUBST, Sound.EEHM, Sound.DOMAIN,
				Sound.SO_NICHT, Sound.WEISST_DUS, Sound.CONVERTER,
				Sound.COFFEE, Sound.ANNEE_NE);

		masterPane.getChildren().add(createLabel("Joe Hanson"));
		masterPane.getChildren().add(paneJoeHanson);

		// this.scene = new Scene(masterPane, 750, 520);
		this.scene = new Scene(masterPane);
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
		final FlowPane pane = createFlowPane(true);

		for (final Sound sound : sounds) {
			addSound(pane, sound);
		}
		return pane;
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
