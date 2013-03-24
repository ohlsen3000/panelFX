/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panelfx;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * @author ugz
 */
public class SoundThread implements Runnable {

	MediaPlayer player = null;

	RunningSounds runningSounds = null;

	public SoundThread(final String fileUrl, final RunningSounds runningSounds) {

		final Media sound = new Media(fileUrl);
		this.player = new MediaPlayer(sound);
		this.runningSounds = runningSounds;
	}

	@Override
	public void run() {
		this.runningSounds.add(this);
		this.player.play();
	}

	public void stop(){
		this.player.stop();
	}

	@Override
	protected void finalize() throws Throwable {
		this.runningSounds.remove(this);
	}


}
