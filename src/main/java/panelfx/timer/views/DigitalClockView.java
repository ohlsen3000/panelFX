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

        this.setSecondsLeft(secsLeft);

        final int minutes = this.getSecondsLeft() / 60;
        final int seconds = this.getSecondsLeft() % 60;

        final Text text = new Text();
        text.setFill(Color.BEIGE);
        text.setFont(new Font(40));
        text.setText(minutes + ":" + this.secFormat.format(seconds));

        this.getChildren().clear();
        this.getChildren().add(text);
    }

    @Override
    public void setTotalTime(final int seconds) {

        this.setSecondsTotal(seconds);
        this.setSecondsLeft(seconds);
    }

    public int getSecondsTotal() {
        return this.secondsTotal;
    }

    public void setSecondsTotal(final int secondsTotal) {
        this.secondsTotal = secondsTotal;
    }

    public int getSecondsLeft() {
        return this.secondsLeft;
    }

    public void setSecondsLeft(final int secondsLeft) {
        this.secondsLeft = secondsLeft;
    }

}
