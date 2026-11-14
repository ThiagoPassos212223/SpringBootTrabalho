package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Livro;
import com.example.demo.repository.LivroRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class LivroService{
    private  final LivroRepository livroRepository;

    public List<Livro> listarTodos(){
        return livroRepository.findAll();
    }

    public Optional<Livro> buscarPorId(Long id){
        return livroRepository.findById(id);
    }

    public Livro salvar(Livro autor){
        return livroRepository.save(autor);
    }

    public Livro atualizar(Long id, Livro autor){
        autor.setId(id);
        return livroRepository.save(autor);
    }

    public void deletar(Long id){
        livroRepository.deleteById(id);
    }
}
