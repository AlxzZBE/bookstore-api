package com.alex.bookstore.domain;

import java.util.List;
import java.util.ArrayList;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter @Setter
public class Categoria {

    private Integer id;
    private String name;
    private String desc;

    private List<Livro> livros = new ArrayList<>();

    public Categoria() {
        super();
    }

    public Categoria(Integer id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

}
