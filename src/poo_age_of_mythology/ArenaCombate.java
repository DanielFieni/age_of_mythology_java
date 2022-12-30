package poo_age_of_mythology;

import abstrato.Guerreiro;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Daniel
 */
public class ArenaCombate {

    public void iniciarBatalha(LinkedList<Guerreiro> lado1, LinkedList<Guerreiro> lado2) throws FileNotFoundException {

        Guerreiro guerreiroLado1 = null;
        Guerreiro guerreiroLado2 = null;

        int numeroAleatorio;
        Random random = new Random();

        CriarLista criarLista = new CriarLista();
        criarLista.ladoGregosNordicos(lado1);
        criarLista.ladoAtlantesEgipcios(lado2);

        //Fazer um while para determinar se as duas filas nao estao vazias
        while (!lado1.isEmpty() && !lado2.isEmpty()) {

            // Fazer um sorteio de quem vai atacar primeiro (0) - lado 1, (1) - lado 2
            numeroAleatorio = random.nextInt(2);

            // Declarar o primeiro Guerreiro de cada lista
            guerreiroLado1 = lado1.getFirst();
            guerreiroLado2 = lado2.getFirst();

            //Se o numero aleatorio for menor que 0, lado 1 ataca.
            if (numeroAleatorio == 0) {

                // O atacar retorna um boolean para determinar se o outro Guerreiro pode atacar, se for True, eh permitido atacar.
                if (guerreiroLado1.atacar(lado2, lado1)) {
                    guerreiroLado2.atacar(lado1, lado2);
                }

            } else {
                
                if (guerreiroLado2.atacar(lado1, lado2)) {
                    guerreiroLado1.atacar(lado2, lado1);
                }
                
            }

            //Mover os dois guerreiros para o final da lista
            guerreiroLado1.moverFinal(lado1);
            guerreiroLado2.moverFinal(lado2);

            // Confere todos os Guerreiros e os que estiverem com a energia menor que 0, sao retirados da lista
            guerreiroLado1.removerGuerreiro(lado1);
            guerreiroLado2.removerGuerreiro(lado2);

        }
        
        System.out.println("\n");
        System.out.println("DADOS FINAIS");
        criarLista.setSomaPesoLado1();
        criarLista.setSomaPesoLado2();
        criarLista.setMaisVelho();
        criarLista.setGanhadorPerdedor(guerreiroLado1, guerreiroLado2, lado1);

    }

}
