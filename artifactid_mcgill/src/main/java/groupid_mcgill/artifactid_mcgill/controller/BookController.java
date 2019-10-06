package groupid_mcgill.artifactid_mcgill.controller;

import groupid_mcgill.artifactid_mcgill.model.Book;
import groupid_mcgill.artifactid_mcgill.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public String getBookList(Model model){
        List<Book> books=bookService.getAll();
        model.addAttribute("books",books);
        return "book";
    }

    @PostMapping("/books/save")
    public String saveBook(Book book, Model model){
        bookService.saveBook(book);

        List<Book> books = bookService.getAll();
        model.addAttribute("books",books);
        return "book";
    }

    @GetMapping("/books/add")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        return "book-add";
    }

    @GetMapping("/books/edit/{isbn}")
    public String getBookForUpdate(@PathVariable String isbn, Model model){
        Book currentBook = bookService.findById(isbn);
        model.addAttribute("book",currentBook);
        return "book-edit";
    }

    @PostMapping("/books/update/{isbn}")
    public String updateBook(@PathVariable String isbn, Book book, Model model){
        bookService.updateBook(book);
        List<Book> books = bookService.getAll();
        model.addAttribute("books",books);
        return "book";
    }

    @GetMapping("/books/delete/{isbn}")
    public String deleteBook(@PathVariable String isbn, Model model){
        Book currentBook = bookService.findById(isbn);
        bookService.deleteBook(currentBook);

        List<Book> books = bookService.getAll();
        model.addAttribute("books",books);
        return "book";
    }
}
