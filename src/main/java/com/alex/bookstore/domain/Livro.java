package com.alex.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Livro implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String name_autor;
    private String text;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
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
        this.categoria = categoria;
    }

}
