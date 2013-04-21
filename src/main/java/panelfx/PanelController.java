package panelfx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
@Named("soundPanelController")
public class PanelController {

	private final PanelView panelView;

	@Inject
	private PlayingSounds runningSounds;

	@Inject
	Event<Sound> soundEvent;

	public PanelController() {
		super();
		this.panelView = new PanelView();

		this.panelView.build();
		this.panelView
				.registerSoundButtonActionListener(createButtonListener());

		this.panelView
				.registerControlActionListener(createControlButtonListener());
	}

	public void show(@Observes @StartupScene final Stage primaryStage) {
		this.panelView.show(primaryStage);
	}

	private EventHandler<ActionEvent> createButtonListener() {
		return new EventHandler<ActionEvent>() {

			@Override
			public void handle(final ActionEvent event) {
				final String actionSource = ((Button) event.getSource())
						.getId();

				final Sound sound = Sound.lookUpByLabel(actionSource);

				if (sound != null) {
					PanelController.this.soundEvent.fire(sound);
				}
			}
		};
	}

	private EventHandler<MouseEvent> createControlButtonListener() {
		return new EventHandler<MouseEvent>() {

			@Override
			public void handle(final MouseEvent event) {
				final String actionSource = ((ImageView) event.getSource())
						.getId();

				if ("STOP".equals(actionSource)) {
					PanelController.this.runningSounds.stopAll();
				}
			}
		};
	}

}
