package panelfx.sound;

import java.util.ArrayList;

public class PlayingSounds {

    ArrayList<SoundThread> sounds = new ArrayList<>();

    public void add(final SoundThread sound) {
        this.sounds.add(sound);
    }

    public void remove(final SoundThread sound) {
        this.sounds.remove(sound);
    }

    public void stopAll() {
        for (final SoundThread sound : new ArrayList<>(this.sounds)) {
            sound.stop();
        }
    }
}
