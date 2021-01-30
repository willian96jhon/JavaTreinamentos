/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Cliente MMS
 */
public class Pessoa implements Metodos {
    protected String nome;
    protected double altura;
    protected int idade;
    protected double peso;

    public Pessoa(String nome, double altura, int idade, double peso) {
        this.nome = nome;
        this.altura = altura;
        this.idade = idade;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public void aniversario(){
        setIdade(getIdade()+1);
    }

    @Override
    public void saltar() {
        System.out.println(this.nome + " está saltando");  
    }

    @Override
    public void casar() {
        setNome(getNome()+ " Novo Nome");
    }

    @Override
    public void andar() {
        System.out.println(this.nome + " está andando");
    }
}
