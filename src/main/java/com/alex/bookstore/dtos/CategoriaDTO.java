package com.alex.bookstore.dtos;

import com.alex.bookstore.domain.Categoria;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Campo NOME é Requirido!")
    @Length(min = 3, max = 100, message = "O campo NOME deve ter entre 3 e 100 caracteres")
    private String name;

    @NotEmpty(message = "Campo DESCRIÇÂO é Requirido!")
    @Length(min = 10, max = 400, message = "o campo DESCRÇÂO deve ter entre 10 e 400 caracteres")
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
