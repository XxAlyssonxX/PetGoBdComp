package com.petgo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Pet")
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pet", nullable = false)
	private Long id;
	
	@Column(name = "nome", nullable = false, length = 100)
	private String nome;
	
	@Column(name = "dataNasc", nullable = false, length = 100)
	private String dataNasc;
	
	@Column(name = "numDoc", nullable = false, length = 100)
	private String numDoc;
	
	@Column(name = "raca", nullable = false, length = 100)
	private String raca;
	
	@Column(name = "cor", nullable = false, length = 100)
	private String cor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo",nullable = false)
	private Tipo tipo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_propietario",nullable = false)
	private Propietario propietario;
}
