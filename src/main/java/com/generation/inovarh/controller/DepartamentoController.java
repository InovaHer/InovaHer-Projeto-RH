package com.generation.inovarh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.inovarh.model.Departamento;
import com.generation.inovarh.repository.DepartamentoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/departamentos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DepartamentoController {
	
	// Injeção de dependência do repositório
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	// Método para listar todos os departamentos
	@GetMapping	
	public ResponseEntity<List<Departamento>> getAll() {
		return ResponseEntity.ok(departamentoRepository.findAll());
	}
	
	// Método para buscar por Id
	@GetMapping("/{id}")
	public ResponseEntity<Departamento> getById(@PathVariable Long id) {
		return departamentoRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	// Método para buscar por nome
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Departamento>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(departamentoRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	// Método para buscar por descrição
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Departamento>> getByDescricao(@PathVariable String descricao) {
		return ResponseEntity.ok(departamentoRepository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	// Método para criar novo departamento
	@PostMapping
	public ResponseEntity<Departamento> post(@Valid @RequestBody Departamento departamento) {
		departamento.setId(null);

		return ResponseEntity.status(HttpStatus.CREATED).body(departamentoRepository.save(departamento));
	}
	
	// Método para atualizar departamento
	@PutMapping
	public ResponseEntity<Departamento> put(@Valid @RequestBody Departamento departamento) {
		return departamentoRepository.findById(departamento.getId())
				.map(resposta -> ResponseEntity.ok().body(departamentoRepository.save(departamento)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	// Método para deletar departamento
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {

		Optional<Departamento> tema = departamentoRepository.findById(id);

		if (tema.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		departamentoRepository.deleteById(id);
	}
		
		
}
