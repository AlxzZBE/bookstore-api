package com.alex.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Entity
public class Livro implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Campo TITULO é Requirido!")
    @Length(min = 3, max = 50, message = "O campo NOME deve ter entre 3 e 50 caracteres")
    private String titulo;

    @NotEmpty(message = "Campo NOME DO AUTOR é Requirido!")
    @Length(min = 3, max = 50, message = "O campo NOME deve ter entre 3 e 50 caracteres")
    private String name_autor;

    @NotEmpty(message = "Campo TEXT é Requirido!")
    @Length(min = 10, max = 2000000, message = "O campo TEXT deve ter entre 3 e 2.000.000 caracteres")
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
