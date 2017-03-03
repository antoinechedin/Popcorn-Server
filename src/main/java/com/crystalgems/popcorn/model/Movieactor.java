package com.crystalgems.popcorn.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Antoine on 03/03/2017.
 */
@Entity
public class Movieactor {
    private int movieActorLinkId;
    private int movieId;
    private int actorId;
    private String playInfo;
    private String role;
    private String casting;

    @Id
    @Column(name = "MovieActorLinkId")
    public int getMovieActorLinkId() {
        return movieActorLinkId;
    }

    public void setMovieActorLinkId(int movieActorLinkId) {
        this.movieActorLinkId = movieActorLinkId;
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
    @Column(name = "ActorId")
    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    @Basic
    @Column(name = "PlayInfo")
    public String getPlayInfo() {
        return playInfo;
    }

    public void setPlayInfo(String playInfo) {
        this.playInfo = playInfo;
    }

    @Basic
    @Column(name = "Role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "Casting")
    public String getCasting() {
        return casting;
    }

    public void setCasting(String casting) {
        this.casting = casting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movieactor that = (Movieactor) o;

        if (movieActorLinkId != that.movieActorLinkId) return false;
        if (movieId != that.movieId) return false;
        if (actorId != that.actorId) return false;
        if (playInfo != null ? !playInfo.equals(that.playInfo) : that.playInfo != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        return casting != null ? casting.equals(that.casting) : that.casting == null;
    }

    @Override
    public int hashCode() {
        int result = movieActorLinkId;
        result = 31 * result + movieId;
        result = 31 * result + actorId;
        result = 31 * result + (playInfo != null ? playInfo.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (casting != null ? casting.hashCode() : 0);
        return result;
    }
}
