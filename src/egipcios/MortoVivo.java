package egipcios;

import abstrato.Guerreiro;
import java.util.LinkedList;

/**
 *
 * @author Daniel
 */
public class MortoVivo extends Guerreiro{
    
    public MortoVivo(String nome, int idade, float peso){
        super(nome, idade, peso);
    }

    @Override
    public boolean atacar(LinkedList<Guerreiro> ladoOponente, LinkedList<Guerreiro> ladoAliado) {
        
        Guerreiro oponente = ladoOponente.getFirst();
        
        oponente.setEnergia(oponente.getEnergia() - 5);
        
        return oponente.getEnergia() > 0;
        
    }
    
}
