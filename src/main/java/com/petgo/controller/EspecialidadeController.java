package com.petgo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petgo.entities.Especialidade;
import com.petgo.service.EspecialidadeService;

@RestController
@RequestMapping("/Especialidade")
@CrossOrigin(origins = "*")
public class EspecialidadeController {
    private final EspecialidadeService EspecialidadeService;

    @Autowired
    public EspecialidadeController(EspecialidadeService EspecialidadeService) {
        this.EspecialidadeService = EspecialidadeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidade> buscaEspecialidadeControlId(@PathVariable long id) {
        Especialidade Especialidade = EspecialidadeService.buscaEspecialidadePeloId(id);
        if (Especialidade != null) {
            return ResponseEntity.ok(Especialidade);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Especialidade>> buscaTodosEspecialidadesControl() {
        List<Especialidade> Especialidades = EspecialidadeService.buscaTodosEspecialidades();
        return ResponseEntity.ok(Especialidades);
    }

    @PostMapping("/")
    public ResponseEntity<Especialidade> salvaEspecialidadeControl(@RequestBody Especialidade Especialidade) {
        Especialidade salvaEspecialidade = EspecialidadeService.salvaEspecialidade(Especialidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvaEspecialidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Especialidade> alteraEspecialidadeControl(@PathVariable Long id, @RequestBody Especialidade Especialidade) {
        Especialidade alteraEspecialidade = EspecialidadeService.alterarEspecialidade(id, Especialidade);
        if (alteraEspecialidade != null) {
            return ResponseEntity.ok(Especialidade);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> apagaEspecialidadeControl(@PathVariable Long id) {
        boolean apagar = EspecialidadeService.apagarEspecialidade(id);
        if (apagar) {
        	 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
