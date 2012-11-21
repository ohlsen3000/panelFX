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

    private String fileUrl;

    public SoundThread(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    public void run() {
        Media sound = new Media(fileUrl);
        MediaPlayer player = new MediaPlayer(sound);
        player.play();
    }
}
