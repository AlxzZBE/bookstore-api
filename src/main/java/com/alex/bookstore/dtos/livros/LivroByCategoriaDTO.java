package com.alex.bookstore.dtos.livros;

import com.alex.bookstore.domain.Livro;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class LivroByCategoriaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String titulo;

    public LivroByCategoriaDTO() {
        super();
    }

    public LivroByCategoriaDTO(Livro obj) {
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
    }
}
