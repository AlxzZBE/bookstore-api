package com.alex.bookstore.resources;

import com.alex.bookstore.domain.Livro;
import com.alex.bookstore.dtos.LivroDTO;
import com.alex.bookstore.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

    @Autowired
    private LivroService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<LivroDTO> findById(@PathVariable Integer id) {
        Livro obj = service.findById(id);
        LivroDTO livroDTO = Stream.of(obj).map(LivroDTO::new).findFirst().get();
        return ResponseEntity.ok().body(livroDTO);
    }

}
