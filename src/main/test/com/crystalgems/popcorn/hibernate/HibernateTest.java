package com.crystalgems.popcorn.hibernate;

import com.crystalgems.popcorn.model.*;
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
    private Keyword keyword1 = new Keyword();

    private Country country1 = new Country();
    private Distributor distributor1 = new Distributor();

    @Before
    public void before() {
        // Movie 1
        movie1.setTitleMovieLens("titleMovieLens");
        movie1.setTitleImdb("titleIMDB");
        movie1.setDate(new Date(0));
        // Genre 1
        genre1.setGenre("genre");
        genre1.setMovies(new HashSet<>(Collections.singletonList(movie1)));
        // Director 1
        director1.setFirstName("firstName");
        director1.setLastName("lastName");
        director1.setMovies(new HashSet<>(Collections.singletonList(movie1)));
        //Actor 1
        actor1.setFirstName("firstName");
        actor1.setLastName("lastName");
        actor1.setMovies(new HashSet<>(Collections.singletonList(movie1)));
        // Country 1
        country1.setContinent("continent");
        country1.setCountry("country");
        country1.setLongName("longName");
        country1.setMovies(new HashSet<>(Collections.singletonList(movie1)));
        // Distributor 1
        distributor1.setDistributionCompany("DistributionCompany");
        distributor1.setMovies(new HashSet<>(Collections.singletonList(movie1)));
        // Keyword 1
        keyword1.setKeyword("keyword");
        keyword1.setMovies(new HashSet<>(Collections.singletonList(movie1)));
        // Movie 1 Relation
        movie1.setDirectors(new HashSet<>(Collections.singletonList(director1)));
        movie1.setActors(new HashSet<>(Collections.singletonList(actor1)));
        movie1.setGenres(new HashSet<>(Collections.singletonList(genre1)));
        movie1.setCountries(new HashSet<>(Collections.singletonList(country1)));
        movie1.setDistributors(new HashSet<>(Collections.singletonList(distributor1)));
        movie1.setKeywords(new HashSet<>(Collections.singletonList(keyword1)));

        // Init Transaction
        HibernateUtilTest.getSessionFactory().getCurrentSession().beginTransaction();
    }

    @Test
    public void testSaveAndLoad() {
        // Save movie
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(movie1);
        int movieId = movie1.getMovieId();
        // Save genre
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(genre1);
        int genreId = genre1.getGenreId();
        // Save Director
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(director1);
        int directorId = director1.getDirectorId();
        // Save Actor
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(actor1);
        int actorId = actor1.getActorId();
        // Save Country
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(country1);
        int countryId = country1.getCountryId();
        // Save Distributor
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(distributor1);
        int distributorId = distributor1.getDistributorId();
        // Save Keyword
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(keyword1);
        int keywordId = keyword1.getKeywordId();

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
        // Load Country
        Country countryLoaded1 = HibernateUtilTest.getSessionFactory().getCurrentSession().load(Country.class, countryId);
        Assert.assertEquals(country1.getContinent(), countryLoaded1.getContinent());
        Assert.assertEquals(country1.getCountry(), countryLoaded1.getCountry());
        Assert.assertEquals(country1.getLongName(), countryLoaded1.getLongName());
        // Load Distributor
        Distributor distributorLoaded1 = HibernateUtilTest.getSessionFactory().getCurrentSession().load(Distributor.class, distributorId);
        Assert.assertEquals(distributor1.getDistributionCompany(), distributorLoaded1.getDistributionCompany());
        // Load Keyword
        Keyword keywordLoaded1 = HibernateUtilTest.getSessionFactory().getCurrentSession().load(Keyword.class, keywordId);
        Assert.assertEquals(keyword1.getKeyword(), keywordLoaded1.getKeyword());

        // Check relation
        // Movie
        Assert.assertNotNull(movieLoaded1.getDirectors());
        Assert.assertNotNull(movieLoaded1.getActors());
        Assert.assertNotNull(movieLoaded1.getGenres());
        Assert.assertNotNull(movieLoaded1.getCountries());
        Assert.assertNotNull(movieLoaded1.getDistributors());
        Assert.assertNotNull(movieLoaded1.getKeywords());
        // Director
        Assert.assertNotNull(directorLoaded1.getMovies());
        // Actor
        Assert.assertNotNull(actorLoaded1.getMovies());
        // Genre
        Assert.assertNotNull(genreLoaded1.getMovies());
        // Country
        Assert.assertNotNull(countryLoaded1.getMovies());
        // Distributor
        Assert.assertNotNull(distributorLoaded1.getMovies());
        // Keyword
        Assert.assertNotNull(keywordLoaded1.getMovies());
    }

    @After
    public void after() {
        // Rollback everything
        HibernateUtilTest.getSessionFactory().getCurrentSession().getTransaction().rollback();
    }
}
