package panelfx.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import panelfx.sound.PlayingSounds;
import panelfx.sound.Sound;
import panelfx.sound.SoundThread;

public class PanelController {

    private final PanelView panelView;

    private PlayingSounds runningSounds = new PlayingSounds();

    private final Stage primaryStage;

    public PanelController(final Stage primaryStage, final PlayingSounds playingSounds) {
        super();
        this.primaryStage = primaryStage;
        this.runningSounds = playingSounds;
        this.panelView = new PanelView();

        this.panelView.build();
        this.panelView.registerSoundButtonActionListener(this.createButtonListener());

        this.panelView.registerControlActionListener(this.createControlButtonListener());
    }

    public void show() {
        this.panelView.show(this.primaryStage);
    }

    public EventHandler<ActionEvent> createButtonListener() {
        return new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent event) {
                final String actionSource = ((Button) event.getSource()).getId();

                final String url = Sound.class.getResource(actionSource + ".mp3").toString();
                final SoundThread sound = new SoundThread(url, PanelController.this.runningSounds);
                sound.run();
            }
        };
    }

    public EventHandler<MouseEvent> createControlButtonListener() {
        return new EventHandler<MouseEvent>() {

            @Override
            public void handle(final MouseEvent event) {
                final String actionSource = ((ImageView) event.getSource()).getId();

                if ("STOP".equals(actionSource)) {
                    PanelController.this.runningSounds.stopAll();
                }
            }
        };
    }

}
