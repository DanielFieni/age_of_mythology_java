package abstrato;

import java.util.LinkedList;

/**
 *
 * @author Daniel
 */
public abstract class Guerreiro {
    
    private String nome;
    private int idade;
    private float peso;
    private int energia = 100;
    
    public Guerreiro(String nome, int idade, float peso){
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
    }

    //Metodo Abstrato
    public abstract boolean atacar(LinkedList<Guerreiro> ladoOponente, LinkedList<Guerreiro> ladoAliado);
    
    //Metodo para mover o guerreiro para o final da lista
    public void moverFinal(LinkedList<Guerreiro> lado){
        //Adicionar o primeiro Guerreiro da lista em uma variavel
        Guerreiro g = lado.getFirst();
        
        //Remover o primeiro Guerreiro da lista
        lado.remove();
        
        //Adicionar o Guerreiro no final da lista
        lado.addLast(g);
    }
    
    //Metodo para remover o guerreiro da lista
    public void removerGuerreiro(LinkedList<Guerreiro> lado){
        //Percorrer a lista e excluir os guerreiros que tiverem a energia menor ou igual a 0
        lado.removeIf(guerreiro -> guerreiro.getEnergia() <= 0);
    }
    
    public String getNome() {
        return nome;
    }

    //Metodos Getters e Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

}
