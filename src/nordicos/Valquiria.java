package nordicos;

import abstrato.Guerreiro;
import abstrato.Nordico;
import java.util.LinkedList;

/**
 *
 * @author Daniel
 */
public class Valquiria extends Nordico {

    public Valquiria(String nome, int idade, float peso){
        super(nome, idade, peso);
    }
    
    @Override
    public boolean atacar(LinkedList<Guerreiro> ladoOponente, LinkedList<Guerreiro> ladoAliado) {
        //Atacar tira 20 pontos de energia do oponente
        Guerreiro oponente = ladoOponente.getFirst();
        oponente.setEnergia(oponente.getEnergia() - 20);
        
        //Apos atacar, o aliado atrás ganha 20 pontos de energia
        if(ladoAliado.size() > 1){
            this.curarAliado(ladoAliado.get(1));
        }
        
        return oponente.getEnergia() > 0;
        
    }
    
    public void curarAliado(Guerreiro aliado){
        aliado.setEnergia(aliado.getEnergia() + 20);
    }

}
