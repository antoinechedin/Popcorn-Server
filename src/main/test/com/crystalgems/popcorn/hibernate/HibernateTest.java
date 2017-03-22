package com.crystalgems.popcorn.hibernate;

import com.crystalgems.popcorn.model.Actor;
import com.crystalgems.popcorn.model.Director;
import com.crystalgems.popcorn.model.Genre;
import com.crystalgems.popcorn.model.Movie;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by Antoine on 21/03/2017.
 */
public class HibernateTest {
    private Movie movie1 = new Movie();
    private Director director1 = new Director();
    private Actor actor1 = new Actor();
    private Genre genre1 = new Genre();

    @Before
    public void before() {
        // Movie 1
        movie1.setTitleMovieLens("titleMovieLens");
        movie1.setTitleImdb("titleIMDB");
        movie1.setDate(new Date(0));
        // Genre 1
        genre1.setGenre("genre");
        // Director 1
        director1.setFirstName("firstName");
        director1.setLastName("lastName");
        //Actor 1
        actor1.setFirstName("firstName");
        actor1.setLastName("lastName");
        // Movie 1 + Director 1 + Actor 1 + Genre 1
        movie1.setDirectors(new HashSet<>(Collections.singletonList(director1)));
        movie1.setActors(new HashSet<>(Collections.singletonList(actor1)));
        movie1.setGenres(new HashSet<>(Collections.singletonList(genre1)));
        director1.setMovies(new HashSet<>(Collections.singletonList(movie1)));
        actor1.setMovies(new HashSet<>(Collections.singletonList(movie1)));
        genre1.setMovies(new HashSet<>(Collections.singletonList(movie1)));

        // Init Transaction
        HibernateUtilTest.getSessionFactory().getCurrentSession().beginTransaction();
    }

    @Test
    public void testSave() {
        // Save
        Assert.assertEquals(0, movie1.getMovieId());
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(movie1);
        Assert.assertNotEquals(0, movie1.getMovieId());
    }

    @Test
    public void testLoad() {
        // Save a movie and a director to load them
        // Movie
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(movie1);
        int movieId = movie1.getMovieId();
        // Genre
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(genre1);
        int genreId = genre1.getGenreId();
        // Director
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(director1);
        int directorId = director1.getDirectorId();
        //Actor
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(actor1);
        int actorId = actor1.getActorId();

        // Load movie
        Movie movieLoaded1 = HibernateUtilTest.getSessionFactory().getCurrentSession().load(Movie.class, movieId);
        Assert.assertEquals(movie1.getTitleMovieLens(), movieLoaded1.getTitleMovieLens());
        Assert.assertEquals(movie1.getTitleImdb(), movieLoaded1.getTitleImdb());
        Assert.assertEquals(movie1.getDate(), movieLoaded1.getDate());
        // Load genre
        Genre genreLoaded1 = HibernateUtilTest.getSessionFactory().getCurrentSession().load(Genre.class, genreId);
        Assert.assertEquals(genre1.getGenre(), genreLoaded1.getGenre());
        // Load director
        Director directorLoaded1 = HibernateUtilTest.getSessionFactory().getCurrentSession().load(Director.class, directorId);
        Assert.assertEquals(director1.getFirstName(), directorLoaded1.getFirstName());
        Assert.assertEquals(director1.getLastName(), directorLoaded1.getLastName());
        // Load actor
        Actor actorLoaded1 = HibernateUtilTest.getSessionFactory().getCurrentSession().load(Actor.class, actorId);
        Assert.assertEquals(actor1.getFirstName(), actorLoaded1.getFirstName());
        Assert.assertEquals(actor1.getLastName(), actorLoaded1.getLastName());

        // Check relation
        // Movie
        Assert.assertNotNull(movieLoaded1.getDirectors());
        Assert.assertNotNull(movieLoaded1.getActors());
        Assert.assertNotNull(movieLoaded1.getGenres());
        // Director
        Assert.assertNotNull(directorLoaded1.getMovies());
        // Actor
        Assert.assertNotNull(actorLoaded1.getMovies());
        // Genre
        Assert.assertNotNull(genreLoaded1.getMovies());
    }

    @After
    public void after() {
        // Rollback everything
        HibernateUtilTest.getSessionFactory().getCurrentSession().getTransaction().rollback();
    }
}
