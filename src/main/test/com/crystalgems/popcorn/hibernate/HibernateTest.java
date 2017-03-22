package com.crystalgems.popcorn.hibernate;

import com.crystalgems.popcorn.model.Actor;
import com.crystalgems.popcorn.model.Director;
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

    @Before
    public void before() {
        // Movie 1
        movie1.setTitleMovieLens("titleMovieLens");
        movie1.setTitleImdb("titleIMDB");
        movie1.setDate(new Date(0));
        // Director 1
        director1.setFirstName("firstName");
        director1.setLastName("lastName");
        //Actor 1
        actor1.setFirstName("firstName");
        actor1.setLastName("lastName");
        // Movie 1 + Director 1 + Actor 1
        movie1.setDirectors(new HashSet<Director>(Collections.singletonList(director1)));
        movie1.setActors(new HashSet<Actor>(Collections.singletonList(actor1)));
        director1.setMovies(new HashSet<Movie>(Collections.singletonList(movie1)));
        actor1.setMovies(new HashSet<Movie>(Collections.singletonList(movie1)));

        // Init Transaction
        HibernateUtilTest.getSessionFactory().getCurrentSession().beginTransaction();
    }

    @Test
    public void testMovieSave() {
        // Save
        Assert.assertEquals(0, movie1.getMovieId());
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(movie1);
        Assert.assertNotEquals(0, movie1.getMovieId());
    }

    @Test
    public void testMovieLoad() {
        // Save a movie and a director to load them
        // Movie
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(movie1);
        int movieId = movie1.getMovieId();
        // Director
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(director1);
        int directorId = director1.getDirectorId();
        //Actor
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(actor1);
        int actorId = actor1.getActorId();

        // Load the movie
        Movie movieLoaded1;
        movieLoaded1 = HibernateUtilTest.getSessionFactory().getCurrentSession().load(Movie.class, movieId);
        Assert.assertEquals(movie1.getTitleMovieLens(), movieLoaded1.getTitleMovieLens());
        Assert.assertEquals(movie1.getTitleImdb(), movieLoaded1.getTitleImdb());
        Assert.assertEquals(movie1.getDate(), movieLoaded1.getDate());
        // Load the director
        Director directorLoaded1 = HibernateUtilTest.getSessionFactory().getCurrentSession().load(Director.class, directorId);
        Assert.assertEquals(director1.getFirstName(), directorLoaded1.getFirstName());
        Assert.assertEquals(director1.getLastName(), directorLoaded1.getLastName());
        // Load the actor
        Actor actorLoaded1 = HibernateUtilTest.getSessionFactory().getCurrentSession().load(Actor.class, actorId);
        Assert.assertEquals(actor1.getFirstName(), actorLoaded1.getFirstName());
        Assert.assertEquals(actor1.getLastName(), actorLoaded1.getLastName());

        // Check relation
        // Movie
        Assert.assertNotNull(movieLoaded1.getDirectors());
        Assert.assertNotNull(movieLoaded1.getActors());
        // Director
        Assert.assertNotNull(directorLoaded1.getMovies());
        // Actor
        Assert.assertNotNull(actorLoaded1.getMovies());
    }

    @After
    public void after() {
        // Rollback everything
        HibernateUtilTest.getSessionFactory().getCurrentSession().getTransaction().rollback();
    }
}
