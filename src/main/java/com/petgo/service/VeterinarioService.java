package com.petgo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petgo.entities.Veterinario;
import com.petgo.repository.VeterinarioRepository;

@Service
public class VeterinarioService {
	
    private final VeterinarioRepository VeterinarioRepository;

    @Autowired
    public VeterinarioService(VeterinarioRepository VeterinarioRepository) {
        this.VeterinarioRepository = VeterinarioRepository;
    }

    public List<Veterinario> buscaTodosVeterinarios() {
        return VeterinarioRepository.findAll();
    }

    public Veterinario buscaVeterinarioPeloId(Long id) {
        Optional<Veterinario> Veterinario = VeterinarioRepository.findById(id);
        return Veterinario.orElse(null);
    }

    public Veterinario salvaVeterinario(Veterinario Veterinario) {
        return VeterinarioRepository.save(Veterinario);
    }

    public Veterinario alterarVeterinario(Long id, Veterinario alterarVeterinario) {
        Optional<Veterinario> existeVeterinario = VeterinarioRepository.findById(id);
        if (existeVeterinario.isPresent()) {
            alterarVeterinario.setId(id);
            return VeterinarioRepository.save(alterarVeterinario);
        }
        return null;
    }
    
    //Query Method
  	public List<Veterinario> getVeterinarioPorNome(String data){
  		return VeterinarioRepository.findByNome(data);
  	}
  	//@Query
  	public List<Veterinario> findByCrmv(String crmv){
  		return VeterinarioRepository.findByCrmv(crmv);
  	}
  
  	//@Query
  		public List<Veterinario> findByCidade(String Cidade){
  			return VeterinarioRepository.findByCidade(Cidade);
  	}

    public boolean apagarVeterinario(Long id) {
        Optional<Veterinario> existeVeterinario = VeterinarioRepository.findById(id);
        if (existeVeterinario.isPresent()) {
            VeterinarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}