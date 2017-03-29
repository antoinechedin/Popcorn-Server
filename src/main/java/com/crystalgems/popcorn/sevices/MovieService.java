package com.crystalgems.popcorn.sevices;

import com.crystalgems.popcorn.algo.ObjectRate;
import com.crystalgems.popcorn.algo.RecommendationAlgorithm;
import com.crystalgems.popcorn.hibernate.HibernateUtil;
import com.crystalgems.popcorn.model.Movie;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.http.HTTPException;
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
    @Path("get/{objectType}")
    public Object[] getByMovieId(@PathParam("objectType") String objectType, @QueryParam("movieId") int movieId) {
        Object[] o = null;
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            Movie movie = HibernateUtil.getSessionFactory().getCurrentSession().load(Movie.class, movieId);
            switch (objectType) {
                case "director":
                    o = movie.getDirectors().toArray();
                    break;
                case "actor":
                    o = movie.getActors().toArray();
                    break;
                case "genre":
                    o = movie.getGenres().toArray();
                    break;
                case "keyword":
                    o = movie.getKeywords().toArray();
                    break;
                case "country":
                    o = movie.getCountries().toArray();
                    break;
                case "distributor":
                    o = movie.getDistributors().toArray();
                    break;
                case "language":
                    o = movie.getLanguages().toArray();
                    break;
                case "rating":
                    o = movie.getRatings().toArray();
                    break;
                default:
                    throw new HTTPException(501);
            }
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
