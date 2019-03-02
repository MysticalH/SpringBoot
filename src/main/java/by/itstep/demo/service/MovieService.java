package by.itstep.demo.service;

import by.itstep.demo.entity.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {

    List<Movie> getAll();

    void saveOrUpdate(Movie movie);

    Movie getById(int id);

    void removeById(int id);

    List<Movie> searchMovies(String title);



}
