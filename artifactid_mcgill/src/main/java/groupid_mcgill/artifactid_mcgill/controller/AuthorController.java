package groupid_mcgill.artifactid_mcgill.controller;

import groupid_mcgill.artifactid_mcgill.model.Author;
import groupid_mcgill.artifactid_mcgill.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping("/authors")
    public String getAuthorList(Model model){
        List<Author> authors=authorService.getAll();
        model.addAttribute("authors",authors);
        return "author";
    }

    @PostMapping("/authors/save")
    public String saveAuthor(Author author, Model model){
        authorService.saveAuthor(author);

        List<Author> authors = authorService.getAll();
        model.addAttribute("authors",authors);
        return "author";
    }

    @GetMapping("/authors/add")
    public String addAuthor(Model model){
        model.addAttribute("author", new Author());
        return "author-add";
    }

    @GetMapping("/authors/edit/{dni}")
    public String getAuthorForUpdate(@PathVariable String dni, Model model){
        Author currentAuthor = authorService.findById(dni);
        model.addAttribute("author",currentAuthor);
        return "author-edit";
    }

    @PostMapping("/authors/update/{dni}")
    public String updateAuthor(@PathVariable String dni, Author author, Model model){
        authorService.updateAuthor(author);
        List<Author> authors = authorService.getAll();
        model.addAttribute("authors",authors);
        return "author";
    }

    @GetMapping("/authors/delete/{dni}")
    public String deleteAuthor(@PathVariable String dni, Model model){
        Author currentAuthor = authorService.findById(dni);
        authorService.deleteAuthor(currentAuthor);

        List<Author> authors = authorService.getAll();
        model.addAttribute("authors",authors);
        return "author";
    }






















}
