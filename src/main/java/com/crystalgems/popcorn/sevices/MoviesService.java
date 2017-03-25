package com.crystalgems.popcorn.sevices;

import com.crystalgems.popcorn.hibernate.HibernateUtil;
import com.crystalgems.popcorn.model.Movie;
import org.hibernate.HibernateException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Path("movies")
public class MoviesService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMovies() {
        String res = "";
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            List movies = HibernateUtil.getSessionFactory().getCurrentSession().createQuery("from Movie").list();
            for (Iterator iterator = movies.iterator(); iterator.hasNext(); ) {
                Movie movie = (Movie) iterator.next();
                res += movie.getTitleMovieLens() + " (" + movie.getDate() + ")\n";
            }
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
            return res;
        } catch (HibernateException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Movie getMovieInJSON() {
        Movie movie = new Movie();
        movie.setMovieId(1);
        movie.setDate(new Date(System.currentTimeMillis()));
        movie.setTitleImdb("My movie IMB");
        movie.setTitleMovieLens("My movie ML");
        return movie;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Movies getMoviesById(@PathParam("id") int id) {
        Movies movie = new Movies();

        String hql = "from Movies M where M.movieId = " + id;

        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        movie = (Movies) HibernateUtil.getSessionFactory().getCurrentSession().createQuery(hql);
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();

        return movie;
    }
}
