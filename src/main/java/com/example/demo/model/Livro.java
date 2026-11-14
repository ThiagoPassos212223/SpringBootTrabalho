package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Setter;
import lombok.Getter;


@Getter
@Setter 
@Entity 
@Table(name="livros")
public class Livro {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String isbn;

    // Associação 1 para N
    @ManyToOne
    @JoinColumn(name = "editora_id")
    private Editora editora;

    @ManyToMany 
    @JoinTable (
        name="livros_autor",
        joinColumns = @JoinColumn(name="livro_id"),
        inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private Set<Autor> autores = new HashSet<>();
}
