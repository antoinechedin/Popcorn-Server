package com.crystalgems.popcorn.sevices;

import com.crystalgems.popcorn.hibernate.HibernateUtil;
import com.crystalgems.popcorn.model.Movie;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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
            movie = HibernateUtil.getSessionFactory().getCurrentSession().load(Movie.class, id);
            movie.getTitleMovieLens();
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        return movie;
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
            }
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        return o;
    }
}
