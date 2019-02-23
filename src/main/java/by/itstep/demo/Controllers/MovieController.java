package by.itstep.demo.Controllers;

import by.itstep.demo.entity.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MovieController {

    @RequestMapping("/")
    public String index() {

        return "index";
    }


    @RequestMapping("/cat")
    public String cat(Model model) {

        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Taxi", "1998", "Luc Besson", "Comedy"));
        movies.add(new Movie("The Matrix", "1999", "The Wachowski Brothers", "Action"));
        movies.add(new Movie("Dumb and Dumber", "1994", "Peter Farnelli", "Comedy"));

        model.addAttribute("movies", movies);

        return "movies";
    }

    @GetMapping("/addMovie")
    public String addmovie(Model model) {
        model.addAttribute("movie", new Movie());
        return "index";
    }

    @ResponseBody
    @PostMapping("/addMovie")
    public String addmovie(Movie movie) {
        return movie.toString();
    }
}

