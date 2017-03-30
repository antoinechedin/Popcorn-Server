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
public class AgeService {
    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Path("get/age-list")
    public Object[] getAgeList() {
        Object[] age;
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            age = HibernateUtil.getSessionFactory().getCurrentSession().createQuery("from Age A").list().toArray();
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        return age;
    }
}
