package com.alex.bookstore;

import java.util.Arrays;

import com.alex.bookstore.domain.Categoria;
import com.alex.bookstore.domain.Livro;
import com.alex.bookstore.repositories.CategoriaRepository;
import com.alex.bookstore.repositories.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class BookstoreApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática", "Livros de IT");
		
		Livro livro1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem Ipsum", cat1);
		
		cat1.getLivros().addAll(Arrays.asList(livro1));

		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(livro1));
	}

}
