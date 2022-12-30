package abstrato;

/**
 *
 * @author Daniel
 */
public abstract class Grego extends Guerreiro {
    
    public Grego(String nome, int idade, float peso){
        super(nome, idade, peso);
    }
    
    // Sobrescrita do metodo "setEnergia" de Guerreiro
    @Override
    public void setEnergia(int energia){
        
        // Os gregos nao podem ter a energia maior que 100
        if (energia > 100){
            this.setEnergia(100);
        } else {
            super.setEnergia(energia);
        }
    }
}
