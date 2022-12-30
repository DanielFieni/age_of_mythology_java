package nordicos;

import abstrato.Guerreiro;
import abstrato.Nordico;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Daniel
 */
public class LoboDeFenris extends Nordico{
    
    public LoboDeFenris(String nome, int idade, float peso){
        super(nome, idade, peso);
    }
    
    @Override
    public boolean atacar(LinkedList<Guerreiro> ladoOponente, LinkedList<Guerreiro> ladoAliado) {
        int dano = 40;

        //Se ouver outros lobos de fenris atrás dele em sequência na fila, aumentar em 20% cada lobo o dano
        //ex: 2 lobos atrás dele, aumentar o dano de ataque em 8 cada lobo, ou seja, irá dar um dano de 56
        Iterator<Guerreiro> it = ladoAliado.iterator();
        it.next();
        
        int cont=0;
        
        while (it.hasNext()){
            Guerreiro g = it.next();
            
            // Conferir se o proximo guerreiro eh um Lobo de Fenris
            if (!(g.getClass().getSimpleName().equals("LoboDeFenris"))){
                break;
            }
            
            cont++;
                    
        }
        
        dano = dano + (8 * cont);
        
        Guerreiro oponente = ladoOponente.getFirst();
        oponente.setEnergia(oponente.getEnergia() - dano);
        
        return oponente.getEnergia() > 0;
        
    }
    
}
