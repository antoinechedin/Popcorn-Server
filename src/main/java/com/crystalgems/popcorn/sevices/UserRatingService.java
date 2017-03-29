package com.crystalgems.popcorn.sevices;

import com.crystalgems.popcorn.hibernate.HibernateUtil;
import com.crystalgems.popcorn.model.Movie;
import com.crystalgems.popcorn.model.Rating;
import com.crystalgems.popcorn.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by valentin on 29/03/2017.
 */
@Path("")
public class UserRatingService {

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Path("get/user-rating")
    public Rating getUserRating(@QueryParam("idUser") int idUser, @QueryParam("idMovie") int idMovie) {
        Rating userRating;

        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            userRating = (Rating) HibernateUtil.getSessionFactory().getCurrentSession()
                    .createQuery("from Rating R where R.user.id = " + idUser + " and R.movie.id = " + idMovie).uniqueResult();
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }

        return userRating;
    }

    @POST
    @Path("create/user-rating")
    public Response createUser(@QueryParam("idUser") int idUser, @QueryParam("idMovie") int idMovie, @QueryParam("rate") int rate) {
        Rating rating = new Rating();

        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

            User user = (User) HibernateUtil.getSessionFactory().getCurrentSession().createQuery("from User U where U.id = " + idUser).uniqueResult();
            Movie movie = (Movie) HibernateUtil.getSessionFactory().getCurrentSession().createQuery("from Movie M where M.id = " + idMovie).uniqueResult();

            rating.setRating(rate);
            rating.setUser(user);
            rating.setMovie(movie);

            HibernateUtil.getSessionFactory().getCurrentSession().save(rating);

            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }

        return Response.status(201).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Path("update/user-rating")
    public Response updateUserRating(Rating userRatingToUpdate) {

        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            Rating rating = HibernateUtil.getSessionFactory().getCurrentSession().load(Rating.class, userRatingToUpdate.getId());

            rating.setRating(userRatingToUpdate.getRating());
            HibernateUtil.getSessionFactory().getCurrentSession().update(rating);

            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();

        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }

        return Response.status(200).build();
    }

    @PUT
    @Path("delete/user-rating")
    public Response deleteUserRating(@QueryParam("id") int id) {
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

            Rating rating = HibernateUtil.getSessionFactory().getCurrentSession().load(Rating.class, id);
            HibernateUtil.getSessionFactory().getCurrentSession().delete(rating);

            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }

        return Response.status(200).build();
    }
}
