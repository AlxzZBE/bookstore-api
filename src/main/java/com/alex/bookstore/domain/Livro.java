package com.alex.bookstore.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter @Setter
public class Livro {
    
    private Integer id;

    private String titulo;
    private String name_autor;
    private String text;

    private Categoria categoria;

    public Livro() {
        super();
    }

    public Livro(Integer id, String titulo, String name_autor, String text, Categoria categoria) {
        super();
        this.id = id;
        this.titulo = titulo;
        this.name_autor = name_autor;
        this.text = text;
    }

}
