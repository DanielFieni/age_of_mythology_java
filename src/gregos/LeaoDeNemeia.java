package gregos;

import abstrato.Guerreiro;
import abstrato.Grego;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Daniel
 */
public class LeaoDeNemeia extends Grego {
    
    public LeaoDeNemeia(String nome, int idade, float peso){
        super(nome, idade, peso);
    }

    @Override
    public boolean atacar(LinkedList<Guerreiro> ladoOponente, LinkedList<Guerreiro> ladoAliado){
        //Afeta em 30 pontos de energia o primeiro oponente
        //Afeta em 15 de dano o segundo oponente
        //Afeta em 5 de dano o terceiro oponente
        
        Guerreiro oponente = ladoOponente.getFirst();
        
        Iterator<Guerreiro> it = ladoOponente.iterator();
        //Vetor para armazenar os danos do Leao de Nemeia
        int[] vetor = {30, 15, 5}; 
        //Contar a quantidade de guerreiros que ja foram atacados
        int cont = 0;
        
        while(it.hasNext()){
            
            Guerreiro g = it.next();
            
            if (cont < 3){
                g.setEnergia(g.getEnergia() - vetor[cont]);
            }
            
            cont++;
            
        }
        
        // Se a energia do adversario for maior que zero retorna true, ou seja, o adversario pode atacar
        return oponente.getEnergia() > 0;
        
    }

}
