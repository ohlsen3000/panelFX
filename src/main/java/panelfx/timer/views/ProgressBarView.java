/*
 * DigitalClockView.java
 * Created on 17. September 2005, 02:12
 */

package panelfx.timer.views;

import java.awt.Color;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import panelfx.timer.ClockView;
import panelfx.view.PanelView;

/**
 * View for a clock. looking "digital"
 *
 * @author ohlsen
 */
public class ProgressBarView extends Pane implements ClockView {

    private static final int WIDTH = PanelView.WIDTH - 100;

    private int secondsTotal = 0;
    private int secondsLeft = 0;

    /** Creates new form DigitalClockView */
    public ProgressBarView() {
    }

    @Override
    public void tick(final int secsLeft) {

        this.secondsLeft = secsLeft;

        final double progressD = (WIDTH/ this.secondsTotal) * (this.secondsTotal - this.secondsLeft);

        getChildren().clear();

        Rectangle border = new Rectangle(WIDTH, 30);
        border.setArcHeight(10);
        border.setArcWidth(10);
        border.setFill(null);
        border.setStroke(Paint.valueOf(javafx.scene.paint.Color.BEIGE.toString()));
        border.setStrokeWidth(3);
        getChildren().add(border);


        Rectangle fill = new Rectangle(progressD, 30, Paint.valueOf(javafx.scene.paint.Color.BEIGE.toString()));
        fill.setArcHeight(10);
        fill.setArcWidth(10);
        getChildren().add(fill);

    }

    protected Text createLabel(String content) {
        final Text text = new Text(0, 100, content);
        text.setFill(javafx.scene.paint.Color.BEIGE);
        text.setFont(new javafx.scene.text.Font(80));
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
