package com.alex.bookstore.repositories;

import com.alex.bookstore.domain.Livro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{
    
}
