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
import java.util.stream.Stream;

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
        List<Livro> livrosSorted =
                categoria.getLivros().stream().sorted(Comparator.comparing(Livro::getTitulo)).toList();
        return livrosSorted;
    }

    public Livro update(Integer id, Livro obj) {
        Livro newObj = findById(id);
        updateData(newObj, obj);
        return livroRepository.save(newObj);
    }

    private void updateData(Livro newObj, Livro obj) {
        if (obj.getTitulo() != null)
            newObj.setTitulo(obj.getTitulo());
        if (obj.getName_autor() != null)
            newObj.setName_autor(obj.getName_autor());
        if (obj.getText() != null)
            newObj.setText(obj.getText());
    }
}
