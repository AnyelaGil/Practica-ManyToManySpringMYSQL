package com.practica.relations.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Data
@Entity
@Table(name = "book")
public class ClassBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    @Getter @Setter
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "booksList")
    @JsonIgnore
    @Getter @Setter
    private List<ClassAuthor> authorsList;

}
