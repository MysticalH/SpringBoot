package by.itstep.demo.Controllers;

import by.itstep.demo.entity.Movie;
import by.itstep.demo.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MovieController {



    MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }


    @RequestMapping("/")
    public String movies(Model model) {      //поменял вместо cat

        List<Movie> movies = movieService.getAll();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping("/addMovie")
    public String addMovie(Model model) {
        model.addAttribute("movie", new Movie());
        return "addmovie";
    }


    @PostMapping("/addMovie")
    public String saveOrUpdate(Movie movie) {
        movieService.saveOrUpdate(movie);
        return "redirect:/";
    }


    @GetMapping("/editMovie")
    public String editMovie(Model model, @RequestParam int id){

        Movie movie = movieService.getById(id);
        model.addAttribute("movie", movie);

        return "addmovie";
    }

    @GetMapping("/deleteMovie")
    public String deleteMovie(Model model, @RequestParam int id){

        movieService.removeById(id);
        //model.addAttribute("movie", movie);

        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchMovie(Model model ,@RequestParam String movieTitle){

        List<Movie> movies = movieService.searchMovies(movieTitle);
        model.addAttribute("movies", movies);
        return "movies";
    }




}

