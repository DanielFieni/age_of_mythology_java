package gregos;

import abstrato.Guerreiro;
import abstrato.Grego;
import java.util.LinkedList;

/**
 *
 * @author Daniel
 */
public class Hidra extends Grego{
    private int dano = 50;

    public Hidra(String nome, int idade, float peso) {
        super(nome, idade, peso);
    }
    
    @Override
    public boolean atacar(LinkedList<Guerreiro> ladoOponente, LinkedList<Guerreiro> ladoAliado) {
        
        Guerreiro oponente = ladoOponente.getFirst();
        
        oponente.setEnergia(oponente.getEnergia() - this.dano);
        
        //Apos atacar, verificar se o oponente vai morrer (se a energia for <= 0)
        if (oponente.getEnergia() <= 0){
            //Gerar uma nova cabeca para a Hidra
            this.gerarCabeca();
            return false;
        }
        
        return true;
        
    }
    
    //Gera a cabeca e aumenta o proprio dano e a energia 
    public void gerarCabeca(){
        
        //Aumenta o proprio dano em 10;
        this.setDano(this.getDano() + 10);
        //Aumenta a propria energia em 10;
        this.setEnergia(this.getEnergia() + 10);
        
    }
    
    public int getDano(){
        return this.dano;
    }
    
    public void setDano(int dano){
        this.dano = dano;
    }

}
