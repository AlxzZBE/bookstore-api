package com.alex.bookstore.dtos;

import com.alex.bookstore.domain.Livro;
import lombok.Getter;
import java.io.Serializable;

@Getter
public class LivroDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String titulo;
    private String name_autor;
    private String text;

    public LivroDTO() {
        super();
    }

    public LivroDTO(Livro obj) {
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
        this.name_autor = obj.getName_autor();
        this.text = obj.getText();
    }
}
