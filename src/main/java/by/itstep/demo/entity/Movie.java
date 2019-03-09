package by.itstep.demo.entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Movie {

// OmdbApi omdb = new OmdbApi("468594f3");

    Integer id;
    String title;
    String date;
    String author;
    String genre;

}
