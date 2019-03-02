package by.itstep.demo.service;

import by.itstep.demo.entity.Movie;
import by.itstep.demo.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.getAll();
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        movieRepository.saveOrUpdate(movie);
    }

    @Override
    public Movie getById(int id) {
        return movieRepository.getById(id);
    }

    @Override
    public void removeById(int id) {
        movieRepository.removeById(id);
    }

    @Override
    public List<Movie> searchMovies(String title) {
        return movieRepository.searchMovies(title);
    }


}
