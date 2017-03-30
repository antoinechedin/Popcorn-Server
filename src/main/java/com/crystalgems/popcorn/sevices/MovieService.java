package com.crystalgems.popcorn.sevices;

import com.crystalgems.popcorn.algo.ObjectRate;
import com.crystalgems.popcorn.algo.RecommendationAlgorithm;
import com.crystalgems.popcorn.hibernate.HibernateUtil;
import com.crystalgems.popcorn.model.Movie;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Antoine on 23/03/2017.
 */
@Path("")
public class MovieService {

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Path("get/movie")
    public Movie getMovieById(@QueryParam("id") int id) {
        Movie movie;
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            movie = (Movie) HibernateUtil.getSessionFactory().getCurrentSession().createQuery("from Movie M where M.id = " + id).getSingleResult();
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        return movie;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Path("get/movie-list")
    public Object[] getMovieList() {
        Object[] movies;
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            movies = HibernateUtil.getSessionFactory().getCurrentSession().createQuery("from Movie M").setMaxResults(100).list().toArray();
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        return movies;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Path("get/director")
    public Object[] getDirectorByMovieId(@QueryParam("movieId") int movieId) {
        Object[] o;
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            Movie movie = HibernateUtil.getSessionFactory().getCurrentSession().load(Movie.class, movieId);
            o = movie.getDirectors().toArray();
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        return o;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Path("get/actor")
    public Object[] getActorByMovieId(@QueryParam("movieId") int movieId) {
        Object[] o;
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            Movie movie = HibernateUtil.getSessionFactory().getCurrentSession().load(Movie.class, movieId);
            o = movie.getActors().toArray();
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        return o;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Path("get/genre")
    public Object[] getGenreByMovieId(@QueryParam("movieId") int movieId) {
        Object[] o;
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            Movie movie = HibernateUtil.getSessionFactory().getCurrentSession().load(Movie.class, movieId);
            o = movie.getGenres().toArray();
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        return o;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Path("get/keyword")
    public Object[] getKeywordByMovieId(@QueryParam("movieId") int movieId) {
        Object[] o;
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            Movie movie = HibernateUtil.getSessionFactory().getCurrentSession().load(Movie.class, movieId);
            o = movie.getKeywords().toArray();
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        return o;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Path("get/country")
    public Object[] getCountryByMovieId(@QueryParam("movieId") int movieId) {
        Object[] o;
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            Movie movie = HibernateUtil.getSessionFactory().getCurrentSession().load(Movie.class, movieId);
            o = movie.getCountries().toArray();
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        return o;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Path("get/distributor")
    public Object[] getDistributorByMovieId(@QueryParam("movieId") int movieId) {
        Object[] o;
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            Movie movie = HibernateUtil.getSessionFactory().getCurrentSession().load(Movie.class, movieId);
            o = movie.getDistributors().toArray();
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        return o;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Path("get/language")
    public Object[] getLanguageByMovieId(@QueryParam("movieId") int movieId) {
        Object[] o;
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            Movie movie = HibernateUtil.getSessionFactory().getCurrentSession().load(Movie.class, movieId);
            o = movie.getLanguages().toArray();
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        return o;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Path("get/rating")
    public Object[] getRatingByMovieId(@QueryParam("movieId") int movieId) {
        Object[] o;
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            Movie movie = HibernateUtil.getSessionFactory().getCurrentSession().load(Movie.class, movieId);
            o = movie.getRatings().toArray();
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        return o;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Path("get/nearest-movie-list")
    public List<ObjectRate<Movie>> getNearestMovie(@QueryParam("movieId") int movieId, @QueryParam("length") int length) {
        return RecommendationAlgorithm.getSimilarMoviesFrom(movieId, length, 1, 1, 1);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Path("get/nearest-movie-list-by-director")
    public List<ObjectRate<Movie>> getNearestMovieByDirector(@QueryParam("movieId") int movieId, @QueryParam("length") int length) {
        return RecommendationAlgorithm.getSimilarMoviesFrom(movieId, length, 1, 0, 0);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Path("get/nearest-movie-list-by-actor")
    public List<ObjectRate<Movie>> getNearestMovieByActor(@QueryParam("movieId") int movieId, @QueryParam("length") int length) {
        return RecommendationAlgorithm.getSimilarMoviesFrom(movieId, length, 0, 1, 0);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Path("get/nearest-movie-list-by-genre")
    public List<ObjectRate<Movie>> getNearestMovieByGenre(@QueryParam("movieId") int movieId, @QueryParam("length") int length) {
        return RecommendationAlgorithm.getSimilarMoviesFrom(movieId, length, 0, 0, 1);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Path("get/user-personal-recommendation-list")
    public List<ObjectRate<Movie>> getUserPersonnalRecommendation(@QueryParam("userId") int userId, @QueryParam("length") int length) {
        return RecommendationAlgorithm.getUserPersonalRecommendation(userId, length, 1, 1);
    }

}
