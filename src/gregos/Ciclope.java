package gregos;

import abstrato.Guerreiro;
import abstrato.Grego;
import java.util.LinkedList;

/**
 *
 * @author Daniel
 */
public class Ciclope extends Grego {
    
    public Ciclope(String nome, int idade, float peso){
        super(nome, idade, peso);
    }
    
    @Override
    public boolean atacar(LinkedList<Guerreiro> ladoOponente, LinkedList<Guerreiro> ladoAliado){
        //Pega a posicao do Guerreiro da outra fila
        Guerreiro oponente = ladoOponente.getFirst();
        
        //Tirar 40 pontos de energia do guerreiro adversário
        oponente.setEnergia(oponente.getEnergia() - 40);
        
        // Sempre retorna falso para nao permitir o guerreiro adversario atacar
        return false;
        
    }

}
