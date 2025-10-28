package com.generation.inovarh.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_departamentos")
public class Departamento {

	@Id // PRIMARY KEY (id)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
	private Long id;

	// Atributo nome do departamento
	@NotBlank(message = "O atributo nome é obrigatório!")
	@Size(min = 3, max = 100, message = "O atributo nome deve conter no mínimo 3 e no máximo 100 caracteres")
	private String nome;

	// Atributo descrição do departamento
	@NotBlank(message = "O atributo descrição é obrigatório!")
	@Size(min = 5, max = 500, message = "O atributo descrição deve conter no mínimo 5 e no máximo 500 caracteres")
	private String descricao;
	
	// Um departamento pode ter vários colaboradores
	//@OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
	//private List<Colaborador> colaboradores;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}