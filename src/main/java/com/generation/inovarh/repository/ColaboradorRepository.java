package com.generation.inovarh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.inovarh.model.Colaborador;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
	
	//get by nome
	public List<Colaborador> findAllByNomeContainingIgnoreCase(String nome);
	
	//get by departamento
	public List<Colaborador> findAllByDepartamentoContainingIgnoreCase(String departamento);

}
