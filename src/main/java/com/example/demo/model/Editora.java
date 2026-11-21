package com.example.demo.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
@Entity 
@Table(name="editora")
public class Editora {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String estado;
    private String cidade;

    // associação 1 para N
    @OneToMany(mappedBy = "editora", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Livro> livros = new HashSet<>();


}
