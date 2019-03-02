package by.itstep.demo.repository;

import by.itstep.demo.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieOnMemoryRepository implements MovieRepository {

    int index;  //добавление id фильма
    List<Movie> movies = new ArrayList<>();

    public MovieOnMemoryRepository() {


        movies.add(new Movie(1, "Taxi", "1998", "Luc Besson", "Comedy"));
        movies.add(new Movie(2, "The Matrix", "1999", "The Wachowski Brothers", "Action"));
        movies.add(new Movie(3, "Dumb and Dumber", "1994", "Peter Farnelli", "Comedy"));
        index = 3;
    }

    @Override
    public List<Movie> getAll() {

        return movies;
    }


    @Override
    public void saveOrUpdate(Movie movie) {

        if (movie.getId() == null) {
            movie.setId(index + 1);
            index = index + 1;
            movies.add(movie);
        } else {
            removeById(movie.getId());
            movies.add(movie);

        }
    }

    @Override
    public Movie getById(int id) {

        for (Movie movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    @Override
    public void removeById(int id) {
        for (int i = 0; i< movies.size(); i++) {
            if (movies.get(i).getId()== id) {

                movies.remove(i);
                return;
            }
        }

    }


    @Override
    public List<Movie> searchMovies(String title) {
        List<Movie> foundedMovies = new ArrayList<>();
        for (Movie movie: movies) {
            if (movie.getTitle().equals(title)){
                foundedMovies.add(movie);
            }
        }
        return foundedMovies;
    }


}
