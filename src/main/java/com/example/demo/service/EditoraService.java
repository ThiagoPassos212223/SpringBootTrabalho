package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Editora;
import com.example.demo.repository.EditoraRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class EditoraService{
    private  final EditoraRepository editoraRepository;

    public List<Editora> listarTodos(){
        return editoraRepository.findAll();
    }

    public Optional<Editora> buscarPorId(Long id){
        return editoraRepository.findById(id);
    }

    public Editora salvar(Editora autor){
        return editoraRepository.save(autor);
    }

    public Editora atualizar(Long id, Editora autor){
        autor.setId(id);
        return editoraRepository.save(autor);
    }

    public void deletar(Long id){
        editoraRepository.deleteById(id);
    }
}
