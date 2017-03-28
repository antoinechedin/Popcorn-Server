package com.crystalgems.popcorn.hibernate;

import com.crystalgems.popcorn.algo.ObjectRate;
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
    private Movie movie2 = new Movie();
    private Movie movie3 = new Movie();
    private Director director1 = new Director();
    private Actor actor1 = new Actor();
    private Genre genre1 = new Genre();
    private Genre genre2 = new Genre();
    private Genre genre3 = new Genre();
    private Keyword keyword1 = new Keyword();
    private Country country1 = new Country();
    private Distributor distributor1 = new Distributor();
    private Language language1 = new Language();
    private Type type1 = new Type();
    private User user1 = new User();
    private Gender gender1 = new Gender();
    private Age age1 = new Age();
    private Rating rating1 = new Rating();

    @Before
    public void before() {
        // Movie 1
        movie1.setTitleMovieLens("titleMovieLens");
        movie1.setTitleImdb("titleIMDB");
        movie1.setYear(1990);
        // Movie 2
        movie2.setTitleMovieLens("titleMovieLens");
        movie2.setTitleImdb("titleIMDB");
        movie2.setYear(1990);
        // Movie 3
        movie3.setTitleMovieLens("otherTitleMovieLens");
        movie3.setTitleImdb("otherTitleIMDB");
        movie3.setYear(1991);
        // Genre 1
        genre1.setGenre("genre");
        genre1.setMovies(new HashSet<>(Collections.singletonList(movie1)));
        // Genre 2
        genre2.setGenre("genre");
        genre2.setMovies(new HashSet<>(Collections.singletonList(movie1)));
        // Genre 3
        genre3.setGenre("otherGenre");
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
        // Type 1
        type1.setType("type");
        type1.setTypeDescription("typeDescription");
        type1.setMovies(new HashSet<>(Collections.singletonList(movie1)));
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
        // Rating
        rating1.setRating(3);
        rating1.setTimeStamp(0);
        rating1.setUser(user1);
        rating1.setMovie(movie1);

        // Movie 1 Relation
        movie1.setDirectors(new HashSet<>(Collections.singletonList(director1)));
        movie1.setActors(new HashSet<>(Collections.singletonList(actor1)));
        movie1.setGenres(new HashSet<>(Collections.singletonList(genre1)));
        movie1.setCountries(new HashSet<>(Collections.singletonList(country1)));
        movie1.setDistributors(new HashSet<>(Collections.singletonList(distributor1)));
        movie1.setKeywords(new HashSet<>(Collections.singletonList(keyword1)));
        movie1.setLanguages(new HashSet<>(Collections.singletonList(language1)));
        movie1.setRatings(new HashSet<>(Collections.singletonList(rating1)));
        movie1.setType(type1);
        // User 1 Relation
        user1.setGender(gender1);
        user1.setAge(age1);
        user1.setRatings(new HashSet<>(Collections.singletonList(rating1)));

        // Init Transaction
        HibernateUtilTest.getSessionFactory().getCurrentSession().beginTransaction();
    }

    @Test
    public void testSaveAndLoad() {
        // Save movie
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(movie1);
        int movieId = movie1.getId();
        // Save genre
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(genre1);
        int genreId = genre1.getId();
        // Save Director
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(director1);
        int directorId = director1.getId();
        // Save Actor
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(actor1);
        int actorId = actor1.getId();
        // Save Country
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(country1);
        int countryId = country1.getId();
        // Save Distributor
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(distributor1);
        int distributorId = distributor1.getId();
        // Save Keyword
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(keyword1);
        int keywordId = keyword1.getId();
        // Save Language
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(language1);
        int languageId = language1.getId();
        // Save Type
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(type1);
        int typeId = type1.getId();
        // Save Age
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(age1);
        int ageId = age1.getId();
        // Save Gender
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(gender1);
        int genderId = gender1.getId();
        // Save User
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(user1);
        int userId = user1.getId();
        // Save Rating
        HibernateUtilTest.getSessionFactory().getCurrentSession().save(rating1);
        int ratingId = rating1.getId();

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
        // Load Language
        Type typeLoaded1 = HibernateUtilTest.getSessionFactory().getCurrentSession().load(Type.class, typeId);
        Assert.assertEquals(type1.getType(), typeLoaded1.getType());
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
        // Load Rating
        Rating ratingLoaded1 = HibernateUtilTest.getSessionFactory().getCurrentSession().load(Rating.class, ratingId);
        Assert.assertEquals(rating1.getRating(), ratingLoaded1.getRating());

        // Check relation
        // Movie
        Assert.assertEquals(director1.getLastName(), ((Director) movieLoaded1.getDirectors().toArray()[0]).getLastName());
        Assert.assertEquals(actor1.getLastName(), ((Actor) movieLoaded1.getActors().toArray()[0]).getLastName());
        Assert.assertEquals(genre1.getGenre(), ((Genre) movieLoaded1.getGenres().toArray()[0]).getGenre());
        Assert.assertEquals(country1.getCountry(), ((Country) movieLoaded1.getCountries().toArray()[0]).getCountry());
        Assert.assertEquals(distributor1.getDistributionCompany(), ((Distributor) movieLoaded1.getDistributors().toArray()[0]).getDistributionCompany());
        Assert.assertEquals(keyword1.getKeyword(), ((Keyword) movieLoaded1.getKeywords().toArray()[0]).getKeyword());
        Assert.assertEquals(language1.getLanguage(), ((Language) movieLoaded1.getLanguages().toArray()[0]).getLanguage());
        Assert.assertEquals(rating1.getRating(), ((Rating) movieLoaded1.getRatings().toArray()[0]).getRating());
        Assert.assertEquals(type1.getType(), movieLoaded1.getType().getType());
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
        // Type
        Assert.assertEquals(movie1.getTitleMovieLens(), ((Movie) typeLoaded1.getMovies().toArray()[0]).getTitleMovieLens());
        // User
        Assert.assertEquals(gender1.getGender(), userLoaded1.getGender().getGender());
        Assert.assertEquals(age1.getMinAge(), userLoaded1.getAge().getMinAge());
        Assert.assertEquals(rating1.getRating(), ((Rating) userLoaded1.getRatings().toArray()[0]).getRating());
        // Gender
        Assert.assertEquals(user1.getLogin(), ((User) genderLoaded1.getUsers().toArray()[0]).getLogin());
        // Age
        Assert.assertEquals(user1.getLogin(), ((User) ageLoaded1.getUsers().toArray()[0]).getLogin());
        // Rating
        Assert.assertEquals(user1.getLogin(), ratingLoaded1.getUser().getLogin());
        Assert.assertEquals(movie1.getTitleMovieLens(), ratingLoaded1.getMovie().getTitleMovieLens());
    }

    @Test
    public void testEquality() {
        // Movie
        movie1.setId(1);
        movie2.setId(2);
        movie3.setId(3);
        Assert.assertEquals(movie1, movie1);
        Assert.assertNotEquals(null, movie1);
        Assert.assertEquals(movie2, movie1);
        Assert.assertNotEquals(movie3, movie1);
        // Genre
        genre1.setId(1);
        genre2.setId(2);
        genre3.setId(3);
        Assert.assertEquals(genre1, genre1);
        Assert.assertNotEquals(null, genre1);
        Assert.assertEquals(genre2, genre1);
        Assert.assertNotEquals(genre3, genre1);

        // ObjectRate

        ObjectRate objectRate1 = new ObjectRate(movie1, 1);
        ObjectRate objectRate2 = new ObjectRate(movie2, 1);
        ObjectRate objectRate3 = new ObjectRate(movie3, 1);
        Assert.assertEquals(objectRate1, objectRate1);
        Assert.assertNotEquals(null, objectRate1);
        Assert.assertEquals(objectRate2, objectRate1);
        Assert.assertNotEquals(objectRate3, objectRate1);

    }

    @After
    public void after() {
        // Rollback everything
        HibernateUtilTest.getSessionFactory().getCurrentSession().getTransaction().rollback();
    }
}
