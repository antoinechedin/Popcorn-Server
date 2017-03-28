package com.crystalgems.popcorn.algo;

import com.crystalgems.popcorn.hibernate.HibernateUtil;
import com.crystalgems.popcorn.model.Actor;
import com.crystalgems.popcorn.model.Director;
import com.crystalgems.popcorn.model.Genre;
import com.crystalgems.popcorn.model.Movie;

import java.util.*;

/**
 * Created by Antoine on 27/03/2017.
 */
public class RecommendationAlgorithm {

    public static List<ObjectRate<Movie>> getNearMovies(int movieId, int resultLength, double directorWeight, double actorWeight, double genreWeight) {
        List<ObjectRate<Movie>> movieRecomendationRate = new ArrayList<>();
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            double rateSum = directorWeight + actorWeight + genreWeight;
            Movie movie = HibernateUtil.getSessionFactory().getCurrentSession().load(Movie.class, movieId);

            // Director
            if (directorWeight != 0) {
                Set<Director> directorSet = movie.getDirectors();
                directorWeight /= directorSet.size() * rateSum;
                for (Iterator<Director> directorIterator = directorSet.iterator(); directorIterator.hasNext(); ) {
                    Director director = directorIterator.next();
                    for (Iterator<Movie> movieIterator = director.getMovies().iterator(); movieIterator.hasNext(); ) {
                        ObjectRate<Movie> movieIdRate = new ObjectRate<>(movieIterator.next(), directorWeight);
                        if (movieRecomendationRate.contains(movieIdRate))
                            movieRecomendationRate.get(movieRecomendationRate.indexOf(movieIdRate)).increaseCounter(directorWeight);
                        else
                            movieRecomendationRate.add(movieIdRate);
                    }
                }
            }

            // Actor
            if (actorWeight != 0) {
                Set<Actor> actorSet = movie.getActors();
                actorWeight /= actorSet.size() * rateSum;
                for (Iterator<Actor> actorIterator = actorSet.iterator(); actorIterator.hasNext(); ) {
                    Actor actor = actorIterator.next();
                    for (Iterator<Movie> movieIterator = actor.getMovies().iterator(); movieIterator.hasNext(); ) {
                        ObjectRate<Movie> movieIdRate = new ObjectRate<>(movieIterator.next(), actorWeight);
                        if (movieRecomendationRate.contains(movieIdRate))
                            movieRecomendationRate.get(movieRecomendationRate.indexOf(movieIdRate)).increaseCounter(actorWeight);
                        else
                            movieRecomendationRate.add(movieIdRate);
                    }
                }
            }

            // Genre
            if (genreWeight != 0) {
                Set<Genre> genreSet = movie.getGenres();
                genreWeight /= genreSet.size() * rateSum;
                for (Iterator<Genre> genreIterator = genreSet.iterator(); genreIterator.hasNext(); ) {
                    Genre genre = genreIterator.next();
                    for (Iterator<Movie> movieIterator = genre.getMovies().iterator(); movieIterator.hasNext(); ) {
                        ObjectRate<Movie> movieIdRate = new ObjectRate<>(movieIterator.next(), genreWeight);
                        if (movieRecomendationRate.contains(movieIdRate))
                            movieRecomendationRate.get(movieRecomendationRate.indexOf(movieIdRate)).increaseCounter(genreWeight);
                        else
                            movieRecomendationRate.add(movieIdRate);
                    }
                }
            }

            // Sort recommendation
            movieRecomendationRate.remove(new ObjectRate<Movie>(movie));
            Collections.sort(movieRecomendationRate);

            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        return movieRecomendationRate.size() > resultLength ? movieRecomendationRate.subList(0, resultLength - 1) : movieRecomendationRate;
    }
}
