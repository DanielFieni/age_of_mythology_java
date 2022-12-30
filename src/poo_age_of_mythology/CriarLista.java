package poo_age_of_mythology;

import egipcios.Mumia;
import egipcios.Anubita;
import atlantes.Argus;
import atlantes.Satiro;
import atlantes.Prometeano;
import nordicos.Valquiria;
import nordicos.LoboDeFenris;
import gregos.Hidra;
import gregos.LeaoDeNemeia;
import abstrato.Guerreiro;
import gregos.Ciclope;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class CriarLista {
    private float somaPesoLado1=0;
    private float somaPesolado2=0;
    
    private int maisVelhoIdade;
    private String maisVelhoNome = null;
    
    public void ladoGregosNordicos(LinkedList<Guerreiro> lado1) throws FileNotFoundException {
        FileInputStream file;
        int tipo;
        int idade;
        float peso;
        String nome;
        
        file = new FileInputStream("lado1.txt");
        Scanner scan = new Scanner(file);
            
        //Lendo informacoes do arquivo do Lado 1.
        while (scan.hasNext()){
            tipo = scan.nextInt();
            nome = scan.next();
            idade = scan.nextInt();
            peso = scan.nextFloat();
            
            this.somaPesoLado1 += peso;
            
            if (this.maisVelhoNome == null){
                this.maisVelhoIdade = idade;
                this.maisVelhoNome = nome; 
                
            } else if (idade > this.maisVelhoIdade){
                this.maisVelhoIdade = idade;
                this.maisVelhoNome = nome; 
            }

            switch (tipo){
                case 1: lado1.add(new Ciclope(nome, idade, peso)); break;
                case 2: lado1.add(new LeaoDeNemeia(nome, idade, peso)); break;
                case 3: lado1.add(new Hidra(nome, idade, peso)); break;
                case 4: lado1.add(new Valquiria(nome, idade, peso)); break;
                case 5: lado1.add(new LoboDeFenris(nome, idade, peso)); break;
            }
        } 
    }
    
    public void ladoAtlantesEgipcios(LinkedList<Guerreiro> lado2) throws FileNotFoundException{
        FileInputStream file;
        int idade;
        String nome;
        float peso;
        int tipo;
        
        //Lendo informacoes do arquivo do Lado 2.
        file = new FileInputStream("lado2.txt");
        Scanner scan = new Scanner(file);
        
        while (scan.hasNext()){
                
            tipo = scan.nextInt();
            nome = scan.next();
            idade = scan.nextInt();
            peso = scan.nextFloat();
            
            this.somaPesolado2 += peso;
            
            if (this.maisVelhoNome == null){
                this.maisVelhoIdade = idade;
                this.maisVelhoNome = nome; 
            } else if (idade > this.maisVelhoIdade){
                this.maisVelhoIdade = idade;
                this.maisVelhoNome = nome; 
            }
                
            switch (tipo){
                case 1: lado2.add(new Prometeano(nome, idade, peso)); break;
                case 2: lado2.add(new Satiro(nome, idade, peso)); break;
                case 3: lado2.add(new Argus(nome, idade, peso)); break;
                case 4: lado2.add(new Anubita(nome, idade, peso)); break;
                case 5: lado2.add(new Mumia(nome, idade, peso)); break;
            }
        }
    }


    // Definicao da soma do peso dos Guerreiros do lado 1
    public void setSomaPesoLado1() {
        System.out.println("Gregos e Nórdicos pesam - " + this.somaPesoLado1 + " unidades");
    }
    
    // Definicao da soma do peso dos Guerreiros do lado 2
    public void setSomaPesoLado2() {
        System.out.println("Atlantes e Egípcios pesam - " + this.somaPesolado2 + " unidades");
    }
    
    // Definicao do Guerreiro mais velho
    public void setMaisVelho(){
        System.out.println(this.maisVelhoNome + " eh o mais velho (" + this.maisVelhoIdade + " unidades)");
    }
    
    // Definicao do Ganhador e perdedor
    public void setGanhadorPerdedor(Guerreiro guerreiroLado1, Guerreiro guerreiroLado2, LinkedList<Guerreiro> lado1){
        
        if (lado1.isEmpty()){
            
            System.out.println("Atlantes e Egipcios venceram.");
            System.out.println(guerreiroLado1.getNome() + ", " + guerreiroLado1.getIdade() + ", " + guerreiroLado1.getPeso());
            System.out.println(guerreiroLado2.getNome() + ", " + guerreiroLado2.getIdade() + ", " + guerreiroLado2.getPeso());
            
        } else {
            System.out.println("Gregos e Nordicos venceram.");
            System.out.println(guerreiroLado2.getNome() + ", " + guerreiroLado2.getIdade() + ", " + guerreiroLado2.getPeso());
            System.out.println(guerreiroLado1.getNome() + ", " + guerreiroLado1.getIdade() + ", " + guerreiroLado1.getPeso());

        }
        
    }
}
