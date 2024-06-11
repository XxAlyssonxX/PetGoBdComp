package com.petgo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petgo.entities.Pet;
import com.petgo.repository.PetRepository;

@Service
public class PetService {
	
    private final PetRepository PetRepository;

    @Autowired
    public PetService(PetRepository PetRepository) {
        this.PetRepository = PetRepository;
    }

    public List<Pet> buscaTodosPets() {
        return PetRepository.findAll();
    }

    public Pet buscaPetPeloId(Long id) {
        Optional<Pet> Pet = PetRepository.findById(id);
        return Pet.orElse(null);
    }

    public Pet salvaPet(Pet Pet) {
        return PetRepository.save(Pet);
    }

    public Pet alterarPet(Long id, Pet alterarPet) {
        Optional<Pet> existePet = PetRepository.findById(id);
        if (existePet.isPresent()) {
            alterarPet.setId(id);
            return PetRepository.save(alterarPet);
        }
        return null;
    }
    
    //Query Method
  	public List<Pet> getPetPorNome(String nome){
  		return PetRepository.findByNome(nome);
  	}
  	//@Query
  	public List<Pet> findByRaca(String raca){
  		return PetRepository.findByRaca(raca);
  	}
  	//@Query
  	public List<Pet> findByDataNasc(String dataNasc){
  		return PetRepository.findByDataNasc(dataNasc);
  	}

    public boolean apagarPet(Long id) {
        Optional<Pet> existePet = PetRepository.findById(id);
        if (existePet.isPresent()) {
            PetRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
}
