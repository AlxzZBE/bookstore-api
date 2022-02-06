package com.alex.bookstore.service;

import com.alex.bookstore.domain.Categoria;
import com.alex.bookstore.repositories.CategoriaRepository;
import com.alex.bookstore.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria findById(Integer id) {
        Optional<Categoria> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado id: " + id + ", Tipo: " + Categoria.class.getName()));
    }
}
