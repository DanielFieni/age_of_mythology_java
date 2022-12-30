package egipcios;

import abstrato.Guerreiro;
import abstrato.Egipcio;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Daniel
 */
public class Mumia extends Egipcio{
    
    public Mumia(String nome, int idade, float peso){
        super(nome, idade, peso);
    }

    @Override
    public boolean atacar(LinkedList<Guerreiro> ladoOponente, LinkedList<Guerreiro> ladoAliado) {
        Guerreiro oponente = ladoOponente.getFirst();
        
        // Retiar 50 pontos de energia do Guerreiro adversario
        oponente.setEnergia(oponente.getEnergia() - 50);
        
        // Quando mata um adversário gera um morto vivo e acrescenta em sua fila
        if(oponente.getEnergia() <= 0) {
            ladoAliado.add(new MortoVivo(oponente.getNome(), oponente.getIdade(), oponente.getPeso()));
            return false;
        }
        
        return true;
        
    }
    
    // A Mumia tambem morre de uma forma diferente, entao fiz uma sobrescrita do metodo removerGuerreiro
    @Override
    public void removerGuerreiro(LinkedList<Guerreiro> lado){
        Iterator<Guerreiro> it = lado.iterator();
        
        // Defini uma flag para conferir se ainda existe Mumia mortoa na lista
        boolean flag = false;
        
        while (it.hasNext()){
            
            Guerreiro g = it.next();
            
            if (g.getEnergia() <=0 ){
                it.remove();
                flag = true;
                
                if (g.getClass().getSimpleName().equals("Mumia")){
                    Mumia m = (Mumia)g;
                    lado.add(new Anubita(m.getNome(), 0, 60));
                    lado.add(new Anubita(m.getNome(), 0, 60));
                    lado.add(new Anubita(m.getNome(), 0, 60));
                    lado.add(new Anubita(m.getNome(), 0, 60));
                    break;
                }
                
            }
        }
        
        if (flag){
            this.removerGuerreiro(lado);
        }
        
    }
    
}
