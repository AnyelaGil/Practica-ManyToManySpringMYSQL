package com.practica.relations.repository;

import com.practica.relations.models.ClassBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryBook extends JpaRepository<ClassBook,Long> {
}
