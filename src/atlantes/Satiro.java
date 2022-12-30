package atlantes;

import abstrato.Guerreiro;
import abstrato.Atlante;
import java.util.LinkedList;

/**
 *
 * @author Daniel
 */
public class Satiro extends Atlante{
    
    public Satiro(String nome, int idade, float peso){
        super(nome, idade, peso);
    }

    @Override
    public boolean atacar(LinkedList<Guerreiro> ladoOponente, LinkedList<Guerreiro> ladoAliado) {
        Guerreiro oponente = ladoOponente.getFirst();
        // Percorrer a lista e retirar 5 de energia de cada adversario
        
        for (Guerreiro g : ladoOponente) {
            // Tirar 5 de dano de cada adversario
            g.setEnergia(g.getEnergia() - 5);
        }
        
        return oponente.getEnergia() > 0;
        
    }
    
}
