package com.generation.inovarh.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RestController;

import com.generation.inovarh.model.Colaborador;
import com.generation.inovarh.repository.ColaboradorRepository;
import com.generation.inovarh.repository.DepartamentoRepository;
import com.generation.inovarh.service.ColaboradorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/colaboradores")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ColaboradorController {

		@Autowired
		private ColaboradorRepository colaboradorRepository;
		
		@Autowired
		private DepartamentoRepository departamentoRepository;
		
		@Autowired
		private ColaboradorService colaboradorService;
		
		@GetMapping
		private ResponseEntity<List<Colaborador>> getAll(){
			
			return ResponseEntity.ok(colaboradorRepository.findAll());
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Colaborador> getById(@PathVariable Long id){
			
			return colaboradorRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
		}
		
		@GetMapping("/nome/{nome}")
		public ResponseEntity<List<Colaborador>> getByNome(@PathVariable String nome){
			return ResponseEntity.ok(colaboradorRepository.findAllByNomeContainingIgnoreCase(nome));	
		}
				
		@GetMapping("/salariofinal/{id}")
		public Map<String, Object> calcularSalarioFinal(@PathVariable Long id) {
	        Map<String, Object> resposta = new HashMap<>();

	        var colaboradorOpt = colaboradorService.buscarPorId(id);

	        if (colaboradorOpt.isEmpty()) {
	            resposta.put("erro", "Colaborador não encontrado!");
	            return resposta;
	        }

	        Colaborador colaborador = colaboradorOpt.get();
	        BigDecimal salarioFinal = colaboradorService.calcularSalarioFinal(colaborador);

	        resposta.put("ID", colaborador.getId());
	        resposta.put("Nome", colaborador.getNome());
	        resposta.put("Valor da Hora", colaborador.getValorHora());
	        resposta.put("Horas Trabalhadas", colaborador.getHorasTrabalhadas());
	        resposta.put("Bônus", colaborador.getBonus());
	        resposta.put("Descontos", colaborador.getDescontos());
	        resposta.put("Salário Final", salarioFinal);

	        return resposta;
	    }
	
		
		@PostMapping
		public ResponseEntity<Colaborador> postColaborador(@Valid @RequestBody Colaborador colaborador){
			
			colaborador.setId(null);
			
			return colaboradorRepository.findById(colaborador.getDepartamento().getId())
					.map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(colaboradorRepository.save(colaborador)))
					.orElse(ResponseEntity.badRequest().build());
		}
		
		
		@PutMapping
		public ResponseEntity<Colaborador> putColaborador(@Valid @RequestBody Colaborador colaborador) {
			if (colaboradorRepository.existsById(colaborador.getId())){			
				return colaboradorRepository.findById(colaborador.getId())
						.map(resposta -> ResponseEntity.ok().body(colaboradorRepository.save(colaborador)))
						.orElse(ResponseEntity.notFound().build());
			}
			return ResponseEntity.notFound().build();
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<?> deleteColaborador(@PathVariable Long id) {
			
			return colaboradorRepository.findById(id)
					.map(resposta -> {
						colaboradorRepository.deleteById(id);
						return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
					})
					.orElse(ResponseEntity.notFound().build());
		}
}
