package com.practica.relations.controllers;
import com.practica.relations.models.ClassAuthor;
import com.practica.relations.models.ClassBook;
import com.practica.relations.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/index")
public class Controller {
    @Autowired
    private ClassService service;

    //GET
    @GetMapping("/books")
    public List<ClassBook> books(){
    return service.showBooks();
    }
    @GetMapping("/author")
    public List<ClassAuthor> author(){
        return service.showAuthor();
    }


    //CREATE & UPDATE
    @PostMapping("/create-book")
    public ClassBook creBook(@RequestBody ClassBook book){
        return service.creaBook(book);
    }
    @PostMapping("/create-author")
    public ClassAuthor creAuthor(@RequestBody ClassAuthor author){
        return service.creaAuthor(author);
    }

    //DELETE
    @DeleteMapping("book/{id}")
    public void deleteBook(@PathVariable Long id){
        Optional<ClassBook> book = service.getBookById(id);

        if (book.isPresent()) {
            book.get().getAuthorsList().forEach(author -> service.deleteAuthorById(author.getId()));

            service.deleteBookById(id);
        }
    }
    @DeleteMapping("author/{id}")
    public void deleteAut(@PathVariable Long id){
        service.deleteAuthorById(id);
    }

    //GET  BY ID
    @GetMapping("getb/{id}")
    public Optional<ClassBook> bookfind(@PathVariable Long id){
        return service.getBookById(id);
    }
    @GetMapping("geta/{id}")
    public Optional<ClassAuthor> authorfind(@PathVariable Long id){
        return service.getAuthorById(id);
    }

    //CREATE
    @GetMapping("/create")
    public void create(){
        service.createBook();
    }

}
