package atlantes;

import abstrato.Guerreiro;
import abstrato.Atlante;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Daniel
 */
public class Prometeano extends Atlante {

    private int vida;

    public Prometeano(String nome, int idade, float peso) {
        super(nome, idade, peso);
        this.vida = 100;
    }

    // Criei essa sobrecarga do Construtor para quando for dividir os Prometeanos
    public Prometeano(String nome, int idade, float peso, int energia) {
        super(nome, idade, peso);
        this.setEnergia(energia);
        // Essa variavel vida ira sempre receber a energia do Prometeano criado
        this.vida = energia;
    }

    @Override
    public boolean atacar(LinkedList<Guerreiro> ladoOponente, LinkedList<Guerreiro> ladoAliado) {

        Guerreiro oponente = ladoOponente.getFirst();
        // Retira 40 pontos de energia do adversario
        oponente.setEnergia(oponente.getEnergia() - 10);

        return oponente.getEnergia() > 0;

    }

    // Como a morte do Prometeano eh diferente, fiz uma sobreescrita do metodo removerGuerreiro
    @Override
    public void removerGuerreiro(LinkedList<Guerreiro> lado) {
        // Defini uma flag para conferir se ainda existe Prometeanos mortos na lista
        boolean flag = false;
        
        Iterator<Guerreiro> iterator = lado.iterator();

        while (iterator.hasNext()) {
            Guerreiro g = iterator.next();

            if (g.getEnergia() <= 0) {
                iterator.remove();
                flag = true;
                
                if (g.getClass().getSimpleName().equals("Prometeano")) {
                    ((Prometeano) g).dividir(lado, (Prometeano) g);
                    break;
                }
            }

        }

        if (flag) {
            this.removerGuerreiro(lado);
        }

    }

    public void dividir(LinkedList<Guerreiro> ladoAliado, Prometeano g) {

        if (g.vida > 1) {
            ladoAliado.add(new Prometeano(g.getNome(), g.getIdade(), g.getPeso(), g.vida / 2));
            ladoAliado.add(new Prometeano(g.getNome(), g.getIdade(), g.getPeso(), g.vida / 2));
        }

    }

}
