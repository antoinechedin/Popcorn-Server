package com.crystalgems.popcorn.model;

import javax.persistence.*;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "sound")
public class Sound {
    private int soundsMixId;
    private String soundMix;

    @Id
    @Column(name = "SoundsMixId")
    public int getSoundsMixId() {
        return soundsMixId;
    }

    public void setSoundsMixId(int soundsMixId) {
        this.soundsMixId = soundsMixId;
    }

    @Basic
    @Column(name = "SoundMix")
    public String getSoundMix() {
        return soundMix;
    }

    public void setSoundMix(String soundMix) {
        this.soundMix = soundMix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sound sound = (Sound) o;

        if (soundsMixId != sound.soundsMixId) return false;
        return soundMix != null ? soundMix.equals(sound.soundMix) : sound.soundMix == null;
    }

    @Override
    public int hashCode() {
        int result = soundsMixId;
        result = 31 * result + (soundMix != null ? soundMix.hashCode() : 0);
        return result;
    }
}
