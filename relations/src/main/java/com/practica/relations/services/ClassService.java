package com.practica.relations.services;

import com.practica.relations.models.ClassAuthor;
import com.practica.relations.models.ClassBook;
import com.practica.relations.repository.RepositoryAuthor;
import com.practica.relations.repository.RepositoryBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClassService {
    @Autowired
    private RepositoryBook repoBook;
    @Autowired
    private RepositoryAuthor repoAuthor;

    //VER BOOK & AUTHOR
    public List<ClassBook> showBooks(){
        return repoBook.findAll();
    }
    public List<ClassAuthor> showAuthor(){
        return repoAuthor.findAll();
    }

    //CREATE
    public ClassBook creaBook(ClassBook book){
        return repoBook.save(book);
    }
    public ClassAuthor creaAuthor(ClassAuthor author) {
        return repoAuthor.save(author);
    }

    //DELETE
    public void deleteBookById(Long id) {
        repoBook.deleteById(id);
    }

    public void deleteAuthorById(Long id) {
        repoAuthor.deleteById(id);
    }

    //FIND BY ID
    public Optional<ClassBook> getBookById(Long id){
        return repoBook.findById(id);
    }
    public Optional<ClassAuthor> getAuthorById(Long id){
        return repoAuthor.findById(id);
    }

    //CREATE
    public void createBook()
    {
        ClassBook book1 = new ClassBook();
        book1.setName("7 Habitos de la gente altamente efectiva");

        ClassBook book2 = new ClassBook();
        book2.setName("Hábitos atómicos");

        ClassAuthor autor1 =new ClassAuthor();
        autor1.setName("Stephen Covey");

        ClassAuthor autor2 =new ClassAuthor();
        autor2.setName("James Clear");

        repoBook.save(book1);
        repoBook.save(book2);

        List<ClassBook> listBook1 = new ArrayList<>();
        listBook1.add(book1);
        listBook1.add(book2);
        autor1.setBooksList(listBook1);

        List<ClassAuthor> listAuthors = new ArrayList<>();
        listAuthors.add(autor1);
        listAuthors.add(autor2);
        book1.setAuthorsList(listAuthors);

        repoAuthor.save(autor1);
        repoAuthor.save(autor2);
    }



}
