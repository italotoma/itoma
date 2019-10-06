package groupid_mcgill.artifactid_mcgill.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
    private String isbn;
//    private List<Author> authors;
    private String title;
    private String summary;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publicationDate;
    private Integer numberOfPages;
    private String language;
}
