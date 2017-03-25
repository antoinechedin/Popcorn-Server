package com.crystalgems.popcorn.hibernate;

import com.crystalgems.popcorn.model.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
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
    private Language language1 = new Language();

    private User user1 = new User();
    private Gender gender1 = new Gender();
    private Age age1 = new Age();
    private Occupation occupation1 = new Occupation();

    @Before
    public void before() {
        // Movie 1
        movie1.setTitleMovieLens("titleMovieLens");
        movie1.setTitleImdb("titleIMDB");
        movie1.setYear(1990);
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
        // Language 1
        language1.setLanguage("language");
        language1.setMovies(new HashSet<>(Collections.singletonList(movie1)));
        // Movie 1 Relation
        movie1.setDirectors(new HashSet<>(Collections.singletonList(director1)));
        movie1.setActors(new HashSet<>(Collections.singletonList(actor1)));
        movie1.setGenres(new HashSet<>(Collections.singletonList(genre1)));
        movie1.setCountries(new HashSet<>(Collections.singletonList(country1)));
        movie1.setDistributors(new HashSet<>(Collections.singletonList(distributor1)));
        movie1.setKeywords(new HashSet<>(Collections.singletonList(keyword1)));
        movie1.setLanguages(new HashSet<>(Collections.singletonList(language1)));

        // User 1
        user1.setLogin("login");
        user1.setPassword("password");
        // Gender 1
        gender1.setGender("gender");
        gender1.setUsers(new HashSet<>(Collections.singletonList(user1)));
        // Age 1
        age1.setMaxAge(1);
        age1.setMinAge(0);
        age1.setUsers(new HashSet<>(Collections.singletonList(user1)));
        // Occupation
        occupation1.setOccupation("occupation");
        occupation1.setUsers(new HashSet<>(Collections.singletonList(user1)));
        // User 1 Relation
        user1.setGender(gender1);
        user1.setAge(age1);
        user1.setOccupation(occupation1);

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
        // Save Language
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(language1);
        int languageId = language1.getLanguageId();
        // Save User
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(user1);
        int userId = user1.getUserId();
        // Save Gender
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(gender1);
        int genderId = gender1.getGenderId();
        // Save Age
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(age1);
        int ageId = age1.getAgeId();
        // Save Occupation
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(occupation1);
        int occupationId = occupation1.getOccupationId();

        // Load movie
        Movie movieLoaded1 = HibernateUtilTest.getSessionFactory().getCurrentSession().load(Movie.class, movieId);
        Assert.assertEquals(movie1.getTitleMovieLens(), movieLoaded1.getTitleMovieLens());
        Assert.assertEquals(movie1.getTitleImdb(), movieLoaded1.getTitleImdb());
        Assert.assertEquals(movie1.getYear(), movieLoaded1.getYear());
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
        // Load Language
        Language languageLoaded1 = HibernateUtilTest.getSessionFactory().getCurrentSession().load(Language.class, languageId);
        Assert.assertEquals(language1.getLanguage(), languageLoaded1.getLanguage());
        // Load User
        User userLoaded1 = HibernateUtilTest.getSessionFactory().getCurrentSession().load(User.class, userId);
        Assert.assertEquals(user1.getLogin(), userLoaded1.getLogin());
        Assert.assertEquals(user1.getPassword(), userLoaded1.getPassword());
        // Load Gender
        Gender genderLoaded1 = HibernateUtilTest.getSessionFactory().getCurrentSession().load(Gender.class, genderId);
        Assert.assertEquals(gender1.getGender(), genderLoaded1.getGender());
        Assert.assertEquals(gender1.getGender(), genderLoaded1.getGender());
        // Load Age
        Age ageLoaded1 = HibernateUtilTest.getSessionFactory().getCurrentSession().load(Age.class, ageId);
        Assert.assertEquals(age1.getMaxAge(), ageLoaded1.getMaxAge());
        Assert.assertEquals(age1.getMinAge(), ageLoaded1.getMinAge());
        // Load Occupation
        Occupation occupationLoaded1 = HibernateUtilTest.getSessionFactory().getCurrentSession().load(Occupation.class, occupationId);
        Assert.assertEquals(occupation1.getOccupation(), occupationLoaded1.getOccupation());

        // Check relation
        // Movie
        Assert.assertEquals(director1.getLastName(), ((Director) movieLoaded1.getDirectors().toArray()[0]).getLastName());
        Assert.assertEquals(actor1.getLastName(), ((Actor) movieLoaded1.getActors().toArray()[0]).getLastName());
        Assert.assertEquals(genre1.getGenre(), ((Genre) movieLoaded1.getGenres().toArray()[0]).getGenre());
        Assert.assertEquals(country1.getCountry(), ((Country) movieLoaded1.getCountries().toArray()[0]).getCountry());
        Assert.assertEquals(distributor1.getDistributionCompany(), ((Distributor) movieLoaded1.getDistributors().toArray()[0]).getDistributionCompany());
        Assert.assertEquals(keyword1.getKeyword(), ((Keyword) movieLoaded1.getKeywords().toArray()[0]).getKeyword());
        Assert.assertEquals(language1.getLanguage(), ((Language) movieLoaded1.getLanguages().toArray()[0]).getLanguage());
        // Director
        Assert.assertEquals(movie1.getTitleMovieLens(), ((Movie) directorLoaded1.getMovies().toArray()[0]).getTitleMovieLens());
        // Actor
        Assert.assertEquals(movie1.getTitleMovieLens(), ((Movie) actorLoaded1.getMovies().toArray()[0]).getTitleMovieLens());
        // Genre
        Assert.assertEquals(movie1.getTitleMovieLens(), ((Movie) genreLoaded1.getMovies().toArray()[0]).getTitleMovieLens());
        // Country
        Assert.assertEquals(movie1.getTitleMovieLens(), ((Movie) countryLoaded1.getMovies().toArray()[0]).getTitleMovieLens());
        // Distributor
        Assert.assertEquals(movie1.getTitleMovieLens(), ((Movie) distributorLoaded1.getMovies().toArray()[0]).getTitleMovieLens());
        // Keyword
        Assert.assertEquals(movie1.getTitleMovieLens(), ((Movie) keywordLoaded1.getMovies().toArray()[0]).getTitleMovieLens());
        // Language
        Assert.assertEquals(movie1.getTitleMovieLens(), ((Movie) languageLoaded1.getMovies().toArray()[0]).getTitleMovieLens());

        // User
        Assert.assertEquals(gender1.getGender(), userLoaded1.getGender().getGender());
        Assert.assertEquals(age1.getMinAge(), userLoaded1.getAge().getMinAge());
        Assert.assertEquals(occupation1.getOccupation(), userLoaded1.getOccupation().getOccupation());
        // Gender
        Assert.assertEquals(user1.getLogin(), ((User) genderLoaded1.getUsers().toArray()[0]).getLogin());
        // Age
        Assert.assertEquals(user1.getLogin(), ((User) ageLoaded1.getUsers().toArray()[0]).getLogin());
        // Occupation
        Assert.assertEquals(user1.getLogin(), ((User) occupationLoaded1.getUsers().toArray()[0]).getLogin());
    }

    @After
    public void after() {
        // Rollback everything
        HibernateUtilTest.getSessionFactory().getCurrentSession().getTransaction().rollback();
    }
}
