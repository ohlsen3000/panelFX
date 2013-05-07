/*
 * DigitalClockView.java
 * Created on 17. September 2005, 02:12
 */

package panelfx.timer.views;

import java.text.NumberFormat;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import panelfx.timer.ClockView;

/**
 * View for a clock. looking "digital"
 *
 * @author ohlsen
 */
public class DigitalClockView extends Pane implements ClockView {

    private int secondsTotal = 0;
    private int secondsLeft = 0;
    private NumberFormat secFormat = NumberFormat.getInstance();

    /** Creates new form DigitalClockView */
    public DigitalClockView() {
        this.secFormat.setMinimumIntegerDigits(2);
    }

    @Override
    public void tick(final int secsLeft) {

        this.secondsLeft = secsLeft;

        final int minutes = secondsLeft / 60;
        final int seconds = secondsLeft % 60;

        String text = minutes + ":" + this.secFormat.format(seconds);

        this.getChildren().clear();
        this.getChildren().add(createLabel(text));
    }

    protected Text createLabel(String content) {
        final Text text = new Text(0, 80, content);
        text.setFill(Color.BEIGE);
        text.setFont(new Font(80));
        return text;
    }

    @Override
    public void setTotalTime(final int seconds) {
        this.secondsTotal = seconds;
    }

    @Override
    public void onFinish() {
        this.getChildren().clear();
        this.getChildren().add(createLabel("Finished."));
    }

}
