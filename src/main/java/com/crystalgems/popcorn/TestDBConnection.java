package com.crystalgems.popcorn;

import com.crystalgems.popcorn.model.Movies;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Antoine on 03/03/2017.
 */
public class TestDBConnection {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            List movieLists = session.createQuery("from Movies").list();
            for (Iterator iterator = movieLists.iterator(); iterator.hasNext(); ) {
                Movies movies = (Movies) iterator.next();
                System.out.println(movies.getTitleImdb() + ":" + movies.getDate().toString());
            }
        } finally {
            session.close();
        }
    }
}