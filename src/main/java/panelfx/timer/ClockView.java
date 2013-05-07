/*
 * ClockView.java
 * Created on 17. September 2005, 02:10
 */

package panelfx.timer;

/**
 * @author ohlsen
 */
public interface ClockView {

    /**
     * Set the total amount of steps in seconds
     */
    void setTotalTime(int seconds);

    /**
     * Set the remaining seconds
     */
    void tick(int secondsLeft);

    /**
     * Notify
     */
    void onFinish();

}
