package atlantes;

import abstrato.Guerreiro;
import abstrato.Atlante;
import java.util.LinkedList;

/**
 *
 * @author Daniel
 */
public class Argus extends Atlante{

    public Argus(String nome, int idade, float peso) {
        super(nome, idade, peso);
        this.setEnergia(60);
    }

    
    @Override
    public boolean atacar(LinkedList<Guerreiro> ladoOponente, LinkedList<Guerreiro> ladoAliado) {
        // Definir o guerreiro adversario
        Guerreiro oponente = ladoOponente.getFirst();
        // Tirar toda a energia do Guerreiro adversario
        oponente.setEnergia(0);
        
        return false;
        
    }
    
}
