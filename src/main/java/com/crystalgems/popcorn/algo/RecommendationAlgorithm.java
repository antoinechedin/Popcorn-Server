package com.crystalgems.popcorn.algo;

import com.crystalgems.popcorn.hibernate.HibernateUtil;
import com.crystalgems.popcorn.model.*;

import java.util.*;

/*
 * Created by Antoine on 27/03/2017.
 */
public class RecommendationAlgorithm {

    public static List<ObjectRate<Movie>> getSimilarMoviesFrom(int movieId, int resultLength, double directorWeight, double actorWeight, double genreWeight) {
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

            // Sort recommendation by rate
            movieRecomendationRate.remove(new ObjectRate<>(movie));
            Collections.sort(movieRecomendationRate);

            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        // return only the 'lenght' first
        return movieRecomendationRate.size() > resultLength ? movieRecomendationRate.subList(0, resultLength) : movieRecomendationRate;
    }

    public static List<ObjectRate<Movie>> getUserPersonalRecommendation(int userId, int length, double directorWeight, double genreWeight) {
        double weightSum = directorWeight + genreWeight;
        List<ObjectRate<Movie>> movieRecommendationRatesList = new ArrayList<>();
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            User user = HibernateUtil.getSessionFactory().getCurrentSession().load(User.class, userId);
            List<ObjectRate<Movie>> favouriteMovies = new ArrayList<>();

            // Get favourite movie list
            for (Iterator<Rating> ratingIterator = user.getRatings().iterator(); ratingIterator.hasNext(); ) {
                Rating rating = ratingIterator.next();
                // If the movie is good enought
                if (rating.getRating() >= 4)
                    favouriteMovies.add(new ObjectRate<>(rating.getMovie()));
            }

            // Get Director List
            if (directorWeight != 0) {
                List<ObjectRate<Director>> directorRateList = new ArrayList<>();
                // Iterate favourite movies
                for (int i = 0; i < favouriteMovies.size(); i++) {
                    Movie movie = (Movie) favouriteMovies.get(i).getObject();
                    double localDirectorWeight = directorWeight / (favouriteMovies.size() * movie.getDirectors().size() * weightSum);
                    // Add the directors to the list
                    for (Iterator<Director> directorIterator = movie.getDirectors().iterator(); directorIterator.hasNext(); ) {
                        ObjectRate<Director> directorRate = new ObjectRate<>(directorIterator.next(), localDirectorWeight);
                        if (directorRateList.contains(directorRate))
                            directorRateList.get(directorRateList.indexOf(directorRate)).increaseCounter(localDirectorWeight);
                        else
                            directorRateList.add(directorRate);
                    }
                }
                // Get Movie List from director list
                for (int i = 0; i < directorRateList.size(); i++) {
                    Set<Movie> movieSet = ((Director) directorRateList.get(i).getObject()).getMovies();
                    for (Iterator<Movie> movieIterator = movieSet.iterator(); movieIterator.hasNext(); ) {
                        ObjectRate<Movie> movieRate = new ObjectRate<>(movieIterator.next(), directorRateList.get(i).getRate() / movieSet.size());
                        if (movieRecommendationRatesList.contains(movieRate))
                            movieRecommendationRatesList.get(movieRecommendationRatesList.indexOf(movieRate)).increaseCounter(directorRateList.get(i).getRate() / movieSet.size());
                        else
                            movieRecommendationRatesList.add(movieRate);
                    }
                }
            }


            // Get Genre List
            if (genreWeight != 0) {
                List<ObjectRate<Genre>> genreRateList = new ArrayList<>();
                // Iterate favourite movies
                for (int i = 0; i < favouriteMovies.size(); i++) {
                    Movie movie = (Movie) favouriteMovies.get(i).getObject();
                    double localGenreWeight = genreWeight / (favouriteMovies.size() * movie.getGenres().size() * weightSum);
                    // Add the directors to the list
                    for (Iterator<Genre> genreIterator = movie.getGenres().iterator(); genreIterator.hasNext(); ) {
                        ObjectRate<Genre> genreRate = new ObjectRate<>(genreIterator.next(), localGenreWeight);
                        if (genreRateList.contains(genreRate))
                            genreRateList.get(genreRateList.indexOf(genreRate)).increaseCounter(localGenreWeight);
                        else
                            genreRateList.add(genreRate);
                    }
                }
                // Get Movie List from genre list
                for (int i = 0; i < genreRateList.size(); i++) {
                    Set<Movie> movieSet = ((Genre) genreRateList.get(i).getObject()).getMovies();
                    for (Iterator<Movie> movieIterator = movieSet.iterator(); movieIterator.hasNext(); ) {
                        ObjectRate<Movie> movieRate = new ObjectRate<>(movieIterator.next(), genreRateList.get(i).getRate() / movieSet.size());
                        if (movieRecommendationRatesList.contains(movieRate))
                            movieRecommendationRatesList.get(movieRecommendationRatesList.indexOf(movieRate)).increaseCounter(genreRateList.get(i).getRate() / movieSet.size());
                        else
                            movieRecommendationRatesList.add(movieRate);
                    }
                }
            }
            // Remove and sort final list
            movieRecommendationRatesList.removeAll(favouriteMovies);
            Collections.sort(movieRecommendationRatesList);

            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        return movieRecommendationRatesList.size() > length ? movieRecommendationRatesList.subList(0, length) : movieRecommendationRatesList;
    }

