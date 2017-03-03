package com.crystalgems.popcorn.model;

import javax.persistence.*;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
@Table(name = "moviesound")
public class Moviesound {
    private int movieSoundLinkId;
    private int movieId;
    private int soundMixId;

    @Id
    @Column(name = "MovieSoundLinkId")
    public int getMovieSoundLinkId() {
        return movieSoundLinkId;
    }

    public void setMovieSoundLinkId(int movieSoundLinkId) {
        this.movieSoundLinkId = movieSoundLinkId;
    }

    @Basic
    @Column(name = "MovieId")
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "SoundMixId")
    public int getSoundMixId() {
        return soundMixId;
    }

    public void setSoundMixId(int soundMixId) {
        this.soundMixId = soundMixId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Moviesound that = (Moviesound) o;

        if (movieSoundLinkId != that.movieSoundLinkId) return false;
        if (movieId != that.movieId) return false;
        return soundMixId == that.soundMixId;
    }

    @Override
    public int hashCode() {
        int result = movieSoundLinkId;
        result = 31 * result + movieId;
        result = 31 * result + soundMixId;
        return result;
    }
}
