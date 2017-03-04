package com.crystalgems.popcorn.sevices;

import com.crystalgems.popcorn.hibernate.HibernateUtil;
import com.crystalgems.popcorn.model.Director;
import org.hibernate.HibernateException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.Iterator;
import java.util.List;

@Path("/director")
public class DirectorService {
    @GET
    @Path("{movieId}")
    public Director[] getDirectorsByMovieIdInJSON(@PathParam("movieId") int movieId) {
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            List directorList = HibernateUtil.getSessionFactory().getCurrentSession()
                    .createQuery("SELECT d FROM Director d, Moviedirector md " +
                            "WHERE d.directorId = md.directorId " +
                            "AND md.movieId = " + movieId).list();
            if (directorList != null) {
                Director[] directors = new Director[directorList.size()];
                int i = 0;
                for (Iterator iterator = directorList.iterator(); iterator.hasNext(); ) {
                    directors[i] = (Director) iterator.next();
                    i++;
                }
                HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
                return directors;
            } else
                return null;
        } catch (HibernateException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
    }
}
