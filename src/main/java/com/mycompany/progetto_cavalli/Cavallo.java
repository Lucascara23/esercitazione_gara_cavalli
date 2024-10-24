/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.progetto_cavalli;
/**
 *
 * @author lucascarabattoli
 */

/**
 *
 * @author lucascarabattoli
 */
public class Cavallo implements Runnable {
    private String nome;
    private int distanzaTotale;    
    private int distanzaPercorsa;  

    
    public Cavallo(String nome, int distanzaTotale) {
        this.nome = nome;
        this.distanzaTotale = distanzaTotale;
        this.distanzaPercorsa = 0;  
    }

    @Override
    public void run() {
        
        while (distanzaPercorsa < distanzaTotale) {
            
            int passo = (int) (Math.random() * 20) + 1;
            distanzaPercorsa += passo;

           
            if (distanzaPercorsa > distanzaTotale) {
                distanzaPercorsa = distanzaTotale;
            }

            
            System.out.println(nome + " ha percorso " + distanzaPercorsa + " metri.");

           
            try {
                Thread.sleep(500);  
            } catch (InterruptedException e) {
                System.out.println(nome + " è stato interrotto durante la corsa.");
                Thread.currentThread().interrupt(); 
            }
        }

        
        System.out.println(nome + " ha terminato la gara!");
    } 
}

       
       