    public static List<ObjectRate<Movie>> getUserSocialRecommendation(int userId, int length, int fidelity) {
        if (fidelity < 0) fidelity = 0;
        if (fidelity > 5) fidelity = 5;
        List<ObjectRate<Movie>> movieRecommendationRatesList = new ArrayList<>();
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

            // Get similar user list
            List<ObjectRate<User>> userList = new ArrayList<>();
            User user = HibernateUtil.getSessionFactory().getCurrentSession().load(User.class, userId);
            for (Iterator<Rating> ratingIterator1 = user.getRatings().iterator(); ratingIterator1.hasNext(); ) {
                Rating rating1 = ratingIterator1.next();
                int score = rating1.getRating();
                Movie movie = rating1.getMovie();
                for (Iterator<Rating> ratingIterator2 = movie.getRatings().iterator(); ratingIterator2.hasNext(); ) {
                    Rating rating2 = ratingIterator2.next();

                    if (Math.abs(rating2.getRating() - score) <= 5 - fidelity && rating2.getUser().getId() != userId) {
                        ObjectRate<User> userRate = new ObjectRate<User>(rating2.getUser(), 1.0 / user.getRatings().size());
                        if (userList.contains(userRate))
                            userList.get(userList.indexOf(userRate)).increaseCounter(1.0 / user.getRatings().size());
                        else
                            userList.add(userRate);

                    }
                }
            }

            Collections.sort(userList);
            if (userList.size() > 5)
                userList = userList.subList(0, 5);

            for (int i = 0; i < userList.size(); i++) {
                for (Iterator<Rating> ratingIterator = ((User) userList.get(i).getObject()).getRatings().iterator(); ratingIterator.hasNext(); ) {
                    Rating rating = ratingIterator.next();
                    if (rating.getRating() == 5) {
                        ObjectRate<Movie> movieRate = new ObjectRate<Movie>(rating.getMovie(), userList.get(i).getRate());
                        if (movieRecommendationRatesList.contains(movieRate))
                            movieRecommendationRatesList.get(movieRecommendationRatesList.indexOf(movieRate)).setRate((movieRecommendationRatesList.get(movieRecommendationRatesList.indexOf(movieRate)).getRate() + 1.0) / 2.0);
                        else
                            movieRecommendationRatesList.add(movieRate);
                    }

                }
            }

            Collections.sort(movieRecommendationRatesList);
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        return movieRecommendationRatesList.size() > length ? movieRecommendationRatesList.subList(0, length) : movieRecommendationRatesList;
    }
}
