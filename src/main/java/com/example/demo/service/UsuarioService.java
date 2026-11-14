package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class UsuarioService{
    private  final UsuarioRepository UsuarioRepository;

    public List<Usuario> listarTodos(){
        return UsuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id){
        return UsuarioRepository.findById(id);
    }

    public Usuario salvar(Usuario autor){
        return UsuarioRepository.save(autor);
    }

    public Usuario atualizar(Long id, Usuario autor){
        autor.setId(id);
        return UsuarioRepository.save(autor);
    }

    public void deletar(Long id){
        UsuarioRepository.deleteById(id);
    }
}
