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
    public void setTotalTime(int seconds);

    /**
     * Set the remaining seconds
     */
    public void tick(int secondsLeft);

}
