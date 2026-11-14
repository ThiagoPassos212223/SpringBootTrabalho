package com.example.demo.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;

@Getter 
@Setter 
@Entity 
@Table(name="autor")
public class Autor {
    @Id 
    @GeneratedValue
    private Long id;

    private String nome;
    private String nacionalidade;

    @ManyToMany(mappedBy = "autores")
    @JsonIgnore
    private Set<Livro> livros = new HashSet<>();
}
