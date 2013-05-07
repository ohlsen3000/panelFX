package panelfx.view;

import java.util.Map;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import panelfx.sound.Sound;

public class ButtonGroup extends FlowPane {

    public enum Width {

        ONE(1), HALF(0.495), QUARTER(0.245);

        private double factor;

        Width(final double factor) {
            this.factor = factor;
        }

        public double getFactor() {
            return this.factor;
        }

    }

    public ButtonGroup(final String groupName, final Map<Sound, Button> allSoundButtons, final Sound... sounds) {

        super();

        this.getChildren().add(this.createLabel(groupName));

        double withFactor = Width.ONE.factor;
        if (sounds.length <= 2) {
            withFactor = Width.HALF.factor;
        }
        final double exactWidth = Math.floor((PanelView.WIDTH - (2 * PanelView.PADDING_LEFT_RIGHT)) * withFactor);

        this.setMinWidth(exactWidth);
        this.setMaxWidth(exactWidth);

        final FlowPane buttons = new FlowPane();
        buttons.setPadding(new Insets(5, 5, 5, 5));
        buttons.setVgap(5);
        buttons.setHgap(5);
        buttons.setMinWidth(exactWidth);
        buttons.setMaxWidth(exactWidth);
        buttons.getStyleClass().add("button-group");

        for (final Sound sound : sounds) {
            buttons.getChildren().add(allSoundButtons.get(sound));
        }

        this.getChildren().add(buttons);
    }

    private Label createLabel(final String caption) {
        final Label label = new Label(caption);
        label.setTextFill(Color.web("#EEEEEE"));
        return label;
    }

}
