/*
 * ClockModel.java
 * Created on 17. September 2005, 03:03
 */

package panelfx.timer;

/**
 * Represents a model for a running clock
 * 
 * @author ohlsen
 */
public class ClockModel {

    private int totalSeconds = 0;
    private int secondsLeft = 0;

    /** Creates a new instance of ClockModel */
    public ClockModel(final int totalSeconds) {
        this.totalSeconds = totalSeconds;
        this.secondsLeft = totalSeconds;
    }

    public int getTotalSeconds() {
        return this.totalSeconds;
    }

    public void setTotalSeconds(final int totalSeconds) {
        this.totalSeconds = totalSeconds;
    }

    public int getSecondsLeft() {
        return this.secondsLeft;
    }

    public void setSecondsLeft(final int secondsLeft) {
        this.secondsLeft = secondsLeft;
    }

}
