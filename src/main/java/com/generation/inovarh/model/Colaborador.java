package com.generation.inovarh.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_colaboradores")
public class Colaborador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//nome VARCHAR
	@NotBlank(message = "O nome é obrigatório.")
	@Size(min = 3, max = 100, message = "O nome deve conter entre 3 e 255 caracteres.")
	@Column(nullable = false, length = 255)
	private String nome;
		
	//data_nasc DATE
	// @Column(name = "data_nascimento")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;
	
	//valor_hora DOUBLE
	@NotNull(message = "O valor da hora é obrigatório.")
	@DecimalMin(value = "0.0", inclusive = false, message = "O valor da hora deve ser maior que zero.")
	@Digits(integer = 10, fraction = 2, message = "O valor da hora deve ter no máximo 10 dígitos inteiros e 2 dígitos decimais.")
	@Column(name = "valor_hora", precision = 12, scale = 2)
	private BigDecimal valorHora;
	
	//horas_trabalhadas INTEGER
	@NotNull(message = "As horas trabalhadas são obrigatórias.")
	@DecimalMin(value = "0", inclusive = true, message = "As horas trabalhadas não podem ser negativas.")
	@Column(name = "horas_trabalhadas")
	private Integer horasTrabalhadas;
	
	//bonus DOUBLE
	@NotNull(message = "O bônus é obrigatório.")
	@DecimalMin(value = "0.0", inclusive = true, message = "O bônus não pode ser negativo.")
	@Digits(integer = 10, fraction = 2, message = "O bônus deve ter no máximo 10 dígitos inteiros e 2 dígitos decimais.")
	@Column(name = "bonus", precision = 12, scale = 2)
	private BigDecimal bonus;
	
	//descontos DOUBLE
	@NotNull(message = "Os descontos são obrigatórios.")
	@DecimalMin(value = "0.0", inclusive = true, message = "Os descontos não podem ser negativos.")
	@Digits(integer = 10, fraction = 2, message = "Os descontos devem ter no máximo 10 dígitos inteiros e 2 dígitos decimais.")
	@Column(name = "descontos", precision = 12, scale = 2)
	private BigDecimal descontos;
	
	@ManyToOne
	@JsonIgnoreProperties("colaboradores")
	private Departamento departamento;

	 public Colaborador() {}

	    public Colaborador(Long id, int horasTrabalhadas, BigDecimal valorHora, BigDecimal bonus, BigDecimal descontos) {
	        this.id = id;
	        this.horasTrabalhadas = horasTrabalhadas;
	        this.valorHora = valorHora;
	        this.bonus = bonus;
	        this.descontos = descontos;
	    }
	
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public BigDecimal getValorHora() {
		return valorHora;
	}

	public void setValorHora(BigDecimal valorHora) {
		this.valorHora = valorHora;
	}

	public Integer getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(Integer horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public BigDecimal getBonus() {
		return bonus;
	}

	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}

	public BigDecimal getDescontos() {
		return descontos;
	}

	public void setDescontos(BigDecimal descontos) {
		this.descontos = descontos;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	
}
