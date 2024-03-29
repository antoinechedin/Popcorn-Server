package com.crystalgems.popcorn.sevices;

import com.crystalgems.popcorn.hibernate.HibernateUtil;
import com.crystalgems.popcorn.model.Age;
import com.crystalgems.popcorn.model.Gender;
import com.crystalgems.popcorn.model.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
            user = (User) HibernateUtil.getSessionFactory().getCurrentSession().createQuery("from User U where U.id = " + id).uniqueResult();
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        return user;
    }

    @GET
    @Path("get/user-login")
    public User getUserByLogin(@QueryParam("login") String userLogin) {
        User user;
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            user = (User) HibernateUtil.getSessionFactory().getCurrentSession().createQuery("from User U where U.login = '" + userLogin + "'").uniqueResult();
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        return user;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Path("update/user")
    public Response updateUser(User userToUpdate) {

        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            User user = HibernateUtil.getSessionFactory().getCurrentSession().load(User.class, userToUpdate.getId());

            if(userToUpdate.getAge() != null) {
                user.setAge(userToUpdate.getAge());
            }
            if(!userToUpdate.getLogin().equals("")) {
                user.setLogin(userToUpdate.getLogin());
            }
            if(userToUpdate.getGender() != null) {
                user.setGender(userToUpdate.getGender());
            }
            if(!userToUpdate.getPassword().equals(DigestUtils.sha1Hex(""))) {
                user.setPassword(userToUpdate.getPassword());
            }
            HibernateUtil.getSessionFactory().getCurrentSession().update(user);
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();

        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }

        return Response.status(200).build();
    }

    @POST
    @Path("create/user")
    public Response createUser(@QueryParam("login") String login, @QueryParam("password") String password,
                               @QueryParam("gender") int genderId, @QueryParam("age") int ageId) {

        User user = new User();


        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

            Gender gender = (Gender) HibernateUtil.getSessionFactory().getCurrentSession().createQuery("from Gender G where G.id = " + genderId).uniqueResult();
            Age age = (Age) HibernateUtil.getSessionFactory().getCurrentSession().createQuery("from Age A where A.id = " + ageId).uniqueResult();

            user.setLogin(login);
            user.setPassword(password);
            user.setGender(gender);
            user.setAge(age);

            HibernateUtil.getSessionFactory().getCurrentSession().save(user);

            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }

        return Response.status(201).build();
    }

    @PUT
    @Path("delete/user")
    public Response deleteUser(@QueryParam("id") int id) {

        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

            User user = HibernateUtil.getSessionFactory().getCurrentSession().load(User.class, id);
            user.setLogin("");
            user.setPassword(DigestUtils.sha1Hex(""));
            HibernateUtil.getSessionFactory().getCurrentSession().save(user);

            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }

        return Response.status(200).build();
    }
}
