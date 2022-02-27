package com.alex.bookstore.dtos;

import com.alex.bookstore.domain.Categoria;
import lombok.Getter;
import java.io.Serializable;

@Getter
public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String desc;

    public CategoriaDTO() {
        super();
    }

    public CategoriaDTO(Categoria obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.desc = obj.getDesc();
    }
}
