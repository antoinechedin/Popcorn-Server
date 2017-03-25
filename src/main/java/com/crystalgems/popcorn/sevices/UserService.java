package com.crystalgems.popcorn.sevices;

import com.crystalgems.popcorn.hibernate.HibernateUtil;
import com.crystalgems.popcorn.model.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by Antoine on 25/03/2017.
 */
@Path("")
public class UserService {

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Path("get/user")
    public User getUserById(@QueryParam("id") int id) {
        User user;
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            user = (User) HibernateUtil.getSessionFactory().getCurrentSession().createQuery("from User U where U.userId = " + id).uniqueResult();
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        return user;
    }
}
