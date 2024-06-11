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
@Table(name = "Veterinario")
public class Veterinario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_veterinario", nullable = false)
	private Long id;
	
	@Column(name = "nome", nullable = false, length = 100)
	private String nome;
	
	@Column(name = "cpf", nullable = false, length = 100)
	private String cpf;

	@Column(name = "rg", nullable = false, length = 100)
	private String rg;
	
	@Column(name = "telefone", nullable = false, length = 100)
	private String telefone;
	
	@Column(name = "telefone2", nullable = false, length = 100)
	private String telefone2;
	
	@Column(name = "rua", nullable = false, length = 100)
	private String rua;
	
	@Column(name = "bairro", nullable = false, length = 100)
	private String bairro;
	
	@Column(name = "cidade", nullable = false, length = 100)
	private String cidade;	
	
	@Column(name = "crmv", nullable = false, length = 100)
	private String crmv;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_especialidade",nullable = false)
	private Especialidade especialidade;
}
