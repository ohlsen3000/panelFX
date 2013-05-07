/*
 * DigitalClockView.java
 * Created on 17. September 2005, 02:12
 */

package panelfx.timer.views;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import panelfx.timer.ClockView;

/**
 * View for a clock. looking "digital"
 *
 * @author ohlsen
 */
public class AnalogClockView extends Pane implements ClockView {

    int x = 100;
    int y = 80;
    int radius = 80;

    private int secondsTotal = 0;
    private int secondsLeft = 0;

    /** Creates new form DigitalClockView */
    public AnalogClockView() {
    }

    @Override
    public void tick(final int secsLeft) {

        this.secondsLeft = secsLeft;

        final double angle = -(360.0 / this.secondsTotal) * (this.secondsTotal - this.secondsLeft);

        getChildren().clear();

        Circle border = new Circle(x,y,radius);
        border.setFill(null);
        border.setStroke(Paint.valueOf(javafx.scene.paint.Color.BEIGE.toString()));
        border.setStrokeWidth(3);
        getChildren().add(border);

        Arc arc = new Arc();
        arc.setFill(javafx.scene.paint.Color.BEIGE);
        arc.setCenterX(x);
        arc.setCenterY(y);
        arc.setRadiusX(radius);
        arc.setRadiusY(radius);
        arc.setStartAngle(-270);
        arc.setLength(angle);
        arc.setType(ArcType.ROUND);

        getChildren().add(arc);
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
