/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import models.Carro;
import models.Dirigir;
import models.Pessoa;

/**
 *
 * @author Cliente MMS
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        models.Pessoa p1=new Pessoa("Eliana", 1.60, 43, 57);
        models.Carro c1=new Carro("azul", "corsa");
        models.Dirigir d1=new Dirigir();
        
        c1.pintar("Preto");
        p1.casar();
        p1.saltar();
        d1.ligar(p1,c1);
    }
    
}
