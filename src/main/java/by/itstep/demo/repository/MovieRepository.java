package by.itstep.demo.repository;

import by.itstep.demo.entity.Movie;

import java.util.List;

public interface MovieRepository {

    List<Movie> getAll();

    void saveOrUpdate(Movie movie);

    Movie getById(int id);

    void removeById(int id);

    List<Movie> searchMovies(String title);
}
