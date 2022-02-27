package com.alex.bookstore.service;

import com.alex.bookstore.domain.Categoria;
import com.alex.bookstore.domain.Livro;
import com.alex.bookstore.repositories.LivroRepository;
import com.alex.bookstore.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaService categoriaService;

    public Livro findById(Integer id) {
        Optional<Livro> obj = livroRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Livro Não Encontrado! id: " + id));
    }

    public List<Livro> findAll(Integer id_cat) {
        categoriaService.findById(id_cat);

        return livroRepository.findAll();
    }

    public List<Livro> findAllByCategoriaOrderByTitle(Integer id) {
        Categoria categoria = categoriaService.findById(id);
        List<Livro> livrosSorted = categoria.getLivros().stream().sorted(Comparator.comparing(Livro::getTitulo)).toList();
        return livrosSorted;
    }
}
