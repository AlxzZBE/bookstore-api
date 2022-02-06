package com.alex.bookstore.domain;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter @Setter
@Entity
public class Categoria implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String desc;

    @JsonIgnoreProperties("categoria")
    @OneToMany(mappedBy = "categoria")
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
