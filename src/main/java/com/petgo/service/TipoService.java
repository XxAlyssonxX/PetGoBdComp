package com.petgo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petgo.entities.Tipo;
import com.petgo.repository.TipoRepository;

@Service
public class TipoService {
	
    private final TipoRepository TipoRepository;

    @Autowired
    public TipoService(TipoRepository TipoRepository) {
        this.TipoRepository = TipoRepository;
    }

    public List<Tipo> buscaTodosTipos() {
        return TipoRepository.findAll();
    }

    public Tipo buscaTipoPeloId(Long id) {
        Optional<Tipo> Tipo = TipoRepository.findById(id);
        return Tipo.orElse(null);
    }

    public Tipo salvaTipo(Tipo Tipo) {
        return TipoRepository.save(Tipo);
    }

    public Tipo alterarTipo(Long id, Tipo alterarTipo) {
        Optional<Tipo> existeTipo = TipoRepository.findById(id);
        if (existeTipo.isPresent()) {
            alterarTipo.setId(id);
            return TipoRepository.save(alterarTipo);
        }
        return null;
    }

    public boolean apagarTipo(Long id) {
        Optional<Tipo> existeTipo = TipoRepository.findById(id);
        if (existeTipo.isPresent()) {
            TipoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}