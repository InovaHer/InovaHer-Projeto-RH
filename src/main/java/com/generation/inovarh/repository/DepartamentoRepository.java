package com.generation.inovarh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.inovarh.model.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
	
	// Buscar departamento por Id
	public List<Departamento> findAllById(Long id);
	
	// Buscar departamentos por nome
	public List<Departamento> findAllByNomeContainingIgnoreCase(String nome);

	// Buscar departamentos por descrição
	public List<Departamento> findAllByDescricaoContainingIgnoreCase(String descricao);
	
}