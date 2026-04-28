package com.fiap.sprint1.backend_consultas.controller;

import com.fiap.sprint1.backend_consultas.model.Ocorrencia;
import com.fiap.sprint1.backend_consultas.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ocorrencias")
public class OcorrenciaController {

    @Autowired
    private OcorrenciaService service;

    @PostMapping
    public ResponseEntity<Ocorrencia> criar(@RequestBody Ocorrencia ocorrencia) {
        Ocorrencia novaOcorrencia = service.criar(ocorrencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaOcorrencia);
    }

    @GetMapping
    public ResponseEntity<List<Ocorrencia>> listar() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ocorrencia> buscarPorId(@PathVariable Long id) {
        Optional<Ocorrencia> ocorrencia = service.buscarPorId(id);
        return ocorrencia.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ocorrencia> atualizar(@PathVariable Long id, @RequestBody Ocorrencia ocorrencia) {
        Ocorrencia ocorrenciaAtualizada = service.atualizar(id, ocorrencia);
        if (ocorrenciaAtualizada != null) {
            return ResponseEntity.ok(ocorrenciaAtualizada);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.deletar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}