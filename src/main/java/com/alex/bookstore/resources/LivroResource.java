package com.alex.bookstore.resources;

import com.alex.bookstore.domain.Livro;
import com.alex.bookstore.dtos.livros.LivroByCategoriaDTO;
import com.alex.bookstore.dtos.livros.LivroDTO;
import com.alex.bookstore.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
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

    @GetMapping(value = "/categoria/{id}")
    public ResponseEntity<List<LivroByCategoriaDTO>> findAllByCategoriaOrderByTitle(@PathVariable Integer id) {
        List<Livro> list = service.findAllByCategoriaOrderByTitle(id);
        List<LivroByCategoriaDTO> listDTO = list.stream().map(LivroByCategoriaDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<LivroDTO> update(@PathVariable Integer id, @RequestBody Livro obj){
        Livro newObj = service.update(id, obj);
        LivroDTO livroDTO = Stream.of(newObj).map(LivroDTO::new).findFirst().get();
        return ResponseEntity.ok().body(livroDTO);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<LivroDTO> updatePatch(@PathVariable Integer id, @RequestBody Livro obj){
        Livro newObj = service.update(id, obj);
        LivroDTO livroDTO = Stream.of(newObj).map(LivroDTO::new).findFirst().get();
        return ResponseEntity.ok().body(livroDTO);
    }

}
