package com.alex.bookstore.service;

import java.util.Arrays;

import com.alex.bookstore.domain.Categoria;
import com.alex.bookstore.domain.Livro;
import com.alex.bookstore.repositories.CategoriaRepository;
import com.alex.bookstore.repositories.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LivroRepository livroRepository;

    public void instanciaBaseDeDados() {
        Categoria cat1 = new Categoria(null, "Informática", "Livros de IT");
        Categoria cat2 = new Categoria(null, "Biblía", "Livros Da Biblía");
        Categoria cat3 = new Categoria(null, "Java", "Livros relacionados ao Java");

        Livro livro1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem Ipsum", cat1);
        Livro livro2 = new Livro(null, "Revelation", "João", "Fim dos Tempos", cat2);
        Livro livro3 = new Livro(null, "Romanos", "A.P Paulo", "Romanos ..", cat2);
        Livro livro4 = new Livro(null, "Spring Boot", "Desconhecido", "Spring Boot", cat3);
        Livro livro5 = new Livro(null, "Android", "Desconhecido", "Java For Android", cat3);

        cat1.getLivros().addAll(Arrays.asList(livro1));
        cat2.getLivros().addAll(Arrays.asList(livro2, livro3));
        cat3.getLivros().addAll(Arrays.asList(livro4, livro5));

        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        this.livroRepository.saveAll(Arrays.asList(livro1, livro2, livro3, livro4, livro5));
    }
}
