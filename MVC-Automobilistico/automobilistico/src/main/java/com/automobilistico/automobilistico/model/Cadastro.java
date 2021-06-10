package com.automobilistico.automobilistico.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cadastro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCadastro;
	
	@Column
	private String placa;
	
	@Column
	private String modelo;
	@Column
	private int anoFabricacao;
	@Column
	private BigDecimal valor;
	
	//Getters and Setters
	public Long getIdCadastro() {
		return idCadastro;
	}
	public void setIdCadastro(Long idCadastro) {
		this.idCadastro = idCadastro;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	} 
	
	
	
}
