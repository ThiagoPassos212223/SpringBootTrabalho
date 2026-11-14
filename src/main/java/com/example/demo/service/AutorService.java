package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Autor;
import com.example.demo.repository.AutorRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class AutorService{
    private  final AutorRepository autorRepository;

    public List<Autor> listarTodos(){
        return autorRepository.findAll();
    }

    public Optional<Autor> buscarPorId(Long id){
        return autorRepository.findById(id);
    }

    public Autor salvar(Autor autor){
        return autorRepository.save(autor);
    }

    public Autor atualizar(Long id, Autor autor){
        autor.setId(id);
        return autorRepository.save(autor);
    }

    public void deletar(Long id){
        autorRepository.deleteById(id);
    }
}
