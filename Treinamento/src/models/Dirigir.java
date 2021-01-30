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
public class Dirigir {
    private Pessoa piloto;
    private Carro veiculo;

    public Pessoa getPiloto() {
        return piloto;
    }

    public void setPiloto(Pessoa piloto) {
        this.piloto = piloto;
    }

    public Carro getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Carro veiculo) {
        this.veiculo = veiculo;
    }
    
    public void ligar(Pessoa p1, Carro c1){
        System.out.println(p1.nome + " Dirige o carro do modelo "+c1.modelo);
    }
    
}
