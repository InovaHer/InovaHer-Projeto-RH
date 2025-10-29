package com.generation.inovarh.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.inovarh.model.Colaborador;
import com.generation.inovarh.repository.ColaboradorRepository;

@Service
public class ColaboradorService {
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	public Optional<Colaborador> buscarPorId(Long id) {
	    return colaboradorRepository.findById(id);
	}

	public BigDecimal calcularSalarioFinal(Colaborador colaborador) {
	    BigDecimal valorHora = colaborador.getValorHora();
	    int horasTrabalhadas = colaborador.getHorasTrabalhadas();
	    BigDecimal bonus = colaborador.getBonus() != null ? colaborador.getBonus() : BigDecimal.ZERO;
	    BigDecimal descontos = colaborador.getDescontos() != null ? colaborador.getDescontos() : BigDecimal.ZERO;

	    // Verifica se o mês atual é o mesmo do mês de aniversário
	    if (colaborador.getDataNascimento() != null) {
	        int mesAtual = LocalDate.now().getMonthValue();
	        int mesAniversario = colaborador.getDataNascimento().getMonthValue();

	        if (mesAtual == mesAniversario) {
	            bonus = bonus.add(BigDecimal.valueOf(500.00)); // adiciona bônus de R$500
	        }
	    }

	    // Cálculo: (valor da hora × horas trabalhadas) + bônus − descontos
	    return valorHora
	            .multiply(BigDecimal.valueOf(horasTrabalhadas))
	            .add(bonus)
	            .subtract(descontos);
	}
}