package groupid_mcgill.artifactid_mcgill.service;

import groupid_mcgill.artifactid_mcgill.model.Author;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AuthorService {
    List<Author> authors = new ArrayList<>(
            Arrays.asList(
                new Author("46136330","FLOR MARIA","MEDINA","POMA",30,"Biografía de Flor"),
                new Author("41985117","LUIS FELIPE","MEJIA","QUIÑONEZ",36,"Biografía de Luis")

            )
    );

    public List<Author> getAll() {return authors;}

    public void saveAuthor(Author author){authors.add(author);}

    public void deleteAuthor(Author author) {authors.remove(author);}

    public Author findById(String dni){
        Author author = authors.stream()
                .filter(s -> s.getDni()
                        .equalsIgnoreCase(dni))
                .findFirst()
                .orElseGet(null);
        return author;
    }

    public void updateAuthor(Author author){
        Author currentAuthor = findById(author.getDni());
        int index = authors.indexOf(currentAuthor);
        author.setDni(currentAuthor.getDni());
        authors.set(index,author);
    }
}
