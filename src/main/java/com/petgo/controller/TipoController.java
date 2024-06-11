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

import com.petgo.entities.Tipo;
import com.petgo.service.TipoService;

@RestController
@RequestMapping("/Tipo")
@CrossOrigin(origins = "*")
public class TipoController {
    private final TipoService TipoService;

    @Autowired
    public TipoController(TipoService TipoService) {
        this.TipoService = TipoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tipo> buscaTipoControlId(@PathVariable long id) {
        Tipo Tipo = TipoService.buscaTipoPeloId(id);
        if (Tipo != null) {
            return ResponseEntity.ok(Tipo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Tipo>> buscaTodosTiposControl() {
        List<Tipo> Tipos = TipoService.buscaTodosTipos();
        return ResponseEntity.ok(Tipos);
    }

    @PostMapping("/")
    public ResponseEntity<Tipo> salvaTipoControl(@RequestBody Tipo Tipo) {
        Tipo salvaTipo = TipoService.salvaTipo(Tipo);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvaTipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tipo> alteraTipoControl(@PathVariable Long id, @RequestBody Tipo Tipo) {
        Tipo alteraTipo = TipoService.alterarTipo(id, Tipo);
        if (alteraTipo != null) {
            return ResponseEntity.ok(Tipo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> apagaTipoControl(@PathVariable Long id) {
        boolean apagar = TipoService.apagarTipo(id);
        if (apagar) {
        	 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

