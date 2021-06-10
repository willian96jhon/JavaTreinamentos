package com.automobilistico.automobilistico.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCliente;
	
	
	@NotBlank(message="Nome é obrigatóro")
	@Size(max=50, message="Máximo de caracteres 50")
	@Column
	private String nome;
	
	@NotBlank(message="Telefone é obrigatório")
	@Column
	private String tel;
	
	@NotBlank(message="Endereço é obrigatório")
	@Size(max=50, message="Máximo de caracteres é 50")
	@Column
	private String endereco;
	
	@NotBlank(message="CPF é obrigatório")
	@Column
	private String cpf;
	
	@OneToOne
	private Cadastro veiculo;
	
	//private List<String> veiculos2= new ArrayList<>();
	
	//private Set<String> servicos=new HashSet<String>();
	
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Cadastro> veiculos;
	
	
	
	//Getters and Setters
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	/*public Set<String> getServicos() {
		return servicos;
	}
	public void setServicos(Set<String> servicos) {
		this.servicos = servicos;
	}*/

	public Cadastro getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Cadastro veiculo) {
		this.veiculo = veiculo;
	}
	public List<Cadastro> getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(List<Cadastro> veiculos) {
		this.veiculos = veiculos;
	}
	
	
	
	
	

}
