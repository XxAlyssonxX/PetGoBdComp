package com.petgo.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.petgo.entities.Propietario;

public interface  PropietarioRepository extends JpaRepository<Propietario,Long>{
	
		//QUERY METHOD
		List<Propietario>findByNome(String nome);
		
		//QUERY METHOD
		List<Propietario>findByCpf(String cpf);
		
		
		@Query("SELECT a FROM Proprietario a WHERE a.cidade = :cidade")
		List<Propietario> findByCidade(@Param("cidade")String cidade);
		
}
