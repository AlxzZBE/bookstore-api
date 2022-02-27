package com.alex.bookstore.service;

import com.alex.bookstore.domain.Categoria;
import com.alex.bookstore.dtos.CategoriaDTO;
import com.alex.bookstore.repositories.CategoriaRepository;
import com.alex.bookstore.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    public Categoria update;
    @Autowired
    private CategoriaRepository repository;

    public Categoria findById(Integer id) {
        Optional<Categoria> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria create(Categoria obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Categoria update(Integer id, CategoriaDTO objDTO) {
        Categoria obj = findById(id);

        obj.setName(objDTO.getName());
        obj.setDesc(objDTO.getDesc());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
