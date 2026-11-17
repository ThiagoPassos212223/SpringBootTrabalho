package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Aluno;
import com.example.demo.repository.AlunoRepository;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public List<Aluno> listarTodos(){
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarPorId(Long id){
        return alunoRepository.findById(id);
    }

    public Aluno salvar(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public Aluno atualizar(Long id, Aluno aluno){
        aluno.setId(id);
        return alunoRepository.save(aluno);
    }

    public void deletar(Long id){
        alunoRepository.deleteById(id);
    }
}