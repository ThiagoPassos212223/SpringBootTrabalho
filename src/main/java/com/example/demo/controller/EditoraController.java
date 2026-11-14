package com.example.demo.controller;

import com.example.demo.model.Editora;
import com.example.demo.service.EditoraService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editoras")
@RequiredArgsConstructor
public class EditoraController {

    private final EditoraService editoraService;

    @GetMapping
    public List<Editora> listarTodas() {
        return editoraService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Editora> buscarPorId(@PathVariable Long id) {
        return editoraService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Editora> salvar(@RequestBody Editora editora) {
        Editora novaEditora = editoraService.salvar(editora);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEditora);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Editora> atualizar(@PathVariable Long id, @RequestBody Editora editora) {
        if (editoraService.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Editora atualizada = editoraService.atualizar(id, editora);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (editoraService.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        editoraService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}