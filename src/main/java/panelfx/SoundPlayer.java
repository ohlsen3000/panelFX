package panelfx;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class SoundPlayer {

	@Inject
	PlayingSounds playingSounds;

	public void play(@Observes final Sound sound){
		final SoundThread soundThread = new SoundThread(sound.getUrl(), this.playingSounds);
		soundThread.run();
	}
}
