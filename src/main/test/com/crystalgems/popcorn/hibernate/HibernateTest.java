package com.crystalgems.popcorn.hibernate;

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

    ;

    @Before
    public void before() {
        HibernateUtilTest.getSessionFactory().getCurrentSession().beginTransaction();
    }

    @Test
    public void testMovieSave() {
        // Save
        Movie movie1 = new Movie();
        movie1.setTitleMovieLens("my movie test ML");
        movie1.setTitleImdb("my movie test IMDB");
        movie1.setDate(new Date(0));
        Assert.assertEquals(0, movie1.getMovieId());
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(movie1);
        Assert.assertNotEquals(0, movie1.getMovieId());
    }

    @Test
    public void testMovieLoad() {
        // Save a movie and a director to load them
        // Movie
        Movie movie = new Movie();
        movie.setTitleMovieLens("loadedML");
        movie.setTitleImdb("loadedIMDB");
        movie.setDate(new Date(0));
        Assert.assertEquals(0, movie.getMovieId());
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(movie);
        Assert.assertNotEquals(0, movie.getMovieId());
        int movieId = movie.getMovieId();
        // Director
        Director director = new Director();
        director.setFirstName("loadedFirstName");
        director.setLastName("loadedLastName");
        director.setMovies(new HashSet<>(Collections.singletonList(movie)));
        movie.setDirectors(new HashSet<>(Collections.singletonList(director)));
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(director);
        int directorId = director.getDirectorId();

        // Load the movie
        Movie movieLoaded;
        movieLoaded = HibernateUtilTest.getSessionFactory().getCurrentSession().load(Movie.class, movieId);
        Assert.assertEquals("loadedML", movieLoaded.getTitleMovieLens());
        Assert.assertEquals("loadedIMDB", movieLoaded.getTitleImdb());
        Assert.assertEquals(new Date(0), movieLoaded.getDate());
        // Load the director
        Director directorLoaded = HibernateUtilTest.getSessionFactory().getCurrentSession().load(Director.class, directorId);
        Assert.assertEquals("loadedFirstName", director.getFirstName());
        Assert.assertEquals("loadedLastName", director.getLastName());
        // Load the relation
        Assert.assertNotNull(movieLoaded.getDirectors());
        Director directorLoadedFromRelation = (Director) movieLoaded.getDirectors().toArray()[0];
        Assert.assertEquals(directorId, directorLoadedFromRelation.getDirectorId());
    }

    @After
    public void after() {
        HibernateUtilTest.getSessionFactory().getCurrentSession().getTransaction().rollback();
    }
}
