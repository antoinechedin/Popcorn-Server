package com.crystalgems.popcorn.sevices;

import com.crystalgems.popcorn.hibernate.HibernateUtil;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by valentin on 30/03/2017.
 */
@Path("")
public class GenderService {

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Path("get/gender-list")
    public Object[] getGenderList() {
        Object[] gender;
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            gender = HibernateUtil.getSessionFactory().getCurrentSession().createQuery("from Gender M").list().toArray();
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        return gender;
    }
}
