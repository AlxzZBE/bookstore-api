package com.alex.bookstore.service;

import com.alex.bookstore.domain.Livro;
import com.alex.bookstore.repositories.LivroRepository;
import com.alex.bookstore.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro findById(Integer id) {
        Optional<Livro> obj = livroRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Livro Não Encontrado! id: " + id));
    }
}
