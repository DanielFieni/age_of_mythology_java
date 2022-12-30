package egipcios;

import abstrato.Guerreiro;
import abstrato.Egipcio;
import java.util.LinkedList;

/**
 *
 * @author Daniel
 */
public class Anubita extends Egipcio{

    public Anubita(String nome, int idade, float peso) {
        super(nome, idade, peso);
    }

    @Override
    public boolean atacar(LinkedList<Guerreiro> ladoOponente, LinkedList<Guerreiro> ladoAliado) {
        // Primeiro da lista adversaria
        Guerreiro oponentePrimLista = ladoOponente.getFirst();
        // Ultimo da lista adversaria
        Guerreiro oponenteFinalLista = ladoOponente.getLast();
        
        // Retirar a energia dos dois guerreiros
        oponentePrimLista.setEnergia(oponentePrimLista.getEnergia() - 15);
        oponenteFinalLista.setEnergia(oponenteFinalLista.getEnergia() - 15);
        
        return oponentePrimLista.getEnergia() > 0;
        
    }
    
}
