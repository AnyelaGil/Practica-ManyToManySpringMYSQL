package com.practica.relations.repository;

import com.practica.relations.models.ClassAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryAuthor extends JpaRepository<ClassAuthor,Long> {

}
