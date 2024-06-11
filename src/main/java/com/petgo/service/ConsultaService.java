package com.petgo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petgo.entities.Consulta;
import com.petgo.repository.ConsultaRepository;

@Service
public class ConsultaService {
	
    private final ConsultaRepository ConsultaRepository;

    @Autowired
    public ConsultaService(ConsultaRepository ConsultaRepository) {
        this.ConsultaRepository = ConsultaRepository;
    }

    public List<Consulta> buscaTodosConsultas() {
        return ConsultaRepository.findAll();
    }

    public Consulta buscaConsultaPeloId(Long id) {
        Optional<Consulta> Consulta = ConsultaRepository.findById(id);
        return Consulta.orElse(null);
    }

    public Consulta salvaConsulta(Consulta Consulta) {
        return ConsultaRepository.save(Consulta);
    }

    public Consulta alterarConsulta(Long id, Consulta alterarConsulta) {
        Optional<Consulta> existeConsulta = ConsultaRepository.findById(id);
        if (existeConsulta.isPresent()) {
            alterarConsulta.setId(id);
            return ConsultaRepository.save(alterarConsulta);
        }
        return null;
    }
    
  //Query Method
  	public List<Consulta> getConsultaPorData(String data){
  		return ConsultaRepository.findByData(data);
  	}
  	//@Query
  	public List<Consulta> findByHora(String hora){
  		return ConsultaRepository.findByHora(hora);
  	}
  	//@Query
  	public List<Consulta> findByDescricao(String descricao){
  		return ConsultaRepository.findByDescricao(descricao);
  	}

    public boolean apagarConsulta(Long id) {
        Optional<Consulta> existeConsulta = ConsultaRepository.findById(id);
        if (existeConsulta.isPresent()) {
            ConsultaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}