package poo_age_of_mythology;

import abstrato.Guerreiro;
import java.io.FileNotFoundException;
import java.util.LinkedList;

/**
 *
 * @author Daniel
 */
public class POO_Age_Of_Mythology {

    public static void main(String[] args) throws FileNotFoundException {
        LinkedList<Guerreiro> lado1 = new LinkedList();
        LinkedList<Guerreiro> lado2 = new LinkedList();
        
        ArenaCombate arena = new ArenaCombate();
        
        arena.iniciarBatalha(lado1, lado2);
        
    }
}
