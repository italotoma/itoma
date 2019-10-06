package groupid_mcgill.artifactid_mcgill.service;

import groupid_mcgill.artifactid_mcgill.model.Book;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BookService {
    List<Book> books = new ArrayList<>(
            Arrays.asList(
                    new Book("978-612-47870-5-8","Saint-Exupéry, Antoine de","El principito", LocalDate.now(),87,"Español"),
                    new Book("978-612-4181-40-5","Tolkien, J. R. R","El señor de los anillos", LocalDate.now(),455,"Español")
            )
    );

    public List<Book> getAll() {return books;}

    public void saveBook(Book book){books.add(book);}

    public void deleteBook(Book book) {books.remove(book);}

    public Book findById(String isbn){
        Book book = books.stream()
                .filter(s -> s.getIsbn()
                        .equalsIgnoreCase(isbn))
                .findFirst()
                .orElseGet(null);
        return book;
    }

    public void updateBook(Book book){
        Book currentBook = findById(book.getIsbn());
        int index = books.indexOf(currentBook);
        book.setIsbn(currentBook.getIsbn());
        books.set(index,book);
    }
}
