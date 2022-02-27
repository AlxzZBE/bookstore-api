package com.alex.bookstore.dtos.livros;

import com.alex.bookstore.domain.Livro;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
public class LivroDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Campo TITULO é Requirido!")
    @Length(min = 3, max = 50, message = "O campo NOME deve ter entre 3 e 50 caracteres")
    private String titulo;

    @NotEmpty(message = "Campo NOME DO AUTOR é Requirido!")
    @Length(min = 3, max = 50, message = "O campo NOME deve ter entre 3 e 50 caracteres")
    private String name_autor;

    @NotEmpty(message = "Campo TEXT é Requirido!")
    @Length(min = 20, max = 200000, message = "O campo TEXT deve ter entre 3 e 2.000.000 caracteres")
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
