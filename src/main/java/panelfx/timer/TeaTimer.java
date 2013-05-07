/*
 * TeaTimer.java
 * Created on 17. September 2005, 00:17
 */

package panelfx.timer;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import panelfx.timer.views.DigitalClockView;

/**
 * @author ohlsen
 */
public class TeaTimer implements EventHandler<ActionEvent> {

    private ClockView view = null;
    private Timeline timeline = null;
    private ClockModel clockModel = null;
    private Pane canvas;

    public TeaTimer(final Pane canvas) {
        this.canvas = canvas;
        this.view = new DigitalClockView();
    }

    public void start(final int totalSeconds) {

        if (this.timeline != null) {
            this.timeline.stop();
        }

        this.clockModel = new ClockModel(totalSeconds);
        this.getView().setTotalTime(this.clockModel.getTotalSeconds());
        this.getView().tick(this.clockModel.getSecondsLeft());
        this.canvas.getChildren().clear();
        this.canvas.getChildren().add((Node) this.getView());
        this.createTimeline();
        this.timeline.playFromStart();
    }

    protected void createTimeline() {
        this.timeline = new Timeline();
        this.timeline.setCycleCount(Animation.INDEFINITE);
        this.timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), this));
    }

    @Override
    public void handle(final ActionEvent arg0) {

        this.clockModel.setSecondsLeft(this.clockModel.getSecondsLeft() - 1);
        this.getView().tick(this.clockModel.getSecondsLeft());

        if (this.clockModel.getSecondsLeft() <= 0) {

            this.timeline.stop();

            final String url = TeaTimer.class.getResource("whistle.mp3").toString();
            final Media sound = new Media(url);
            final MediaPlayer player = new MediaPlayer(sound);
            player.play();

            this.canvas.getChildren().clear();
        }

    }

    public ClockView getView() {
        return this.view;
    }

    public void setView(final ClockView view) {
        this.view = view;
        this.canvas.getChildren().clear();
        this.canvas.getChildren().add((Node) this.getView());
    }

}
