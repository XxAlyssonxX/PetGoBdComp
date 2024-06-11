package com.petgo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petgo.entities.Propietario;
import com.petgo.repository.PropietarioRepository;

@Service
public class PropietarioService {
	
    private final PropietarioRepository PropietarioRepository;

    @Autowired
    public PropietarioService(PropietarioRepository PropietarioRepository) {
        this.PropietarioRepository = PropietarioRepository;
    }

    public List<Propietario> buscaTodosPropietarios() {
        return PropietarioRepository.findAll();
    }

    public Propietario buscaPropietarioPeloId(Long id) {
        Optional<Propietario> Propietario = PropietarioRepository.findById(id);
        return Propietario.orElse(null);
    }

    public Propietario salvaPropietario(Propietario Propietario) {
        return PropietarioRepository.save(Propietario);
    }

    public Propietario alterarPropietario(Long id, Propietario alterarPropietario) {
        Optional<Propietario> existePropietario = PropietarioRepository.findById(id);
        if (existePropietario.isPresent()) {
            alterarPropietario.setId(id);
            return PropietarioRepository.save(alterarPropietario);
        }
        return null;
    }
    
    //Query Method
  	public List<Propietario> getProprietariosPorNome(String nome){
  		return PropietarioRepository.findByNome(nome);
  	}
  	//@Query
  	public List<Propietario> findByCidade(String cidade){
  		return PropietarioRepository.findByCidade(cidade);
  	}
  	
  	//@Query
  	public List<Propietario> findByCpf(String cpf){
  		return PropietarioRepository.findByCpf(cpf);
  	}

    public boolean apagarPropietario(Long id) {
        Optional<Propietario> existePropietario = PropietarioRepository.findById(id);
        if (existePropietario.isPresent()) {
            PropietarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}