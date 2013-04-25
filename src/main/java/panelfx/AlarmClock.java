package panelfx;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class AlarmClock implements Runnable {

    private final int hour;
    private final int minute;

    private final PlayingSounds playingSounds;

    public AlarmClock(final PlayingSounds playingSounds) {
        super();
        this.playingSounds = playingSounds;
        this.hour = 10;
        this.minute = 0;

    }

    @Override
    public void run() {

        try {
            if ("CL-CZC0186XJH".equalsIgnoreCase(InetAddress.getLocalHost().getHostName())) {

                final Calendar now = new GregorianCalendar();
                final int hourNow = now.get(Calendar.HOUR_OF_DAY);
                final int minuteNow = now.get(Calendar.MINUTE);

                final Calendar firstExecutionDate = new GregorianCalendar();
                firstExecutionDate.set(Calendar.HOUR_OF_DAY, this.hour);
                firstExecutionDate.set(Calendar.MINUTE, this.minute);
                firstExecutionDate.set(Calendar.SECOND, 0);
                firstExecutionDate.set(Calendar.MILLISECOND, 0);
                if ((this.hour < hourNow) || ((this.hour == hourNow) && (this.minute < minuteNow))) {
                    //Do not execute today, first execution will be tomorrow.
                    firstExecutionDate.roll(Calendar.DAY_OF_MONTH, true);
                }

                final long oneDay = 1000L * 60L * 60L * 24L;

                System.out.println("First execution " + firstExecutionDate.toString());
                final Timer timer = new Timer();
                timer.schedule(new StandupSoundTimer(), firstExecutionDate.getTime(), oneDay);

            }
        } catch (final UnknownHostException e) {
            System.out.println("no alarm clock: " + e.getMessage());
        }

    }

    protected class StandupSoundTimer extends TimerTask {

        @Override
        public void run() {
            final String url = PanelFX.class.getResource(Sound.STANDUP.getFilename() + ".mp3").toString();
            final SoundThread sound = new SoundThread(url, AlarmClock.this.playingSounds);
            sound.run();
        }

    }
}
