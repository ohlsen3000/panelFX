package panelfx;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

import javafx.stage.Stage;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class AlarmClock {

	private final String user;

	private final int hour;
	private final int minute;

	@Inject
	private SoundPlayer soundPlayer;

	public AlarmClock() {
		super();
		this.user = System.getProperty("user.name");
		this.hour = 10;
		this.minute = 0;
	}

	public void run(@Observes @StartupScene final Stage primaryStage) {
		if ("ugz".equalsIgnoreCase(this.user)) {

			final Calendar now = new GregorianCalendar();
			final int hourNow = now.get(Calendar.HOUR_OF_DAY);
			final int minuteNow = now.get(Calendar.MINUTE);

			final Calendar firstExecutionDate = new GregorianCalendar();
			firstExecutionDate.set(Calendar.HOUR_OF_DAY, this.hour);
			firstExecutionDate.set(Calendar.MINUTE, this.minute);
			firstExecutionDate.set(Calendar.SECOND, 0);
			firstExecutionDate.set(Calendar.MILLISECOND, 0);
			if (this.hour < hourNow || this.hour == hourNow
					&& this.minute < minuteNow) {
				// Do not execute today, first execution will be tomorrow.
				firstExecutionDate.roll(Calendar.DAY_OF_MONTH, true);
			}

			final long oneDay = 1000L * 60L * 60L * 24L;

			System.out.println("First execution "
					+ firstExecutionDate.toString());
			final Timer timer = new Timer();
			timer.schedule(new StandupSoundTimer(),
					firstExecutionDate.getTime(), oneDay);

		}

	}

	protected class StandupSoundTimer extends TimerTask {

		@Override
		public void run() {
			AlarmClock.this.soundPlayer.play(Sound.STANDUP);
		}

	}
}
